package com.example.mareu.Util;

import com.example.mareu.Model.Meeting;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Repository {

    public static List<Meeting> addMeeting(Meeting aMeeting, List<Meeting> listMeetings) {
        if (aMeeting != null) {
            listMeetings.add( aMeeting );
        }
        return listMeetings;
    }

    public static List<Meeting> lMeetingsFilteredId(List<Integer> lRoomSelectedId, List<Meeting> listMeetings){
        int nbMeetings=listMeetings.size();
        List<Meeting> lMeetingsFiltered=new ArrayList<>();
        int nbRoomSelected=lRoomSelectedId.size();
        int i=0;
        while(i<nbRoomSelected){
            int idRoomSelected=lRoomSelectedId.get(i) + 1 ;
            for(int j=0;j<nbMeetings; j++){
                int idRoomMeeting = listMeetings.get(j).getIdRoom();
                if( idRoomMeeting == idRoomSelected) {
                    lMeetingsFiltered.add( listMeetings.get( j ) );
                }
            }
            i++;
        }
        return lMeetingsFiltered;
    }


    public static List<Meeting> filterMeetingsByDate(int year, int month, int day, List<Meeting> listMeetings) {
        final List<Meeting> meetings=listMeetings;
        List<Meeting> mMeetingsFiltered = new ArrayList<>();
        int size = meetings.size();
        for (int e = 0; e < size; e++) {
            Calendar mMeetingsCalendar = Calendar.getInstance();
            mMeetingsCalendar.setTime(meetings.get(e).getMeetingStartDate());
            if (year == mMeetingsCalendar.get(Calendar.YEAR)
                    && (month == mMeetingsCalendar.get(Calendar.MONTH))
                    && (day == mMeetingsCalendar.get(Calendar.DAY_OF_MONTH))){
                     mMeetingsFiltered.add(meetings.get(e));
            }
        }
        return mMeetingsFiltered;
    }

    // ROOM AVAILABILITY CHECKER
    public static boolean checkRoomAvailability(int roomId, Date startDate, Date endDate,List<Meeting> meetingList) {
        boolean roomAvailable = true;
        for (Meeting meetingIterator : meetingList) {
                if (roomId == (meetingIterator.getIdRoom())
                        && (startDate.after(meetingIterator.getMeetingStartDate())
                        && startDate.before((meetingIterator.getMeetingEndDate()))))
                    roomAvailable = false;
                    break;
            }
        return roomAvailable;
    }
}
