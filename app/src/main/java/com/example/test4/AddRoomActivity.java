package com.example.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;

import com.example.test4.Controller.AddRoomAdapter;
import com.example.test4.Model.AddRoom;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class AddRoomActivity extends AppCompatActivity {

    private MaterialToolbar materialToolbar;
    private Button saveBtn;
    private GridView gridView;

    AddRoomAdapter addRoomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);

        gridView = findViewById(R.id.add_room_gridview);

        int[] icon = {R.drawable.ic_launcher_foreground, R.drawable.ic_baseline_account_balance_wallet_24,
        R.drawable.ic_baseline_10k_24, R.drawable.ic_baseline_arrow_back_24,
                R.drawable.ic_baseline_10k_24, R.drawable.ic_baseline_arrow_back_24,
                R.drawable.ic_baseline_10k_24, R.drawable.ic_baseline_arrow_back_24,
                R.drawable.ic_launcher_foreground};

        String[] roomName = {"Kitchen", "BedRoom", "BatchRoom", "Office", "Tv Room", "LivingRoom",
        "Garage", "Toilet", "KidRoom "};

        ArrayList<AddRoom> addRoomArrayList = new ArrayList<>();
        for(int i=0;i<icon.length; i++){
            AddRoom addRoom = new AddRoom(icon[i], roomName[i]);
            addRoomArrayList.add(addRoom);
        }

        addRoomAdapter = new AddRoomAdapter(this, addRoomArrayList);
        gridView.setAdapter(addRoomAdapter);

        materialToolbar = findViewById(R.id.add_room_toolbar);
        materialToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        saveBtn = findViewById(R.id.add_room_save);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}