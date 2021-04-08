package com.example.mareu.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mareu.Model.Guest;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.Room;
import com.example.mareu.R;
import com.example.mareu.Service.Repository;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Meeting}.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>  {
    private static final String TEXT_SEPARATOR = " - ";
    private List<Meeting> lMeetings;
    private Meeting aMeeting;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.fragment_item_list, parent, false );
        return new MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        List<Room> lRoomsMeeting = Repository.getRooms();
        List<Guest> lGuests = Repository.getGuest();



        // Init : getting the meeting information :
        //          id meeting
        //          id room
        //          meeting startDate
        //          Meeting subject
        //          Meeting GuestList
        //*************** id, name and image Room **************
        int mId = (int) lMeetings.get( position ).getIdRoom();
        String mRoomName = lRoomsMeeting.get( mId - 1 ).getRoomName();
        int mRoomImage = lRoomsMeeting.get( mId - 1 ).getRoomImage();

        //************** Meeting Subject
        String subjectMeeting = lMeetings.get( position ).getMeetingSubject();

        //************** Meeting StartDate
        Date mStartDate = lMeetings.get( position ).getMeetingStartDate();
        DateFormat meetingStartDate = DateFormat.getDateInstance( DateFormat.MEDIUM );

        //************** Meeting StartTime
        DateFormat meetingStartTime = DateFormat.getTimeInstance( DateFormat.SHORT );

        //************** Meeting ListGuest and alim email list
        List<Integer> listGuest = lMeetings.get( position ). getMeetingGuestListId();
        String mGuestListMail = "";
        int nbGuest = listGuest.size() ;
        int idGuest = 0;

        for (int ind = 0; ind < nbGuest; ind ++ ) {
            idGuest = listGuest.get( ind );
            mGuestListMail += lGuests.get( idGuest - 1 ).getGuestMail() + " - ";
        }

        // Image Meeting Room
        Glide.with( holder.mMeetingRoomImage.getContext() )
                .load( mRoomImage )
                .apply( RequestOptions.circleCropTransform() )
                .into( holder.mMeetingRoomImage );

        // First line of the meeting : Subject - StartDate - Room
        String mFirstLineString = subjectMeeting
                + TEXT_SEPARATOR + meetingStartDate.format( mStartDate )
                + TEXT_SEPARATOR + meetingStartTime.format( mStartDate )
                + TEXT_SEPARATOR + mRoomName;
        holder.mFirstLine.setText( mFirstLineString );

        // second line of the meeting : guest list
        holder.mSecondLine.setText( mGuestListMail );

        // Delete button
        deleteButton( holder, position );
    }


    private void deleteButton(@NonNull MyViewHolder holder, final int position) {
        holder.mButtonDeleteMeeting.setOnClickListener( view -> {
            Toast.makeText( view.getContext(), "Suppression de la réunion " + lMeetings.get( position ).getMeetingSubject(), Toast.LENGTH_SHORT ).show();
            Meeting dMeeting = lMeetings.get( position );
            Repository.deleteMeeting( dMeeting );
            setData( lMeetings);
        } );
    }

    @Override
    public int getItemCount() {
        if (lMeetings != null)
            return lMeetings.size();
        else
            return 0;
    }


    public void setData(List<Meeting> meetings) {
        this.lMeetings = lMeetings;
        notifyDataSetChanged(); // dit à l'adapter de se rafraichir
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mMeetingRoomImage;
        TextView mFirstLine;
        TextView mSecondLine;
        ImageButton mButtonDeleteMeeting;

        MyViewHolder(@NonNull View itemView) {
            super( itemView );
            mMeetingRoomImage = itemView.findViewById( R.id.item_image_meeting );
            mFirstLine = itemView.findViewById( R.id.item_meeting_first_line );
            mSecondLine = itemView.findViewById( R.id.item_meeting_second_line );
            mButtonDeleteMeeting = itemView.findViewById( R.id.item_image_meeting_delete );
        }
    }
}

