package com.example.mareu.Model;

import com.example.mareu.R;

import java.util.Arrays;
import java.util.List;

public class Room {

    private int mId;
    private String mRoomName;
    private int mImage;
    private static final List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room( 1, "Etretat", R.raw.etretat),
            new Room( 2, "Himalaya",  R.raw.himalaya ),
            new Room( 3, "Laponie",  R.raw.laponie),
            new Room( 4, "Guadeloupe", R.raw.guadeloupe ),
            new Room( 5, "Italie", R.raw.rome ),
            new Room( 6, "Madagascar" , R.raw.madagascar),
            new Room( 7, "Asie",  R.raw.rizieres ),
            new Room( 8, "Tahiti", R.raw.tahiti ),
            new Room( 9, "Thaïlande",R.raw.thailande ),
            new Room( 10, "Vietnam",R.raw.vietnam),
            new Room( 11, "Russie", R.raw.kremlin)
    );

    public static List<Room> generateRooms() {
        return DUMMY_ROOMS;
    }

    public Room(int id, String mName, int image) {
        mId = id;
        mRoomName = mName;
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
