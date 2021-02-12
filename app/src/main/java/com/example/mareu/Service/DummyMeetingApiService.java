package com.example.mareu.Service;

import com.example.mareu.Model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class DummyMeetingApiService implements MeetingApiService {

    private List<Meeting> meetings = new ArrayList<>();

    @Override
    public List<Meeting> getMeeting() {
        Meeting meeting1 = new Meeting( 1, 10, "sujet reunion 1","20210213", "141500", "Part1, Part2, Part3");
        createMeeting( meeting1 );
        Meeting meeting2 = new Meeting( 2, 9, "sujet reunion 2","20210212", "143000", "Part1, Part2, Part3");
        createMeeting( meeting2 );
        Meeting meeting3 = new Meeting( 3, 8, "sujet reunion 3","20210212", "1110000", "Part1, Part2, Part3");
        createMeeting( meeting3 );
        Meeting meeting4 = new Meeting( 4, 7, "sujet reunion 4","20210213", "104300", "Part1, Part2, Part3");
        createMeeting( meeting4 );
        Meeting meeting5 = new Meeting( 5, 7, "sujet reunion 5","20210212", "141500", "Part1, Part2, Part3");
        createMeeting( meeting5 );
        Meeting meeting6 = new Meeting( 6, 7, "sujet reunion 6","20210213", "150000", "Part1, Part2, Part3");
        createMeeting( meeting6 );
        Meeting meeting7 = new Meeting( 7, 6, "sujet reunion 7","20210214", "144500", "Part1, Part2, Part3");
        createMeeting( meeting7 );
        Meeting meeting8 = new Meeting( 8, 5, "sujet reunion 8","20210212", "150000", "Part1, Part2, Part3");
        createMeeting( meeting8 );
        Meeting meeting9 = new Meeting( 9, 3, "sujet reunion 9","20210212", "104300", "Part1, Part2, Part3");
        createMeeting( meeting9 );

        return meetings;
    }

    @Override
    public void createMeeting(Meeting meeting) {
        meetings.add(meeting);

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteMeeting(Meeting meeting) {
        meetings.remove(meeting);
    }


}
