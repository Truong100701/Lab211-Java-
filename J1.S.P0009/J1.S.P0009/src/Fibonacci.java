/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The Fibonacci class calculates the Fibonacci sequence.
 * It provides a method to print the first n terms of the Fibonacci sequence.
 *
 * @author truon
 */
public class Fibonacci {

    /**
     * The main method is the entry point of the program. It prints the first 45
     * terms of the Fibonacci sequence.
     *
     * @param args the command line arguments
     */
//    public static void main(String[] args) {
//        // TODO code application logic here
//
//        Fibonacci fibonacci = new Fibonacci();
//        System.out.println("First 45 sequence fibonaci: ");
//        fibonacci.fibonancci(45, 1, 0);
//        System.out.println("");
//        System.out.println("Cach 2: ");
//        int n = 45;
//        for (int i = 0; i < n-1; i++) {
//            System.out.print(fibonacci.cach2(i) + " ");
//        }
//    }
    /**
     * The fibonacci method calculates the nth term of the Fibonacci sequence
     * recursively. It prints each term in the sequence.
     *
     * @param term the number of terms to print
     * @param lower the lower term in the sequence
     * @param higher the higher term in the sequence
     * @return the nth term of the Fibonacci sequence
     */
    private int fibonancci(int term, int lower, int higher) {
        if (term < 2) {
            return higher;
        }
        System.out.print(higher + " ");
        return fibonancci(term - 1, higher, higher + lower);
    }

    private int cach2(int n) {
        if (n < 2) {
            return n;
        }
        return cach2(n - 1) + cach2(n - 2);
    }

    private void display(int n) {
        System.out.println("Cach 2: ");
        for (int i = 0; i < n; i++) {
            System.out.print(cach2(i) + " ");
        }
    }

    public static void main(String[] args) {
        int n = 45;

        System.out.println("Fibonacci Sequence:");
        displayFibonacciSequence(n);
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.display(n);
    }

    private static void displayFibonacciSequence(int n) {
        for (int i = 0; i < n; i++) {
            int fibonacciNumber = calculateFibonacci(i);
            System.out.print(fibonacciNumber + " ");
        }
    }

    private static int calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int previousNumber = 0;
        int currentNumber = 1;

        for (int i = 2; i <= n; i++) {
            int nextNumber = previousNumber + currentNumber;
            previousNumber = currentNumber;
            currentNumber = nextNumber;
        }

        return currentNumber;
    }
}
