package com.example.mareu.Service;

import com.example.mareu.Model.Guest;
import com.example.mareu.Model.Meeting;
import com.example.mareu.Model.Room;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DummyMeetingGenerator {
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


    static List<Guest> generateGuests() {
        return new ArrayList<>(DUMMY_GUESTS);
    }


}

