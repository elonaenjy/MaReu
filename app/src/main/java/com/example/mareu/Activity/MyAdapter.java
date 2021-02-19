package com.example.mareu.Activity;

import android.content.Context;
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
import com.example.mareu.R;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.Room;

import com.example.mareu.Service.MeetingApiService;

import java.text.DateFormat;
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
    private Context context;

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            context = parent.getContext();
            View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.fragment_item_list, parent, false );
        return new MyViewHolder( view );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        // First line of the meeting : Subject - StartDate - Room
        String subjectMeeting = mMeetings.get( position ).getMeetingSubject();

        Date mDateDebut = mMeetings.get( position ).getMeetingDateDebut();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.MEDIUM,
                DateFormat.MEDIUM, new Locale("FR","fr"));

        int mId = (int) mMeetings.get(position).getIdRoom();

        List<Room> lRoomMeeting = Room.generateRooms();
        String mRoomName = lRoomMeeting.get( mId-1 ).getRoomName();

        int mRoomImage = lRoomMeeting.get( mId-1 ).getRoomImage();

        Glide.with(holder.mMeetingRoomImage.getContext())
                .load(mRoomImage)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mMeetingRoomImage);


  //      holder.mMeetingRoomImage.setImageResource( keyImg);

        // TextHolder for the first line
        String mFirstLineString = subjectMeeting + TEXT_SEPARATOR + shortDateFormat.format( mDateDebut ) + TEXT_SEPARATOR + mRoomName ;
        holder.mFirstLine.setText( mFirstLineString );

        // TextHolder for the second line
        String mGuestList = mMeetings.get(position).getMeetingGuestList();
        holder.mSecondLine.setText( mGuestList);

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

