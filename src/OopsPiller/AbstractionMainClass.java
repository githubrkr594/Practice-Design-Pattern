package OopsPiller;

import java.util.Scanner;

public class AbstractionMainClass {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius to get Area of Circle:");
        double radius = scanner.nextDouble();
        Circle circle = new Circle(radius);
        System.out.printf("Area of circle is :  %.2f %n", circle.area());
        System.out.printf("Perimeter of circle is :  %.2f %n", circle.perimeter());

    }
}

class Circle {

    private double radius;
    private double pi;


    public Circle(double radius) {
        this.radius = radius;
        this.pi = 3.14;
    }

    public Circle() {
        this.radius = 0;
        this.pi = 3.14;
    }

    public double area(double radius) {
        return pi * radius * radius;
    }

    public double area() {
        return pi * radius * radius;
    }

    public double perimeter(double radius) {
        return 2 * pi * radius;
    }

    public Double perimeter() {
        return 2 * pi * radius;
    }
}

 /*
Note :

As you can see, we only need to define the radius of the circle in the constructor.
After that, the area() and perimeter() functions are available to us.
This interface is part of encapsulation

We use the functions to calculate the area and perimeter.
Users do not need to know the implementation details of the functions.
Even pi is hidden since it’s a constant. This is how we can achieve abstraction using classes.

The following are some advantages of abstraction:
    It reduces the complexity of the system from a user's perspective.
    It makes the code extendable and reusable.
    It refines the modularity of the application or the system.
    It makes the code more maintainable.

*/