package readModels;

public class AvailableRoom {
    private int roomNumber;
    private int numberBeds;

    public AvailableRoom(int roomNumber, int numberBeds) {
        this.roomNumber = roomNumber;
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
