package com.example.mareu.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {

    private int mId;
    private String mRoomName;
    private long mSeats;
    private String mImage;
    private static final List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room( 1, "Etretat", 3 , "etretat"),
            new Room( 2, "Himalaya", 10, "himalaya" ),
            new Room( 3, "Laponie", 5, "laponie" ),
            new Room( 4, "Guadeloupe", 7, "guadeloupe" ),
            new Room( 5, "Italie", 2, "rome" ),
            new Room( 6, "Madagascar", 5,"madagascar" ),
            new Room( 7, "Rome", 20, "rome" ),
            new Room( 8, "Tahiti", 10, "tahiti" ),
            new Room( 9, "Thaïlande", 5, "thaïlande" ),
            new Room( 10, "Vietnam", 5, "vietnam"),
            new Room( 11, "Russie", 5, "kremlin")
    );

    public static List<Room> generateRooms() {
        return DUMMY_ROOMS;
    }

    public Room(int id, String mName, long seats, String image) {
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

    public String getRoomImage() {
        return mImage;
    }

}
