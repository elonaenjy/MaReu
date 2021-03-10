package com.example.mareu.Model;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.text.ParseException;
import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private MutableLiveData<List<Meeting>> lMeetings;

    //*************** LiveData
    public MyViewModel(Application application) {
        super( application );
        lMeetings = new MutableLiveData<>();
        try {
            lMeetings.postValue( Meeting.generateMeetings() );
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public MutableLiveData<List<Meeting>> getMeeting() {
        return lMeetings;
    }

    public void setMutableLiveDataMeetingsList(List<Meeting> listMeetings) {
        lMeetings = new MutableLiveData<>();
        lMeetings.setValue( listMeetings );
    }

}






