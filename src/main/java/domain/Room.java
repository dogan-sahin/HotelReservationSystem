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

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberBeds() {
        return numberBeds;
    }

    public void setNumberBeds(int numberBeds) {
        this.numberBeds = numberBeds;
    }


}
