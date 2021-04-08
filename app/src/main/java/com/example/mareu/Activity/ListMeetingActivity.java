package com.example.mareu.Activity;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.example.mareu.Model.Room;
import com.example.mareu.R;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Service.Repository;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ListMeetingActivity extends AppCompatActivity {
    private MyAdapter adapter;

    public boolean[] FILTER_ROOM;    // Keeps memory of the room filter selection
    private Menu menu;
    private final int ADD_MEETING_REQUEST_COODE = 20000;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list_meeting );
        Toolbar toolbar = findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        setUpRecyclerView();

        createNewMeetingAction();
    }

    //  ****************************************** INIT  *******************************************
    private void setUpRecyclerView()  {
        MyAdapter adapter = new MyAdapter();
        RecyclerView recyclerView = findViewById( R.id.list_recycler_view );
        recyclerView.setLayoutManager( new LinearLayoutManager( this ) {
            @Override
            public void onLayoutCompleted(RecyclerView.State state) {
                super.onLayoutCompleted( state );
                recyclerView.smoothScrollToPosition( Integer.MAX_VALUE );
            }
        } );

        recyclerView.setAdapter( adapter );
        adapter.setData(Repository.getMeetings());

        adapter.notifyDataSetChanged();
     }


    //  ****************************************** MENU ********************************************
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        this.menu=menu;
        getMenuInflater().inflate(R.menu.menu_filtre,menu);
        return true;
    }

    //  ****************************************** filter  ****************************************
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        List<Meeting> listMeetingsFiltered = new ArrayList<>();
        switch(id){
            case R.id.menu_filter_date:{
                listMeetingsFiltered = setDateFilter();
                showFilter( listMeetingsFiltered );
                return true;
            }
            case R.id.menu_filter_room:{
                listMeetingsFiltered = setRoomsFilter();
                showFilter( listMeetingsFiltered );
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private List<Meeting> setDateFilter(){
        Calendar mCalendarPicker=Calendar.getInstance();
        // Build an AlertDialog
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        final DatePicker datePicker=new DatePicker(this);
        datePicker.setCalendarViewShown(false);

        builder.setView(datePicker);

        builder.setPositiveButton(R.string.filter_ok_text,(dialog,id)->{
            int year=datePicker.getYear();
            int month=datePicker.getMonth();
            int day=datePicker.getDayOfMonth();
            mCalendarPicker.set(year,month,day);
            List<Meeting> lMeetingsFiltered= Repository.filterMeetingsByDate(year, month, day);
            showFilter(lMeetingsFiltered);

        });
        builder.setNeutralButton(R.string.filter_reset_text,(dialog,id)->{
            deleteFilter();
        });
        builder.show();
        return null;
    }

    private void showFilter(List<Meeting> lMeetingsFiltered) {
        majList = lMeetingsFiltered;
        majListRecycler( majList );
    }

    private void deleteFilter() {
        majList = listMeetings;
        majListRecycler( majList );
    }

    public List<Meeting> setRoomsFilter(){
        // Build an AlertDialog
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        // String array for alert dialog multi choice items
        final int numberRooms=lRoomMeeting.size();
        String[]mRooms=getRoomsAsStringList();
        // Boolean array for initial selected items
        final boolean[]checkedRooms=new boolean[numberRooms];
        // Keep memory of the filter selection
        if(FILTER_ROOM!=null){
            System.arraycopy(FILTER_ROOM,0,checkedRooms,0,numberRooms);
        }

        // Set multiple choice items for alert dialog
        builder.setMultiChoiceItems(mRooms,checkedRooms,(dialog,which,isChecked)->{
            // Update the current focused item's checked status
            checkedRooms[which]=isChecked;
        });
        // Specify the dialog is not cancelable
        builder.setCancelable(false);
        // Set a title for alert dialog
        builder.setTitle(R.string.filter_rooms_text);
        // Set the positive/yes button click listener
        builder.setPositiveButton(R.string.filter_ok_text,(dialog,which)->{
        });
        // Set the negative/no button click listener
        builder.setNeutralButton(R.string.filter_reset_text,(dialog,which)->{
            deleteFilter();
            FILTER_ROOM=null;
        });
        final AlertDialog dialog=builder.create();
        // Display the alert dialog on interface
        dialog.setOnShowListener(dialogInterface->{
            Button button=dialog.getButton(AlertDialog.BUTTON_POSITIVE);
            button.setOnClickListener(view->{
                // Checks the checked rooms
                boolean atLeastOneChecked=false;
                for(boolean checked:checkedRooms){
                    if(checked){
                        atLeastOneChecked=true;
                        break;
                    }
                }
                // if no rooms checked, Toast to alert user
                if(!atLeastOneChecked){
                    Toast toastRoomNotSelected=Toast.makeText(getApplicationContext(),R.string.toast_room_not_selected,Toast.LENGTH_SHORT);
                    toastRoomNotSelected.setGravity(Gravity.CENTER,0,0);
                    View toastViewCreateMeeting=toastRoomNotSelected.getView();
                    TextView toastTextCreateMeeting=toastViewCreateMeeting.findViewById(android.R.id.message);
                    toastTextCreateMeeting.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.toast_add_meeting_color));
                    toastRoomNotSelected.show();
                } else{
                    List<Integer> lRoomSelectedId=filterRoom(checkedRooms);
                    List<Meeting> lMeetingsFiltered=Repository.lMeetingsFilteredId(lRoomSelectedId);
                    dialog.dismiss();
                    showFilter(lMeetingsFiltered);
                    FILTER_ROOM=checkedRooms;
                }
            });
        });
        dialog.show();
                return null;
    }

    public String[]getRoomsAsStringList(){
        int numberRooms;
        numberRooms=lRoomMeeting.size();
        String[]lRooms=new String[numberRooms];
        for(int i=0;i<numberRooms; i++){
            lRooms[i]=String.valueOf(lRoomMeeting.get(i).getRoomName());
        }
        return lRooms;
    }

    // Create a list with the room's selected id
    public List<Integer> filterRoom(boolean[]checkedRooms){
        List<Integer> lRoomSelectedId=new ArrayList<>();

        String[]mRooms=getRoomsAsStringList();
        for(int i=0;i<checkedRooms.length;i++){
            boolean checked=checkedRooms[i];
            if(checked){
                lRoomSelectedId.add(i);
            }
        }
        return lRoomSelectedId;
    }


    //  ****************************************** ACTIONS  ****************************************
    private void createNewMeetingAction(){
        FloatingActionButton mButtonNewMeeting=findViewById(R.id.button_add_meeting);
        mButtonNewMeeting.setOnClickListener(v->{
            Intent addMeetingIntent=new Intent(getApplicationContext(),AddMeetingActivity.class );
            startActivityForResult(addMeetingIntent,ADD_MEETING_REQUEST_COODE);
        });
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data){
        if(requestCode==ADD_MEETING_REQUEST_COODE&&resultCode==RESULT_OK){
            Meeting aMeeting=(Meeting)data.getSerializableExtra("MEETING");
            super.onActivityResult(requestCode,resultCode,data);
        }
    }

    public  void majListRecycler(List<Meeting> listMeetings) {
    }
}