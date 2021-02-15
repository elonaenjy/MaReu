package com.example.mareu.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Guest {
    private long mId;
    private String mGuestName;
    private String mGuestUrl;

    public Guest(long id, String guestName, String avatarUrl) {
        mId = id;
        mGuestName = guestName;
        mGuestUrl = avatarUrl;
    }
    private static List<Guest> DUMMY_GUESTS = Arrays.asList(
            new Guest(1, "Paul", "http://clipart-library.com/data_images/163977.jpg"),
            new Guest(2, "Phil", "http://clipart-library.com/newhp/kAibeA8c4.png"),
            new Guest(3, "Guillaume", "http://clipart-library.com/data_images/163960.png"),
            new Guest(4, "Francis", "http://clipart-library.com/data_images/163956.jpg"),
            new Guest(5, "George", "http://clipart-library.com/data_images/163966.jpg"),
            new Guest(6, "Louis", "http://clipart-library.com/data_images/163932.jpg"),
            new Guest(7, "Mateo", "http://clipart-library.com/data_images/163926.jpg"),
            new Guest(8, "April", "http://clipart-library.com/data_images/163935.jpg"),
            new Guest(9, "Louise", "http://clipart-library.com/data_images/163948.png"),
            new Guest(10, "Elodie", "http://clipart-library.com/data_images/163932.jpg"),
            new Guest(11, "Helene", "http://clipart-library.com/data_images/79663.png"),
            new Guest(12, "Fanny", "http://clipart-library.com/data_images/163914.jpg"),
            new Guest(13, "Laura", "http://clipart-library.com/data_images/19601.png"),
            new Guest(14, "Gertrude", "http://clipart-library.com/data_images/163892.jpg"),
            new Guest(15, "Chloé", "http://clipart-library.com/data_images/163914.jpg"),
            new Guest(16, "April", "http://clipart-library.com/images/ziXp7E7iB.png"),
            new Guest(17, "Marie", "http://clipart-library.com/new_gallery/1-15826_free-gold-christmas-ornaments-png-png-download.png"),
            new Guest(18, "Henri", "https://thumbs.dreamstime.com/b/funny-christmas-reindeer-cartoon-holding-wooden-pa-22253100.jpg"),
            new Guest(19, "Rémi", "https://thumbs.dreamstime.com/b/dachshund-christmas-santa-cute-cartoon-character-vector-illustration-happy-dog-wearing-claus-beanie-ready-celebrate-156337318.jpg")
    );

    public long getId() {
        return mId;
    }

    public String getRoomName() {
        return mGuestName;
    }

    public String getRoomImage() {
        return mGuestUrl;
    }

    static List<Guest> generateGuests() {
        return new ArrayList<>( DUMMY_GUESTS );
    }

}
