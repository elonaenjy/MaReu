package com.example.mareu.Model;

import com.example.mareu.R;

import java.util.Arrays;
import java.util.List;

public class Room {

    private int mId;
    private String mRoomName;
    private long mSeats;
    private int mImage;
    private static final List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room( 1, "Etretat", 3 , R.drawable.etretat),
            new Room( 2, "Himalaya", 10, R.drawable.himalaya ),
            new Room( 3, "Laponie", 5, R.drawable.laponie),
            new Room( 4, "Guadeloupe", 7, R.drawable.guadeloupe ),
            new Room( 5, "Italie", 2, R.drawable.rome ),
            new Room( 6, "Madagascar", 5, R.drawable.madagascar),
            new Room( 7, "Asie", 20, R.drawable.rizieres ),
            new Room( 8, "Tahiti", 10, R.drawable.tahiti ),
            new Room( 9, "Thaïlande", 5,R.drawable.thailande ),
            new Room( 10, "Vietnam", 5,R.drawable.vietnam),
            new Room( 11, "Russie", 5, R.drawable.kremlin)
    );

    public static List<Room> generateRooms() {
        return DUMMY_ROOMS;
    }

    public Room(int id, String mName, long seats, int image) {
        mId = id;
        mRoomName = mName;
        mSeats = seats;
        mImage = image;
    }


    public long getId() {
        return mId;
    }

    public String getRoomName() {
        return mRoomName;
    }

    public int getRoomImage() {
        return mImage;
    }

}
