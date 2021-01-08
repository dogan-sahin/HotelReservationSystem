package domain;

public class Room {

    private static int nextRoomNumber = 0;

    private int roomNumber;
    private int numberBeds;


    public Room(int numberBeds) {
        roomNumber = ++nextRoomNumber;
        this.numberBeds = numberBeds;
    }

    public int getRoomNumber() {
        return roomNumber;
    }


    public int getNumberBeds() {
        return numberBeds;
    }


}
