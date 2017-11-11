package com.leonis.leonisandrod;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by user on 09.11.2017.
 */

class MessageAdapter extends ArrayAdapter<ChatMessage> {
    public MessageAdapter(@NonNull Context context, @NonNull List<ChatMessage> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater smashInflater = LayoutInflater.from(getContext());
        View customView = smashInflater.inflate(R.layout.contact_row, parent, false);

        ChatMessage chatMessage = getItem(position);

        assert chatMessage != null;
        String dateString = new SimpleDateFormat("dd/MM HH:mm:ss").format(System.currentTimeMillis());

        TextView tvName = (TextView) customView.findViewById(R.id.textViewName);
        TextView messageId = (TextView) customView.findViewById(R.id.messageId);
        TextView timeId = (TextView) customView.findViewById(R.id.timeId);
        ImageView avatarId = (ImageView) customView.findViewById(R.id.avatarId);

        messageId.setText(chatMessage.getMessageText());
        timeId.setText(dateString);
        tvName.setText(chatMessage.getMessageUser());



        return customView;
    }
}