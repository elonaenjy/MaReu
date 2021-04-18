package com.example.mareu.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guest {
    private final int mId;
    private final String mGuestName;
    private final String mGuestUrl;
    private final String mGuestMail;

    public Guest(int id, String guestName, String avatarUrl, String guestMail) {
        mId = id;
        mGuestName = guestName;
        mGuestUrl = avatarUrl;
        mGuestMail = guestMail;
    }


    public int getId() {
        return mId;
    }

    public String getGuestMail() {
        return mGuestMail;
    }
}
