import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Create slots
        List<ParkingSlot> slots = Arrays.asList(
                new ParkingSlot(1, SlotType.SMALL),
                new ParkingSlot(2, SlotType.MEDIUM),
                new ParkingSlot(3, SlotType.LARGE),
                new ParkingSlot(4, SlotType.LARGE)
        );

        ParkingFloor floor = new ParkingFloor(slots);

        // Create gate
        EntryGate gate1 = new EntryGate(1, floor);

        // Create parking lot
        ParkingLot lot = new ParkingLot();
        lot.addGate(1, gate1);

        // Create vehicle
        Vehicle car = new Vehicle("KA01AB1234", VehicleType.CAR);

        // PARK
        Ticket ticket = lot.park(
                car,
                System.currentTimeMillis(),
                SlotType.MEDIUM,
                1
        );

        System.out.println("Vehicle parked at slot: " + ticket.slot.id);

        // STATUS
        lot.status(floor);

        // EXIT after 2 hours
        long exitTime = System.currentTimeMillis() + (2 * 60 * 60 * 1000);

        double bill = lot.exit(ticket, exitTime);

        System.out.println("Total bill: ₹" + bill);

        // STATUS again
        lot.status(floor);
    }
}