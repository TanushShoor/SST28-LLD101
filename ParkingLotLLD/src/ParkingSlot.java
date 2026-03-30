class ParkingSlot {
    int id;
    SlotType type;
    boolean isOccupied;

    public ParkingSlot(int id, SlotType type) {
        this.id = id;
        this.type = type;
        this.isOccupied = false;
    }
}