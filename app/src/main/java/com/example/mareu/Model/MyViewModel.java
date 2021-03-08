package com.example.mareu.Model;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private MutableLiveData<List<Meeting>> lMeetings;

    //*************** LiveData
    public MyViewModel(Application application) {
        super( application );
        lMeetings = new MutableLiveData<>();
        lMeetings.postValue( Meeting.generateMeetings() );
    }

    public MutableLiveData<List<Meeting>> getMeeting() {
        return lMeetings;
    }

    public void setMutableLiveDataMeetingsList(List<Meeting> listMeetings) {
        lMeetings = new MutableLiveData<>();
        lMeetings.postValue( listMeetings );
    }
}






