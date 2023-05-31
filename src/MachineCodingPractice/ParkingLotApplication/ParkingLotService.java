package MachineCodingPractice.ParkingLotApplication;

import MachineCodingPractice.ParkingLotApplication.Model.*;

import java.util.Objects;
import java.util.Scanner;

public class ParkingLotService {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ParkingLot parkingLot = new ParkingLot("PR1234");

        while (true) {
            System.out.println("Enter command: ");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            switch (tokens[0]) {
                case "create_parking_lot":
                    createParkingLot(parkingLot, tokens);
                    break;
                case "park_vehicle":
                    parkVehicle(parkingLot, tokens);
                    break;
                case "unpark_vehicle":
                    unparkVehicle(parkingLot, tokens);
                    break;
                case "display":
                    display(parkingLot, tokens);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Command Please try again");

            }
        }

    }

    private static void display(ParkingLot parkingLot, String[] tokens) {

        String displayName = tokens[1];
        VehicleType vehicleType = VehicleType.valueOf(tokens[2]);

        if (displayName.equals(DisplayType.FREE_COUNT.getDisplayName())) {
            parkingLot.displayFreeCount(vehicleType);
        }

        if (displayName.equals(DisplayType.OCCUPIED_SLOTS.getDisplayName())) {
            parkingLot.displayOccupiedCount(vehicleType);
        }
        if (displayName.equals(DisplayType.FREE_SLOT.getDisplayName())) {
            parkingLot.displayFreeSlot(vehicleType);
        }

    }

    private static void unparkVehicle(ParkingLot parkingLot, String[] tokens) {

        String ticketId = tokens[1];

        boolean isSuccess = parkingLot.unparkVehicle(ticketId);

        if (isSuccess) {
            System.out.println("Vehicle unparked successfully, ticketId: " + ticketId);
        } else {
            System.out.println("Error while unparking the  vehicle ");
        }

    }

    private static void parkVehicle(ParkingLot parkingLot, String[] tokens) {

        VehicleType vehicleType = VehicleType.valueOf(tokens[1]);
        String registrationNumber = tokens[2];
        String color = tokens[3];

        Vehicle vehicle = new Vehicle(color, vehicleType, registrationNumber);
        Ticket ticket = parkingLot.parkVehicle(vehicle);

        if (Objects.nonNull(ticket)) {
            System.out.println("Vehicle parked successfully, ticketId: " + ticket.getTicketId());
        } else {
            System.out.println("No vehicle Slots found ");
        }

    }

    private static void createParkingLot(ParkingLot parkingLot, String[] tokens) {
        int numberOfFloors = Integer.parseInt(tokens[2]);
        int totalNumberOFSlots = Integer.parseInt(tokens[3]);
        int numberOfTruckSlot = 1;
        int numberOfBikeSlot = 2;
        int numberOfCarSlot = totalNumberOFSlots - (numberOfTruckSlot + numberOfBikeSlot);
        for (int i = 0; i < numberOfFloors; i++) {
            Floor floor = new Floor(i, numberOfTruckSlot, numberOfBikeSlot, numberOfCarSlot);
            parkingLot.addFloor(floor);
        }

        System.out.println("Parking Lot created successfully " + numberOfFloors + " floors");
    }
}
