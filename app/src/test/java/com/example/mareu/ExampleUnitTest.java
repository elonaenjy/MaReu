package com.example.mareu;

import com.example.mareu.Model.Meeting;
import com.example.mareu.Service.MeetingApiService;
import com.example.mareu.di.DI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private MeetingApiService service;
    private long idMeeting, idRoom;
    private String meetingSubject, meetingParticipants;
    private DateFormat meetingDate;

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test

    public void createMeetingWithSuccess() {
       Meeting meeting1 = new Meeting( 1, 10, "sujet reunion 1","20210213", "141500", "Part1, Part2, Part3");
       service.createMeeting( meeting1 );
        Meeting meeting2 = new Meeting( 2, 9, "sujet reunion 2","20210212", "143000", "Part1, Part2, Part3");
        service.createMeeting( meeting2 );
        Meeting meeting3 = new Meeting( 3, 8, "sujet reunion 3","20210212", "1110000", "Part1, Part2, Part3");
        service.createMeeting( meeting3 );
        Meeting meeting4 = new Meeting( 4, 7, "sujet reunion 4","20210213", "104300", "Part1, Part2, Part3");
        service.createMeeting( meeting4 );
        Meeting meeting5 = new Meeting( 5, 7, "sujet reunion 5","20210212", "141500", "Part1, Part2, Part3");
        service.createMeeting( meeting5 );
        Meeting meeting6 = new Meeting( 6, 7, "sujet reunion 6","20210213", "150000", "Part1, Part2, Part3");
        service.createMeeting( meeting6 );
        Meeting meeting7 = new Meeting( 7, 6, "sujet reunion 7","20210214", "144500", "Part1, Part2, Part3");
        service.createMeeting( meeting7 );
        Meeting meeting8 = new Meeting( 8, 5, "sujet reunion 8","20210212", "150000", "Part1, Part2, Part3");
        service.createMeeting( meeting8 );
        Meeting meeting9 = new Meeting( 9, 3, "sujet reunion 9","20210212", "104300", "Part1, Part2, Part3");
        service.createMeeting( meeting9 );
        assertTrue( service.getMeeting().contains(meeting1 ) );

    }
}