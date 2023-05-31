package MachineCodingPractice.ARideSharingApplication.model;

import MachineCodingPractice.ARideSharingApplication.RideStatus;

import java.util.List;
import java.util.Objects;

public class Rider extends Person {

    private Ride currentRide;
    private List<Ride> previousRides;

    public Rider(String name) {
        this.name = name;
    }

    public void createRide(Rider rider, int id, String riderName, int origin, int destination, int seats) {

        if (origin >= destination) {
            System.out.println("Can't create Ride, with this information");
            return;
        }

        Ride ride = new Ride();
        ride.setDestination(destination);
        ride.setId(id);
        ride.setOrigin(origin);
        ride.setSeats(seats);
        ride.setStatus(RideStatus.CREATED);

        rider.setCurrentRide(ride);

    }

    public void updateRide(Rider rider, int id, String riderName, int origin, int destination, int seats) {

        if (RideStatus.COMPLETED.equals(currentRide.getStatus())) {
            System.out.println("Can't create Ride, as Ride already created");
            return;
        }

        if (RideStatus.WIDRAWAN.equals(currentRide.getStatus())) {
            System.out.println("Can't create Ride, as Ride Widrawn");
            return;
        }

        createRide(rider, id, riderName, origin, destination, seats);

    }

    public void withdrawRide(int id) {
        if (currentRide.getId() != id) {
            System.out.println("Can't withdraw Ride, as Ride does not exist");
            return;
        }

        currentRide.setStatus(RideStatus.WIDRAWAN);
    }

    public int closeRide() {

        if (currentRide.getStatus() != RideStatus.CREATED) {
            System.out.println("Can't close Ride, as Ride does not exist");
        }
        currentRide.setStatus(RideStatus.COMPLETED);
        if (Objects.isNull(previousRides)) {
            setPreviousRides(List.of(currentRide));
        } else {
            previousRides.add(currentRide);
        }

        return currentRide.calculateFareAmount(previousRides.size() > 10);

    }

    public void setCurrentRide(Ride currentRide) {
        this.currentRide = currentRide;
    }

    public void setPreviousRides(List<Ride> previousRides) {
        this.previousRides = previousRides;
    }
}
