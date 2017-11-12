package com.leonis.leonisandrod.ContactPackage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.leonis.leonisandrod.R;

import java.util.List;

/**
 * Created by Floglor on 07.11.2017.
 */
//Class for ListView adapt
public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter(@NonNull Context context, @NonNull List<Contact> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contact contact = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.contactlistview_layout, parent, false);
        }

        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvNumber = (TextView) convertView.findViewById(R.id.tvNumber);
        //TextView tvAdapt = (TextView) convertView.findViewById(R.id.tvAdaptive);

        assert contact != null;
        tvName.setText(contact.getName());
        tvNumber.setText(contact.getPhone_number());
        return convertView;
    }
}
