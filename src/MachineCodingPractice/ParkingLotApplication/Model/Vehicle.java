package MachineCodingPractice.ParkingLotApplication.Model;

public class Vehicle {
    private String vehicleColor;
    private VehicleType vehicleType;
    private String registrationNumber;


    public Vehicle(String vehicleColor, VehicleType vehicleType, String registrationNumber) {
        this.vehicleColor = vehicleColor;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
