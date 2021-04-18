package com.example.mareu.Service;

import com.example.mareu.Model.Guest;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.Room;
import com.example.mareu.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public abstract class DummyApiGenerator {

       private static final List<Guest> DUMMY_GUESTS = Arrays.asList(
            new Guest(1, "Paul", "http://clipart-library.com/data_images/163977.jpg", "Paul@lamzone.com.fr"),
            new Guest(2, "Phil", "http://clipart-library.com/newhp/kAibeA8c4.png", "Phil@lamzone.com"),
            new Guest(3, "Guillaume", "http://clipart-library.com/data_images/163960.png", "Guillaume@lamzone.com"),
            new Guest(4, "Francis", "http://clipart-library.com/data_images/163956.jpg", "Francis@lamzone.com"),
            new Guest(5, "George", "http://clipart-library.com/data_images/163966.jpg", "Georges@lamzone.com"),
            new Guest(6, "Louis", "http://clipart-library.com/data_images/163932.jpg", "Louis@lamzone.com"),
            new Guest(7, "Mateo", "http://clipart-library.com/data_images/163926.jpg", "Mateo@lamzone.com"),
            new Guest(8, "April", "http://clipart-library.com/data_images/163935.jpg", "April@lamzone.com"),
            new Guest(9, "Louise", "http://clipart-library.com/data_images/163948.png", "Louise@lamzone.com"),
            new Guest(10, "Elodie", "http://clipart-library.com/data_images/163932.jpg", "elodie@lamzone..com"),
            new Guest(11, "Helene", "http://clipart-library.com/data_images/79663.png", "helene@lamzone.com"),
            new Guest(12, "Fanny", "http://clipart-library.com/data_images/163914.jpg", "fanny@lamzone.com"),
            new Guest(13, "Laura", "http://clipart-library.com/data_images/19601.png", "laura@lamzone.com"),
            new Guest(14, "Gertrude", "http://clipart-library.com/data_images/163892.jpg", "gertrude@lamzone.com"),
            new Guest(15, "Chloé", "http://clipart-library.com/data_images/163914.jpg", "chloé@lamzone.com"),
            new Guest(16, "Dominique", "http://clipart-library.com/images/ziXp7E7iB.png", "Dominique@lamzone.com"),
            new Guest(17, "Marie", "http://clipart-library.com/new_gallery/1-15826_free-gold-christmas-ornaments-png-png-download.png", "marie@lamzone.com"),
            new Guest(18, "Henri", "https://thumbs.dreamstime.com/b/funny-christmas-reindeer-cartoon-holding-wooden-pa-22253100.jpg", "henri@lamzone.com"),
            new Guest(19, "Rémi", "https://thumbs.dreamstime.com/b/dachshund-christmas-santa-cute-cartoon-character-vector-illustration-happy-dog-wearing-claus-beanie-ready-celebrate-156337318.jpg", "remi@lamzone.com")
    );

    public static List<Guest> generateGuests() {
        return new ArrayList<>(DUMMY_GUESTS);
    }
    public static List<Meeting> generateMeeting() {
        List<Meeting> lMeetingDeb = new ArrayList<Meeting>();
        lMeetingDeb = initList();
        return lMeetingDeb;
    }

    private static List<Meeting> initList() {
// Method used for technical test during the developpment
        List<Meeting> lMeetings = new ArrayList<Meeting>();

        Calendar mCalendarDeb = Calendar.getInstance();
        Calendar mCalendarFin = Calendar.getInstance();
        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        java.util.Date dateDebMeeting = new java.util.Date( mCalendarDeb.getTimeInMillis() );
        java.util.Date dateFinMeeting = new java.util.Date( mCalendarFin.getTimeInMillis() );
        Meeting aMeeting = new Meeting( System.currentTimeMillis(),
                1,
                "Objet Reunion 1",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3,4,6 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 20, 10, 00 );
        mCalendarDeb.set( 2021, 02, 20, 11, 00 );
        dateDebMeeting = new java.util.Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new java.util.Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                8,
                "Objet Reunion 2",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3,4,6 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarDeb.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new java.util.Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new java.util.Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                2,
                "Objet Reunion 3",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 9, 5 ) );
        lMeetings.add( aMeeting );
        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new java.util.Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new java.util.Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                3,
                "Objet Reunion 4",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 6,7,8 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new java.util.Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new java.util.Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                4,
                "Objet Reunion 5",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 3,4,5, 6 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new java.util.Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new java.util.Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                5,
                "Objet Reunion 6",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 1, 2 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new java.util.Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new java.util.Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                6,
                "Objet Reunion 7",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 5,6,7,8,10) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 12, 10, 00 );
        mCalendarFin.set( 2021, 02, 12, 11, 00 );
        dateDebMeeting = new java.util.Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new java.util.Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                7,
                "Objet Reunion 8",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 1,2,3,4,9, 5 ) );
        lMeetings.add( aMeeting );

        mCalendarDeb.set( 2021, 02, 13, 10, 00 );
        mCalendarFin.set( 2021, 02, 13, 11, 00 );
        dateDebMeeting = new java.util.Date( mCalendarDeb.getTimeInMillis() );
        dateFinMeeting = new Date( mCalendarFin.getTimeInMillis() );
        aMeeting = new Meeting( System.currentTimeMillis(),
                10,
                "Objet Reunion 9",
                dateDebMeeting,
                dateFinMeeting,
                Arrays.asList( 1,2,3,4,9, 5 ) );
        lMeetings.add( aMeeting );
        return lMeetings;
    }
    private static final List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room( 1, "Etretat", R.drawable.etretat),
            new Room( 2, "Himalaya",  R.drawable.himalaya ),
            new Room( 3, "Laponie",  R.drawable.laponie),
            new Room( 4, "Guadeloupe", R.drawable.guadeloupe ),
            new Room( 5, "Italie", R.drawable.rome ),
            new Room( 6, "Madagascar" , R.drawable.madagascar),
            new Room( 7, "Asie",  R.drawable.rizieres),
            new Room( 8, "Tahiti", R.drawable.tahiti ),
            new Room( 9, "Thaïlande",R.drawable.thailande ),
            new Room( 10, "Vietnam",R.drawable.vietnam),
            new Room( 11, "Russie", R.drawable.kremlin)
    );

    public static List<Room> generateRooms() {
        return DUMMY_ROOMS;
    }

}
