package com.example.mareu;

import com.example.mareu.Model.Meeting;
import com.example.mareu.Service.MeetingApiService;
import com.example.mareu.di.DI;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void setup() {
        service = DI.getNewInstanceApiService();
    }

    @Test

    public void createMeetingWithSuccess() {

        try {
            Date dateReunion = StringToDate("2015-12-06 17:03:00");

            Meeting meetingToCreate1 = new Meeting( 1 , 1  , dateReunion, "participant1, participants2,participants3","Objet Réunion");
            service.createMeeting( meetingToCreate1 );
            assertTrue( service.getMeetings().contains( meetingToCreate1 ) );

        } catch (ParseException e) {
            e.printStackTrace();
        }

        }