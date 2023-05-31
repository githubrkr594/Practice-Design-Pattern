package FactoryDesignPattern;
public class Main {
    public static void main(String args[]){
        System.out.println("Welcome to Factory-Design-Pattern learning");

        ShapeFactory shapeFactory = new ShapeFactory();

        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("SQUARE");
        shape3.draw();

        Shape shape4 = shapeFactory.getShape(null);

    }
}
