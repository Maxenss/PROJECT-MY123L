package com.leonis.leonisandrod.CallPackage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.leonis.leonisandrod.R;
import com.leonis.leonisandrod.TimeWorker;

import java.util.List;

/**
 * Created by Floglor on 08.11.2017.
 */

public class CallAdapter extends ArrayAdapter<Call> {

    public CallAdapter(@NonNull Context context, @NonNull List<Call> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Call call = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.journal_adapter, parent, false);
        }
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageViewCallStatus);

        if(call instanceof ReceivedCall) {
            imageView.setImageResource(R.drawable.ic_call_success_received);
        } else if (call instanceof OutgoingCall) {
            imageView.setImageResource(R.drawable.ic_call_success_outgoing);
        } else if (call instanceof MissedCall) {
            imageView.setImageResource(R.drawable.ic_call_missed);
        } else if (call instanceof MissedOutgoingCall) {
            imageView.setImageResource(R.drawable.ic_call_missed_outgoing);
        }

        if (call instanceof ReceivedCall) {

        }

        TextView tvName = (TextView) convertView.findViewById(R.id.textViewName);
        TextView tvNumber = (TextView) convertView.findViewById(R.id.textViewNumber);
        TextView tvTime = (TextView) convertView.findViewById(R.id.textViewTime);

        String duration;
        assert call != null;

        tvName.setText(call.getCaller().getFirstname());
        tvNumber.setText(call.getCaller().getPhone_number());
        tvTime.setText(TimeWorker.getTimeAgo(call.getTime()));
        return convertView;
    }
}
