package MachineCodingPractice.ARideSharingApplication;

import MachineCodingPractice.ARideSharingApplication.model.Driver;
import MachineCodingPractice.ARideSharingApplication.model.Rider;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the Rider Name :");
        String riderName = scanner.next();
        Rider rider = new Rider(riderName);

        System.out.println("Enter the Driver Name :");
        String driverName = scanner.next();
        Driver driver = new Driver(driverName);

        System.out.println("Enter id :");
        int id = scanner.nextInt();
        System.out.println("Enter origin :");
        int origin = scanner.nextInt();
        System.out.println("Enter destination :");
        int destination = scanner.nextInt();
        System.out.println("Enter seat :");
        int seat = scanner.nextInt();

        rider.createRide(rider, id,riderName, origin,destination,seat );

        int amount = rider.closeRide();

        System.out.println("Amount : " + amount);

    }
}
