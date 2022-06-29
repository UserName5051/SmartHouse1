package com.example.test4.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.test4.Model.Room;
import com.example.test4.R;

import java.util.ArrayList;

public class HomeAdapter extends ArrayAdapter<Room> {

    public HomeAdapter(@NonNull Context context, ArrayList<Room> roomArrayList) {
        super(context, R.layout.listitem_home, roomArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Room room = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_home, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.li_roomImage);
        TextView roomName = convertView.findViewById(R.id.li_roomName);
        TextView numDevices = convertView.findViewById(R.id.li_numDevices);

        imageView.setImageResource(room.icon);
        roomName.setText(room.roomName);
        numDevices.setText(room.numDevices);

        return convertView;
    }
}
