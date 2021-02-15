package com.example.mareu.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {

    private long mId;
    private String mRoomName;
    private long mSeats;
    private String mImage;

    public Room(long id, String roomName, long seats, String image) {
        mId = id;
        mRoomName = roomName;
        mSeats = seats;
        mImage = image;
    }


    public long getId() {
        return mId;
    }

    public String getRoomName() {
        return mRoomName;
    }

    public String getRoomImage() {
        return mImage;
    }

}
