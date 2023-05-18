package javaAssignment1;

//Shape interface
interface Shape {
 double calculateArea();
 double calculatePerimeter();
}

//Circle class implementing the Shape interface
class Circle implements Shape {
 private double radius;

 public Circle(double radius) {
     this.radius = radius;
 }

 @Override
 public double calculateArea() {
     return Math.PI * radius * radius;
 }

 @Override
 public double calculatePerimeter() {
     return 2 * Math.PI * radius;
 }
}

//Triangle class implementing the Shape interface
class Triangle implements Shape {
 private double side1;
 private double side2;
 private double side3;

 public Triangle(double side1, double side2, double side3) {
     this.side1 = side1;
     this.side2 = side2;
     this.side3 = side3;
 }

 @Override
 public double calculateArea() {
     double semiPerimeter = calculatePerimeter() / 2;
     return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
 }

 @Override
 public double calculatePerimeter() {
     return side1 + side2 + side3;
 }
}

//Main class to test the program
public class PolymorphismExample {
 public static void main(String[] args) {
     // Create instances of different shapes
     Shape circle = new Circle(5);
     Shape triangle = new Triangle(3, 4, 5);

     // Calculate and display the area and perimeter of each shape
     System.out.println("Circle:");
     System.out.println("Area: " + circle.calculateArea());
     System.out.println("Perimeter: " + circle.calculatePerimeter());

     System.out.println("\nTriangle:");
     System.out.println("Area: " + triangle.calculateArea());
     System.out.println("Perimeter: " + triangle.calculatePerimeter());
 }
}

