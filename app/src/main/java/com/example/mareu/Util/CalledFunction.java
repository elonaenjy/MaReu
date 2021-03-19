package com.example.mareu.Util;

import com.example.mareu.Model.Meeting;

import java.util.List;

public class CalledFunction<listMeeting> {
    public static <listMeetings> List<Meeting> deleteItem(int position, List<Meeting> listMeetings) {
        Meeting dMeeting = listMeetings.get( position );
        listMeetings.remove( dMeeting );
        return listMeetings;
    }

}
