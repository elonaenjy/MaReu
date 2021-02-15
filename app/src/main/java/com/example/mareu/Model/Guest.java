package com.example.mareu.Model;

public class Guest {
    private long mId;
    private String mGuestName;
    private String mGuestUrl;
    private String mGuestMail;

    public Guest(long id, String guestName, String avatarUrl, String guestMail) {
        mId = id;
        mGuestName = guestName;
        mGuestUrl = avatarUrl;
        mGuestMail = guestMail;
    }

    public long getId() {
        return mId;
    }

    public String getGuestName() {
        return mGuestName;
    }

    public String getGuestUrl() {
        return mGuestUrl;
    }

    public String getGuestMail() {
        return mGuestMail;
    }
}
