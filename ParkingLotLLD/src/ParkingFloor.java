import java.util.*;

class ParkingFloor {

    List<ParkingSlot> slots;

    public ParkingFloor(List<ParkingSlot> slots) {
        this.slots = slots;
    }

    public ParkingSlot findAvailableSlot(VehicleType vehicleType) {

        for (ParkingSlot slot : slots) {
            if (!slot.isOccupied && isCompatible(vehicleType, slot.type)) {
                return slot;
            }
        }
        return null;
    }

    private boolean isCompatible(VehicleType v, SlotType s) {

        if (v == VehicleType.BIKE) return true;

        if (v == VehicleType.CAR) {
            return s == SlotType.MEDIUM || s == SlotType.LARGE;
        }

        if (v == VehicleType.BUS) {
            return s == SlotType.LARGE;
        }

        return false;
    }
}