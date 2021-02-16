package com.example.mareu.Activity;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mareu.R;
import com.example.mareu.di.DI;
import com.example.mareu.Model.Meeting;
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
    private List<Meeting> meetings;
    private MeetingApiService apiService;

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from( parent.getContext() )
                .inflate( R.layout.fragment_item_list, parent, false );
        return new MyViewHolder( view );
    }


    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, final int position) {

        // Call the ApiService
        apiService = DI.getMeetingApiService();

        // First line of the meeting : Subject - StartDate - Room
        String subjectMeeting = meetings.get( position ).getMeetingSubject();

        Date mDateDebut = meetings.get( position ).getMeetingDateDebut();
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.MEDIUM,
                DateFormat.MEDIUM, new Locale("FR","fr"));

        long mIdRoom = meetings.get( position ).getIdRoom();
        String roomMeeting = String.valueOf( mIdRoom );

        // TextHolder for the first line

        String mFirstLineString = subjectMeeting + TEXT_SEPARATOR + shortDateFormat.format( mDateDebut ) + TEXT_SEPARATOR + roomMeeting;
        holder.mFirstLine.setText( mFirstLineString );

        // TextHolder for the second line
        String mGuestList = meetings.get(position).getMeetingGuestList();
        holder.mSecondLine.setText( mGuestList);

        // Delete button
        deleteButton( holder, position );
    }

    public void setData(List<Meeting> meetings) {
        this.meetings = meetings;
        notifyDataSetChanged(); // dit à l'adapter de se rafraichir
    }


    private void deleteButton(@NonNull MyViewHolder holder, final int position) {
        holder.mButtonDeleteMeeting.setOnClickListener( view -> {
            Toast.makeText( view.getContext(), "Suppression de la réunion " + meetings.get( position ).getMeetingSubject(), Toast.LENGTH_SHORT ).show();
            deleteItem( position );
            setData( meetings );
        } );
    }

    private void deleteItem(int position) {
        apiService.deleteMeeting( meetings.get( position ) );
    }

    @Override
    public int getItemCount() {
        return meetings.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        final ImageView mColor;
        final TextView mFirstLine;
        final TextView mSecondLine;
        final ImageButton mButtonDeleteMeeting;

        MyViewHolder(@NonNull View itemView) {
            super( itemView );
            mColor = itemView.findViewById( R.id.item_image_meeting );
            mFirstLine = itemView.findViewById( R.id.item_meeting_first_line );
            mSecondLine = itemView.findViewById( R.id.item_meeting_second_line );
            mButtonDeleteMeeting = itemView.findViewById( R.id.item_image_meeting_delete );
        }
    }

}

