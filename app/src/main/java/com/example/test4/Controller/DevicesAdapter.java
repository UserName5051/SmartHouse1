package com.example.test4.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test4.Model.Devices;
import com.example.test4.R;

import java.util.ArrayList;

public class DevicesAdapter extends RecyclerView.Adapter<DevicesAdapter.ViewHolder> {

    ArrayList<Devices> devicesArrayList;
    OnDeviceClick click;
    LayoutInflater inflater;



    public DevicesAdapter(Context applicationContext, ArrayList<Devices> devicesArrayList) {
        inflater = LayoutInflater.from(applicationContext);
        this.devicesArrayList =devicesArrayList;
    }

    @NonNull
    @Override
    public DevicesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.listitem_userroom, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DevicesAdapter.ViewHolder holder, int position) {
        holder.icon.setImageResource(devicesArrayList.get(position).iconDevices);
        holder.devicesName.setText(devicesArrayList.get(position).devicesName);
    }

    @Override
    public int getItemCount() {
        return devicesArrayList.size();
    }
    public interface OnDeviceClick{
        void OnDeviceClick(View view, int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView icon;
        TextView devicesName;
        public ViewHolder(View view) {
            super(view);
            icon = view.findViewById(R.id.list_user_image);
            devicesName = view.findViewById(R.id.list_user_text);
        }

        @Override
        public void onClick(View view) {
            if (click != null){
                click.OnDeviceClick(view, getAdapterPosition());
            }
        }
    }

    public void setOnDeviceClickListener(OnDeviceClick onDeviceClick){
        click = onDeviceClick;
    }
}
