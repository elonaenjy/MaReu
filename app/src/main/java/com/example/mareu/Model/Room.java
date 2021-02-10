package com.example.mareu.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Room implements Serializable {

        /** Identifier */
        private long idRoom;

        /** Full name */
        private String name;

        /** Avatar */
        private String image;

        /**
         * Constructor
         * @param idRoom
         * @param name
         * @param image
         */
        public Room(long idRoom, String name, String image) {
            this.idRoom = idRoom;
            this.name = name;
            this.image = image;
        }

        public long getIdRoom() {
            return idRoom;
        }

        public void setIdRoom(long idRoom) {
            this.idRoom = idRoom;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        private static List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room(1, "Etretat", "Etretat.jpg" ),
            new Room(2, "Cameroun", "Cameroun.jpg"),
            new Room(3, "Grand Canyon", "GrandCanyon.jpg" ),
            new Room(4, "Himalaya", "Himalaya.jpg"),
            new Room(5, "Madagascar", "Madagascar.jpg" ),
            new Room(6, "Rizieres", "Rizieres.jpg"),
            new Room(7, "Rome", "Rome.jpg" ),
            new Room(8, "Tahiti", "Tahiti.jpg"),
            new Room(9, "Vietnam", "Vietnam.jpg" ),
            new Room(10, "Cascade", "Cascade.jpg")
        );

        static List<Room> generateRooms() {
        return new ArrayList<>(DUMMY_ROOMS);
    }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Room room = (Room) o;
            return Objects.equals(idRoom,room.idRoom);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idRoom);
        }

    }


