package com.example.mareu.Service;

import com.example.mareu.Model.Guest;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.Room;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Repository {

    private static List<Meeting> lMeetings = Meeting.generateMeeting();
    private static List<Guest> lGuests = Guest.generateGuests();
    private static List<Room> lRooms = Room.generateRooms();

    public static List<Meeting> getMeetings() {
        return lMeetings;
    }
    public static List<Room> getRooms() {
        return lRooms;
    }
    public static List<Guest> getGuest() {
        return lGuests;
    }


    public static void deleteMeeting(Meeting dMeeting) {
        lMeetings.remove(dMeeting);
    }

    public static void createMeeting(Meeting aMeeting) {
        lMeetings.add(aMeeting);
    }

    public static List<Meeting> lMeetingsFilteredId(List<Integer> lRoomSelectedId){
        long nbMeetings=lMeetings.size();
        List<Meeting> lMeetingsFiltered=new ArrayList<>();
        long nbRoomSelected=lRoomSelectedId.size();
        int i=0;
        while(i<nbRoomSelected){
            long idRoomSelected=lRoomSelectedId.get(i) + 1 ;
            for(int j=0;j<nbMeetings; j++){
                long idRoomMeeting = lMeetings.get(j).getIdRoom();
                if( idRoomMeeting == idRoomSelected) {
                    lMeetingsFiltered.add( lMeetings.get( j ) );
                }
            }
            i++;
        }
        return lMeetingsFiltered;
    }

    public static List<Meeting> filterMeetingsByDate(int year, int month, int day) {

        List<Meeting> mMeetingsFiltered = new ArrayList<>();
        int size = lMeetings.size();
        for (int e = 0; e < size; e++) {
            Calendar mMeetingsCalendar = Calendar.getInstance();
            mMeetingsCalendar.setTime(lMeetings.get(e).getMeetingStartDate());
            if (year == mMeetingsCalendar.get(Calendar.YEAR)
                    && (month == mMeetingsCalendar.get(Calendar.MONTH))
                    && (day == mMeetingsCalendar.get(Calendar.DAY_OF_MONTH))){
                mMeetingsFiltered.add(lMeetings.get(e));
            }
        }
        return mMeetingsFiltered;
    }

    // ROOM AVAILABILITY CHECKER
    public static boolean checkRoomAvailability(int roomId, Date startDate, Date endDate) {
        boolean roomAvailable = true;
        for (Meeting meetingIterator : lMeetings) {
            if (roomId == (meetingIterator.getIdRoom())
                    && (startDate.after(meetingIterator.getMeetingStartDate())
                    && startDate.before((meetingIterator.getMeetingEndDate()))))
                roomAvailable = false;
            break;
        }
        return roomAvailable;
    }
}