package com.example.test4.View;

import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;

import com.example.test4.AddRoomActivity;
import com.example.test4.Controller.HomeAdapter;
import com.example.test4.MainActivity;
import com.example.test4.Model.Room;
import com.example.test4.R;
import com.example.test4.UserRoomActivity;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel mViewModel;

    private GridView gridView;
    HomeAdapter homeAdapter;
    private ImageButton imageButton;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.home_fragment, container, false);


        gridView = view.findViewById(R.id.home_gridview);

        int[] icon = {R.drawable.ic_baseline_account_balance_wallet_24, R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground};
        String[] roomName = {"Kitchen", "Kid Room", "Toilet"};
        String[] devices = {"devices x1", "devices x2" , "devices x3"};

        ArrayList<Room> roomArrayList = new ArrayList<>();

        for(int i =0; i<icon.length; i++){
            Room room = new Room(icon[i], roomName[i], devices[i]);
            roomArrayList.add(room);
        }

        homeAdapter = new HomeAdapter(getActivity(), roomArrayList);
        gridView.setAdapter(homeAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        imageButton = view.findViewById(R.id.home_add_new_listitem_btn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AddRoomActivity.class);
                startActivity(intent);
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), UserRoomActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }

}