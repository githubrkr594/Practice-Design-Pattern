package MachineCodingPractice.ParkingLotApplication.Model;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNo;
    private List<ParkingSlot> parkingSlots;

    public Floor(int floorNo) {
        this.floorNo = floorNo;
        this.parkingSlots = new ArrayList<ParkingSlot>();
    }

    public Floor(int floorNo, int numberOfTruckSlot, int numberOfBikeSlot, int numberOfCarSlot) {
        this.floorNo = floorNo;
        this.parkingSlots = new ArrayList<ParkingSlot>();

        for (int i = 0; i < numberOfTruckSlot; i++) {
            this.parkingSlots.add(new ParkingSlot(VehicleType.TRUCK, i));
        }

        for (int i = 0; i < numberOfBikeSlot; i++) {
            this.parkingSlots.add(new ParkingSlot(VehicleType.BIKE, i));
        }

        for (int i = 0; i < numberOfCarSlot; i++) {
            this.parkingSlots.add(new ParkingSlot(VehicleType.CAR, i));
        }

    }

    public void addParkingSlot(ParkingSlot slot) {
        parkingSlots.add(slot);
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public int getFloorNo() {
        return floorNo;
    }
}
