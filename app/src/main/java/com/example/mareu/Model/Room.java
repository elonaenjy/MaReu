package com.example.mareu.Model;

import com.example.mareu.R;

import java.util.Arrays;
import java.util.List;

public class Room {

    private final int mId;
    private final String mRoomName;
    private final int mImage;
    private static final List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room( 1, "Etretat", R.drawable.etretat),
            new Room( 2, "Himalaya",  R.drawable.himalaya ),
            new Room( 3, "Laponie",  R.drawable.laponie),
            new Room( 4, "Guadeloupe", R.drawable.guadeloupe ),
            new Room( 5, "Italie", R.drawable.rome ),
            new Room( 6, "Madagascar" , R.drawable.madagascar),
            new Room( 7, "Asie",  R.drawable.rizieres),
            new Room( 8, "Tahiti", R.drawable.tahiti ),
            new Room( 9, "Thaïlande",R.drawable.thailande ),
            new Room( 10, "Vietnam",R.drawable.vietnam),
            new Room( 11, "Russie", R.drawable.kremlin)
    );

    public static List<Room> generateRooms() {
        return DUMMY_ROOMS;
    }

    public Room(int id, String mName, int image) {
        mId = id;
        mRoomName = mName;
        mImage = image;
    }

    public int getId() {
        return mId;
    }

    public String getRoomName() {
        return mRoomName;
    }

    public int getRoomImage() {
        return mImage;
    }

}
