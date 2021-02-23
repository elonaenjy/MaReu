package com.example.mareu.Activity;

import android.content.Context;
import android.os.Build;
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
import com.example.mareu.R;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.Room;

import com.example.mareu.Service.MeetingApiService;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Meeting}.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static final String TEXT_SEPARATOR = " - ";
    private List<Meeting> mMeetings;
    private MeetingApiService apiService;
    private List<Guest> lstGuest = Guest.generateGuests();
    private List<Room> lRoomMeeting = Room.generateRooms();


    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
               View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.fragment_item_list, parent, false );
            return new MyViewHolder( view );
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        // Init : getting the meeting information :
        //          id meeting
        //          id room
        //          meeting startDate
        //          Meeting subject
        //          Meeting GuestList

        //*************** id, name and image Room **************
        int mId = (int) mMeetings.get(position).getIdRoom();
        String mRoomName = lRoomMeeting.get( mId-1 ).getRoomName();
        int mRoomImage = lRoomMeeting.get( mId-1 ).getRoomImage();

        //************** Meeting Subject
        String subjectMeeting = mMeetings.get( position ).getMeetingSubject();

        //************** Meeting StartDate
        Date mStartDate = mMeetings.get( position ).getMeetingStartDate();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.MEDIUM,
                DateFormat.MEDIUM, new Locale("FR","fr"));

        //************** Meeting ListGuest and alim email list
        List<Integer> listGuest = mMeetings.get( position ). getMeetingGuestListId();
        String mGuestListMail = "";
        int nbGuest = listGuest.size() ;
        int idGuest = 0;

        System.out.println("nb guest : " +nbGuest);
        for (int ind = 0; ind < nbGuest; ind ++ ) {
            System.out.println("ind : " + ind);
            idGuest = listGuest.get( ind );
            System.out.println("liste guest :"+ idGuest);
            mGuestListMail += lstGuest.get( idGuest - 1 ).getGuestMail() + " - ";
            }

        // Image Meeting Room
        Glide.with(holder.mMeetingRoomImage.getContext())
                .load(mRoomImage)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mMeetingRoomImage);
        // First line of the meeting : Subject - StartDate - Room
        String mFirstLineString = subjectMeeting + TEXT_SEPARATOR + shortDateFormat.format( mStartDate ) + TEXT_SEPARATOR + mRoomName ;
        holder.mFirstLine.setText( mFirstLineString );

        // TextHolder for the second line
        holder.mSecondLine.setText( mGuestListMail );

        // Delete button
        deleteButton( holder, position );
    }

    public void setData(List<Meeting> meetings) {
        this.mMeetings = meetings;
        notifyDataSetChanged(); // dit à l'adapter de se rafraichir
    }

    private void deleteButton(@NonNull MyViewHolder holder, final int position) {
        holder.mButtonDeleteMeeting.setOnClickListener( view -> {
            Toast.makeText( view.getContext(), "Suppression de la réunion " + mMeetings.get( position ).getMeetingSubject(), Toast.LENGTH_SHORT ).show();
            deleteItem( position );
            setData( mMeetings );
        } );
    }

    private void deleteItem(int position) {
        apiService.deleteMeeting( mMeetings.get( position ) );
    }

    @Override
    public int getItemCount() {
        return mMeetings.size();
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

