package com.example.mareu.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Room {
        /** Identifier */
        private long idRoom;

        /** Full name */
        private String name;

        /**
         * Constructor
         * @param idRoom
         * @param name
         */
        public Room(long idRoom, String name) {
            this.idRoom = idRoom;
            this.name = name;
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

        private static List<Room> DUMMY_ROOMS = Arrays.asList(
            new Room(1, "Etretat" ),
            new Room(2, "Cameroun"),
            new Room(3, "Grand Canyon" ),
            new Room(4, "Himalaya"),
            new Room(5, "Madagascar" ),
            new Room(6, "Rizieres"),
            new Room(7, "Rome" ),
            new Room(8, "Tahiti"),
            new Room(9, "Vietnam" ),
            new Room(10, "Cascade")
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


