package com.example.mareu.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Room {

    private long mId;
    private String mRoomName;
    private long mSeats;
    private String mImage;
    private static final List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room( 1, "Etretat", 3 , "etretat.jpg"),
            new Room( 2, "Himalaya", 10, "himalaya.jpg" ),
            new Room( 3, "Laponie", 5, "laponie.jpg" ),
            new Room( 4, "Guadeloupe", 7, "guadeloupe.jpg" ),
            new Room( 5, "Etats Unis", 2, "canyon.jpg" ),
            new Room( 6, "Madagascar", 5,"madagascar.jpg" ),
            new Room( 7, "Rome", 20, "rome.jpg" ),
            new Room( 8, "Tahiti", 10, "tahiti.jpg" ),
            new Room( 9, "Thaïlande", 5, "thaïlande.jpg" ),
            new Room( 10, "Vietnam", 5, "vietnam.jpg"),
            new Room( 11, "Russie", 5, "kremlin.jpg")
    );

    public static List<Room> generateRooms() {
        return DUMMY_ROOMS;
    }

    public Room(long id, String mName, long seats, String image) {
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
