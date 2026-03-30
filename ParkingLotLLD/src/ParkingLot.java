import java.util.*;

class ParkingLot {

    Map<Integer, EntryGate> gates = new HashMap<>();
    Map<SlotType, Double> rates = new HashMap<>();

    public ParkingLot() {
        rates.put(SlotType.SMALL, 10.0);
        rates.put(SlotType.MEDIUM, 20.0);
        rates.put(SlotType.LARGE, 30.0);
    }

    public void addGate(int id, EntryGate gate) {
        gates.put(id, gate);
    }

    // API 1
    public Ticket park(Vehicle vehicle, long entryTime, SlotType requestedType, int gateId) {

        EntryGate gate = gates.get(gateId);

        ParkingSlot slot = gate.assignSlot(vehicle);

        if (slot == null) {
            throw new RuntimeException("No slot available");
        }

        slot.isOccupied = true;

        return new Ticket(vehicle, slot, entryTime);
    }

    // API 2
    public void status(ParkingFloor floor) {

        Map<SlotType, Integer> available = new HashMap<>();

        for (ParkingSlot slot : floor.slots) {
            if (!slot.isOccupied) {
                available.put(
                    slot.type,
                    available.getOrDefault(slot.type, 0) + 1
                );
            }
        }

        System.out.println("Available slots: " + available);
    }

    // API 3
    public double exit(Ticket ticket, long exitTime) {

        long durationHours = (exitTime - ticket.entryTime) / (1000 * 60 * 60);
        durationHours = Math.max(durationHours, 1);

        double rate = rates.get(ticket.slot.type);

        ticket.slot.isOccupied = false;

        return durationHours * rate;
    }
}