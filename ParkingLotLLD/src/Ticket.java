class Ticket {
    Vehicle vehicle;
    ParkingSlot slot;
    long entryTime;

    public Ticket(Vehicle vehicle, ParkingSlot slot, long entryTime) {
        this.vehicle = vehicle;
        this.slot = slot;
        this.entryTime = entryTime;
    }
}