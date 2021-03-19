package com.example.mareu.Util;

import com.example.mareu.Model.Meeting;

import java.util.ArrayList;
import java.util.List;

public class CalledFunction {

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
}
