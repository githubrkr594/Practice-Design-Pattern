package MachineCodingPractice.ParkingLotApplication;

import MachineCodingPractice.ParkingLotApplication.Model.*;

import java.util.*;

import static MachineCodingPractice.ParkingLotApplication.Model.Constants.PARKING_LOT_ID;

public class ParkingLot {
    private String id;
    private List<Floor> floorList;
    private Map<String, Ticket> activeTickets;

    private static final String DASH = "_";

    public ParkingLot(String id) {
        this.id = id;
        this.floorList = new ArrayList<Floor>();
        this.activeTickets = new HashMap<>();
    }

    public void addFloor(Floor floor) {
        floorList.add(floor);
    }

    public Ticket parkVehicle(Vehicle vehicle) {

        for (Floor floor : floorList) {
            VehicleType vehicleType = vehicle.getVehicleType();

            List<ParkingSlot> parkingSlotList = floor.getParkingSlots();

            for (ParkingSlot parkingSlot : parkingSlotList) {

                if (vehicleType.equals(parkingSlot.getVehicle().getVehicleType()) && parkingSlot.isAvailable()) {

                    parkingSlot.park();
                    String ticketId = getTicketId(parkingSlot, floor);
                    Ticket ticket = new Ticket(ticketId, vehicleType, parkingSlot);
                    activeTickets.put(ticketId, ticket);
                    return ticket;
                }
            }
        }
        return null;
    }

    private String getTicketId(ParkingSlot parkingSlot, Floor floor) {
        StringBuilder sb = new StringBuilder();

        sb.append(PARKING_LOT_ID);
        sb.append(DASH);
        sb.append(parkingSlot.getSlotNo());
        sb.append(DASH);
        sb.append(floor.getFloorNo());

        System.out.println(sb.toString());

        return sb.toString();

    }

    public boolean unparkVehicle(String ticketId) {

        Ticket ticket = activeTickets.get(ticketId);

        if (Objects.nonNull(ticket)) {
            ticket.getParkingSlot().unpark();
            activeTickets.remove(ticketId);
            return true;
        }

        return false;
    }

    public void displayFreeCount(VehicleType vehicleType) {
        System.out.println("This feature is unavailable now " + vehicleType);
    }

    public void displayOccupiedCount(VehicleType vehicleType) {
        int count = 0;

        for (Floor floor : floorList) {
            for (ParkingSlot parkingSlot : floor.getParkingSlots()) {

                if (vehicleType.equals(parkingSlot.getVehicle().getVehicleType()) && !parkingSlot.isAvailable()) {
                    count++;
                }
            }
            System.out.println("Occupied Slots for the vehicle " + vehicleType + " : " + count);
        }
    }


    public void displayFreeSlot(VehicleType vehicleType) {
        int count = 0;

        for (Floor floor : floorList) {
            for (ParkingSlot parkingSlot : floor.getParkingSlots()) {

                if (vehicleType.equals(parkingSlot.getVehicle().getVehicleType()) && parkingSlot.isAvailable()) {
                    count++;
                }
            }
            System.out.println("Free Slots for the vehicle " + vehicleType + " : " + count);
        }
    }
}
