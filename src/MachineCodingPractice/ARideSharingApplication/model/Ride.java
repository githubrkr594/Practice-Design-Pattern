package MachineCodingPractice.ARideSharingApplication.model;

import MachineCodingPractice.ARideSharingApplication.RideStatus;

public class Ride {
    private static final int AMOUNT_PER_KM = 10;
    private int id;
    private int origin;
    private int destination;
    private int seats;
    private RideStatus status;

    public Ride() {
        id = origin = destination = 0;
        status = RideStatus.IDLE;
    }

     public int calculateFareAmount(boolean priority) {

        int totalDistanceTravel = destination-origin;
        if(seats>2){
            return (int) ((int)AMOUNT_PER_KM*totalDistanceTravel* (priority ? 0.75 : 1));
        }
        else
        {
            return (int) ((int)AMOUNT_PER_KM * seats * totalDistanceTravel * (priority ? 0.50 : 0.75));
        }
     }


    public void setId(int id) {
        this.id = id;
    }

    public void setOrigin(int origin) {
        this.origin = origin;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getId() {
        return id;
    }

    public void setStatus(RideStatus rideStatus) {
        this.status = rideStatus;
    }

    public RideStatus getStatus() {
        return status;
    }
}
