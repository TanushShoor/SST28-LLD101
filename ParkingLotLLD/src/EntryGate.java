class EntryGate {

    int id;
    ParkingFloor floor;

    public EntryGate(int id, ParkingFloor floor) {
        this.id = id;
        this.floor = floor;
    }

    public ParkingSlot assignSlot(Vehicle vehicle) {
        return floor.findAvailableSlot(vehicle.type);
    }
}