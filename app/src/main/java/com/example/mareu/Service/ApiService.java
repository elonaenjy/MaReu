package com.example.mareu.Service;

import com.example.mareu.Activity.AddMeetingActivity;
import com.example.mareu.Model.Guest;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.Room;

import java.util.Date;
import java.util.List;

public interface ApiService {

    List<Meeting> getMeetings();

    void deleteMeeting(Meeting meeting);

    void addMeeting(Meeting meeting);

    List<Guest> getGuests();

    List<Room> getRooms();

    String[] getRoomsAsStringList();

    List<String> getGuestsEmails(List<Guest> mGuestList);

    void getGuestsFromEmailsSelected(AddMeetingActivity addMeetingActivity);

    boolean checkRoomAvailability(int roomId, Date startDate, Date endDate) ;

    List<Meeting> lMeetingsFilteredId(List<Integer> lRoomSelectedId);

    List<Meeting> filterMeetingsByDate(int year, int month, int day);

}
