package com.example.test4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.test4.Controller.DevicesAdapter;
import com.example.test4.Model.Devices;
import com.example.test4.View.LightFragment;
import com.example.test4.View.ThermostatFragment;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class UserRoomActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ImageButton imageButton;
    private MaterialToolbar materialToolbar;

    ArrayList<Devices> devicesArrayList = new ArrayList<>();
    private DevicesAdapter devicesAdapter;

    private Fragment fragment = null;
    private int mSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) { //просто сделай его статичным
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_room);

        materialToolbar = findViewById(R.id.userroom_toolbar);
        recyclerView = findViewById(R.id.userroom_recycleview);
        imageButton = findViewById(R.id.userroom_imagebtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCreateDialog().show();
            }
        });

    }

    public Dialog onCreateDialog(){
        String[] elements = {"Light", "Thermostat"};
        AlertDialog.Builder alterDialog;

        alterDialog = new AlertDialog.Builder(UserRoomActivity.this);
        alterDialog.setTitle("Add Devices").setSingleChoiceItems(elements, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mSelectedItem = i;
            }
        }).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (mSelectedItem == 0){
                    devicesArrayList.add(new Devices(R.drawable.ic_baseline_add_24, "Light"));
                    devicesAdapter = new DevicesAdapter(getApplicationContext(), devicesArrayList);
                    devicesAdapter.setOnDeviceClickListener(deviceClick());
                    recyclerView.setAdapter(devicesAdapter);
                }
                if (mSelectedItem == 1){
                    devicesArrayList.add(new Devices(R.drawable.ic_baseline_10k_24, "Thermostat"));
                    devicesAdapter = new DevicesAdapter(getApplicationContext(), devicesArrayList);
                    devicesAdapter.setOnDeviceClickListener(deviceClick());
                    recyclerView.setAdapter(devicesAdapter);
                }
                else{
                    dialogInterface.cancel();
                }
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        return alterDialog.create();
    }

    private DevicesAdapter.OnDeviceClick deviceClick() {
        DevicesAdapter.OnDeviceClick deviceClick = new DevicesAdapter.OnDeviceClick() {
            View last = new View(getApplicationContext());
            @Override
            public void OnDeviceClick(View view, int pos) {
                view.setSelected(true);
                if(!last.equals(view)){
                    last.setSelected(false);
                    last = view;
                }
                switch (devicesArrayList.get(pos).iconDevices){
                    case R.drawable.ic_baseline_add_24:
                        fragment = new LightFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.userroom_body, fragment).commit();
                        break;
                    case R.drawable.ic_baseline_10k_24:
                        fragment = new ThermostatFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.userroom_body, fragment).commit();
                        break;
                }
            }
        };
        return deviceClick;
    }
}