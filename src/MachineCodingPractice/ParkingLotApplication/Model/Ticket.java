package MachineCodingPractice.ParkingLotApplication.Model;

public class Ticket {
    private String ticketId;
    private VehicleType vehicleType;
    private ParkingSlot parkingSlot;

    public Ticket(String ticketId, VehicleType vehicleType, ParkingSlot parkingSlot) {
        this.ticketId = ticketId;
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }
}
