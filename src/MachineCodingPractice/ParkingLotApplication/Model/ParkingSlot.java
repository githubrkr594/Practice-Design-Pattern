package MachineCodingPractice.ParkingLotApplication.Model;

public class ParkingSlot {
    private int slotNo;
    private Vehicle vehicle;
    private boolean isAvailable;

    public ParkingSlot(Vehicle vehicle, int slotNo) {
        this.slotNo = slotNo;
        this.vehicle = vehicle;
        this.isAvailable = true;
    }

    public ParkingSlot(int slotNo) {
        this.slotNo = slotNo;
        this.isAvailable = true;
    }

    public ParkingSlot(VehicleType vehicleType, int i) {
        this.slotNo = i;
        this.vehicle = new Vehicle(vehicleType);
        this.isAvailable = true;
    }

    public void park() {
        this.isAvailable = false;
    }

    public void unpark() {
        this.isAvailable = true;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getSlotNo() {
        return slotNo;
    }
}
