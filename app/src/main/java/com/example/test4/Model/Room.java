package com.example.test4.Model;

public class Room {
    public int icon;
    public String roomName, numDevices;

    public Room(int icon, String roomName, String numDevices) {
        this.icon = icon;
        this.roomName = roomName;
        this.numDevices = numDevices;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getNumDevices() {
        return numDevices;
    }

    public void setNumDevices(String numDevices) {
        this.numDevices = numDevices;
    }
}
