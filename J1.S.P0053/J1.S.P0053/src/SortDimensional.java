
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
public class SortDimensional {

    private int checkInputInt() {
        Scanner scanner = new Scanner(System.in);
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result <= 0) {
                    throw new NumberFormatException();
                }

                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number.");
                System.out.print("Enter again: ");
            }
        }
    }

    private int inputSizeOfArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input Length Of Array");
        System.out.print("Enter number: ");
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number greater than zero.");
                System.out.print("Enter number: ");
            }
        }
    }

    private int[] inputValueOfArray() {
        System.out.print("Enter size of array: ");
        int n = checkInputInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + i + ": ");
            arr[i] = checkInputInt();
        }
        return arr;
    }

    //sort array ascending by bubble sort
    private void sortArrayAscending(int[] a) {

        int leng = a.length;
        if (leng == 0) {
            System.out.println("Array is empty!!!!");
        }

        for (int i = 0; i < leng - 1; i++) {
            for (int j = 0; j < leng - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

//        System.out.println();
//        for (int i = 0; i < a.length; i++) {
//            if (i == a.length - 1) {
//                System.out.print("[" + a[i] + "]");
//                break;
//            }
//            System.out.print("[" + a[i] + "]->");
//        }
//        System.out.println();
    }

    private void display(int[] arr, boolean asc) {
        int leng = arr.length;
        String arrow = asc?"->":"<-";
        for (int i = 0; i < leng; i++) {
            if (i == leng - 1) {
                System.out.print("[" + arr[i] + "]");
                break;
            }
            System.out.print("[" + arr[i] + arrow);
        }
    }

    //sort array ascending by bubble sort
    private void sortArrayDescending(int[] a) {
        int len = a.length;
        if (len == 0) {
            System.err.println("List empty.");
        }
        for (int i = 0; i < len - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (a[j] > a[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                int temp = a[maxIndex];
                a[maxIndex] = a[i];
                a[i] = temp;
            }
        }
//        System.out.println();
//        for (int i = 0; i < a.length; i++) {
//            if (i == a.length - 1) {
//                System.out.print("[" + a[i] + "]");
//                break;
//            }
//            System.out.print("[" + a[i] + "]<-");
//        }
//        System.out.println();
    }

    private int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Input Element");
        System.out.println("2. Sort Ascending");
        System.out.println("3. Sort Desceding");
        System.out.println("4. Exit.");
        System.out.print("Enter your choice: ");
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine());
                if (result < 1 || result > 4) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer 1 to 4.");
                System.out.print("Enter again: ");
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic hereint[] a = new int[0];
        //loop until user want to exit
        SortDimensional sortDimensional = new SortDimensional();
        int[] a = new int[0];
        while (true) {
            int choice = sortDimensional.menu();
            switch (choice) {
                case 1:
                    a = sortDimensional.inputValueOfArray();
                    break;
                case 2:
                    sortDimensional.sortArrayAscending(a);
                    sortDimensional.display(a, true);
                    break;
                case 3:
                    sortDimensional.sortArrayDescending(a);
                    sortDimensional.display(a, false);
                    break;
                case 4:
                    return;
            }
        }
    }
}
