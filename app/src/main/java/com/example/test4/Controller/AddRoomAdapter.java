package com.example.test4.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.test4.Model.AddRoom;
import com.example.test4.R;

import java.util.ArrayList;

public class AddRoomAdapter extends ArrayAdapter<AddRoom> {

    public AddRoomAdapter(@NonNull Context context, ArrayList<AddRoom> addRoomArrayList) {
        super(context, R.layout.listitem_add_room_gridview, addRoomArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        AddRoom addRoom = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem_add_room_gridview, parent, false);
        }

        ImageButton imageButton = convertView.findViewById(R.id.list_addroom_imagebutton);
        TextView textView = convertView.findViewById(R.id.list_addroom_text);

        imageButton.setImageResource(addRoom.icon);
        textView.setText(addRoom.roomName);

        return convertView;
    }
}
