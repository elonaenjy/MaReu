package com.example.mareu;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import com.example.mareu.Model.Meeting;
import com.example.mareu.ViewModels.MeetingViewModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class MaReuUnitTest implements ViewModelStoreOwner {
      private MeetingViewModel viewModel;
      private MutableLiveData<List<Meeting>> lMeetings;
      private MutableLiveData<List<Meeting>> lMeetingsRef;

   // @Before
   // public void setup() throws ParseException {
   //     List<Meeting> lMeetings = Meeting.generateMeetings();
   //     int listSize = lMeetings.size();
   //   }

    /**
     * Test thats the generate listMmeeting function creates a new list comporting 5 items
     */
    @Test
    public void generateListWithSuccess() throws ParseException {
        List<Meeting> lMeetings = Meeting.generateMeetings();
        int listSize = lMeetings.size();
        assertEquals( 5, listSize );
    }

    /**
     * Test thats the add meeting function creates a new meeting to the list
     */
    @Test
    public void addListWithSuccess() throws ParseException {
        viewModel = new MeetingViewModel();

        List<Meeting> lMeetings = Meeting.generateMeetings();
        Meeting aMeeting1 = new Meeting(
                System.currentTimeMillis(),
                9,
                "Ajout 1ère réunion",
                new Date( 1623247200000L ),
                new Date( 1623250800000L ),
                Arrays.asList( 13, 12, 11, 10, 9, 8, 7 )
        );
        try {
            viewModel.addMeeting( aMeeting1 );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int listSize = lMeetings.size();
        assertEquals( 6, listSize );
    }

    /**
     * Test thats the add meeting function creates a new meeting to the list
     */
    @Test
    public void removeListWithSuccess() throws ParseException {
        List<Meeting> lMeetings = Meeting.generateMeetings();
        int listSize = lMeetings.size();
        assertEquals( 5, listSize );
    }


    @NonNull
    @Override
    public ViewModelStore getViewModelStore() {
        return null;
    }
}

