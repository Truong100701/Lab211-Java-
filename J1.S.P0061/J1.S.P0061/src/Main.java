
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author truon
 */
public class Main {

    private double checkInputDouble() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                double result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please enter again!!!");
            }
        }
    }

    private Triangle inputTriangle() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Please input side A of Triangle: ");
            double a = checkInputDouble();
            System.out.print("Please input side B of Triangle: ");
            double b = checkInputDouble();
            System.out.print("Please input side C of Triangle: ");
            double c = checkInputDouble();
            if (a + b > c && b + c > a && a + c > b) {
                return new Triangle(a, b, c);
            } else {
                System.out.println("Please enter again: ");
            }
        }
    }

    private Rectangle inputRectangle() {
        System.out.print("Please input side width of Rectangle: ");
        double width = checkInputDouble();
        System.out.print("Please input length of Rectangle: ");
        double length = checkInputDouble();
        return new Rectangle(width, length);
    }

    private Circle inputCircle() {
        System.out.print("Please input radius of Circle: ");
        double radius = checkInputDouble();
        return new Circle(radius);
    }

    private void display(Triangle trigle, Rectangle rectangle, Circle circle) {
        rectangle.printResult();
        circle.printResult();
        trigle.printResult();
    }

    public static void main(String[] args) {

        Main main = new Main();

        Rectangle rectangle = main.inputRectangle();
        Circle circle = main.inputCircle();
        Triangle trigle = main.inputTriangle();

        main.display(trigle, rectangle, circle);
    }
}
