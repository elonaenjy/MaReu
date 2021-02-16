package com.example.mareu.Service;

import com.example.mareu.Model.Guest;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.Room;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
abstract class DummyMeetingGenerator {

    // 05/06/2020 14:00:00 = 1588766400000
    // 05/04/2020 09:00:00 = 1588575600000
    // 1hour = 3600000
    // 1 week = 604800000

    private static final List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room( 1, "Etretat", 3 , "etretat"),
            new Room( 2, "Himalaya", 10, "himalaya" ),
            new Room( 3, "Laponie", 5, "laponie" ),
            new Room( 4, "Guadeloupe", 7, "Guadeloupe" ),
            new Room( 5, "Etats Unis", 2, "canyon" ),
            new Room( 6, "Madagascar", 5,"madagascar" ),
            new Room( 7, "Rome", 20, "rome" ),
            new Room( 8, "Tahiti", 10, "tahiti" ),
            new Room( 9, "Thaïlande", 5, "thaïlande" ),
            new Room( 10, "Vietnam", 5, "vietnam"),
            new Room( 11, "Russie", 5, "kremlin")
    );

    private static List<Guest> DUMMY_GUESTS = Arrays.asList(
            new Guest(1, "Paul", "http://clipart-library.com/data_images/163977.jpg", "Paul@orange.fr"),
            new Guest(2, "Phil", "http://clipart-library.com/newhp/kAibeA8c4.png", "Phil@free.fr"),
            new Guest(3, "Guillaume", "http://clipart-library.com/data_images/163960.png", "Guillaume@hotmail.com"),
            new Guest(4, "Francis", "http://clipart-library.com/data_images/163956.jpg", "Francis@gmail.com"),
            new Guest(5, "George", "http://clipart-library.com/data_images/163966.jpg", "Georges@free.fr"),
            new Guest(6, "Louis", "http://clipart-library.com/data_images/163932.jpg", "Louis@orange.fr"),
            new Guest(7, "Mateo", "http://clipart-library.com/data_images/163926.jpg", "Mateo@outlook.com"),
            new Guest(8, "April", "http://clipart-library.com/data_images/163935.jpg", "Apri@gmail.com"),
            new Guest(9, "Louise", "http://clipart-library.com/data_images/163948.png", "Louise@orange.fr"),
            new Guest(10, "Elodie", "http://clipart-library.com/data_images/163932.jpg", "elodie@gmail.com"),
            new Guest(11, "Helene", "http://clipart-library.com/data_images/79663.png", "helene@hotmail.com"),
            new Guest(12, "Fanny", "http://clipart-library.com/data_images/163914.jpg", "fanny@gmail.com"),
            new Guest(13, "Laura", "http://clipart-library.com/data_images/19601.png", "laura@orange.fr"),
            new Guest(14, "Gertrude", "http://clipart-library.com/data_images/163892.jpg", "gertrude@gmail.com"),
            new Guest(15, "Chloé", "http://clipart-library.com/data_images/163914.jpg", "chloé@hotmail.com"),
            new Guest(16, "Dominique", "http://clipart-library.com/images/ziXp7E7iB.png", "Dominique@outlook.com"),
            new Guest(17, "Marie", "http://clipart-library.com/new_gallery/1-15826_free-gold-christmas-ornaments-png-png-download.png", "marie@orange.fr"),
            new Guest(18, "Henri", "https://thumbs.dreamstime.com/b/funny-christmas-reindeer-cartoon-holding-wooden-pa-22253100.jpg", "henri@free.fr"),
            new Guest(19, "Rémi", "https://thumbs.dreamstime.com/b/dachshund-christmas-santa-cute-cartoon-character-vector-illustration-happy-dog-wearing-claus-beanie-ready-celebrate-156337318.jpg", "remi@free.fr")
    );

    private static List<Meeting> DUMMY_MEETINGS = Arrays.asList(
            new Meeting( 1,1, "Objet Réunion 1",
                    new Date(Long.parseLong("1623247200000")),
                    new Date(Long.parseLong("1623250800000")),
                    ("Marie, Henri, Remy, Fanny, Paul, Henri")
            ),
            new Meeting( 2,2, "Objet Réunion 2",
                    new Date(Long.parseLong("1623247200000")),
                    new Date(Long.parseLong("1623250800000")),
                    ("Helene, Elodie")
            ),
            new Meeting( 3,1, "Objet Réunion 3",
                    new Date(Long.parseLong("1613395800000")),
                    new Date(Long.parseLong("1613399400000")),
                    ("Dominique, Gertrude, Laura")
            ),
            new Meeting( 4,2, "Objet Réunion 4",
                    new Date(Long.parseLong("1613397600000")),
                    new Date(Long.parseLong("1613399400000")),
                    ("Fanny, Paul, Henri")
            )
    );


    static List<Meeting> generateMeetings() {
        return new ArrayList<>(DUMMY_MEETINGS);
    }

    static List<Guest> generateGuests() {
        return new ArrayList<>(DUMMY_GUESTS);
    }

    static List<Room> generateRooms() {
        return new ArrayList<>(DUMMY_ROOMS);
    }

}

