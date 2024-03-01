
import java.util.Random;
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
public class MergeSort {

    /**
     * Phương thức đọc và kiểm tra đầu vào số nguyên nhập từ bàn phím
     *
     * @return trả về số nguyên đã nhập từ bàn phím
     */
    private static int checkInputInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                // System.out.print("Enter number: ");
                int n = Integer.parseInt(scanner.nextLine().trim());
                return n;
            } catch (Exception e) {
                System.err.println("Failed format for input. Please enter again: ");
            }
        }
    }

    /**
     * Phương thức nhập trả về số lượng phần tử của mảng
     *
     * @return Số lượng phần tử của mảng.
     */
    private static int sizeOfArray() {
        System.out.println("Enter number of array: ");
        int n = checkInputInt();
        return n;
    }

    /**
     * Nhập và trả về một mảng các số nguyên.
     *
     * @param n Số lượng phần tử của mảng.
     * @return Mảng các số nguyên đã nhập.
     */
    private int[] valueOfArray(int n) {
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            System.out.print("Enter arr[" + i + "]: ");
//            arr[i] = checkInputInt();
//        }
//        return arr;
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    /**
     * Hiển thị các phần tử của mảng.
     *
     * @param arr Mảng các số nguyên cần hiển thị.
     */
    private void display(int[] arr) {

        String result = "";
        result += arr[0];
        for (int i = 1; i < arr.length; i++) {
            result += "," + arr[i];
        }
        System.out.println("[" + result + "]");
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // tim vi tri o giua
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // viet ham chon hai phan trai va phai voi nhau
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        // ben trai
        int numberOfElementLeft = mid - left + 1;
        int numberOfElementRight = right - mid;

        // Tao mang tam thoi
        int[] arrayTempLeft = new int[numberOfElementLeft];
        int[] arrayTempRight = new int[numberOfElementRight];

        // copy du lieu tu mang arr vao mang vo mang tam thoi de de quan li
        for (int i = 0; i < numberOfElementLeft; i++) {
            arrayTempLeft[i] = arr[left + i];
        }

        for (int i = 0; i < numberOfElementRight; i++) {
            arrayTempRight[i] = arr[mid + i + 1];
        }

        // Gop hai mang theo quy tac phần  tử nhỏ hơn thì sẽ vào trước
        int i = 0; // vi tri hien tai cua mang ben trai
        int j = 0; // vi tri hien tai cua mang ben phai
        int k = left;
        while ((i < numberOfElementLeft) && (j < numberOfElementRight)) {
            if (arrayTempLeft[i] <= arrayTempRight[j]) {
                arr[k] = arrayTempLeft[i];
                i++;
            } else {
                arr[k] = arrayTempRight[j];
                j++;
            }
            k++;
        }

        while (i < arrayTempLeft.length) {
            arr[k] = arrayTempLeft[i];
            i++;
            k++;
        }

        while (j < arrayTempRight.length) {
            arr[k] = arrayTempRight[j];
            j++;
            k++;
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MergeSort mergeSort = new MergeSort();
        System.out.print("Enter number of array: ");
        int n = mergeSort.checkInputInt();
        int[] arr = mergeSort.valueOfArray(n);
        System.out.print("Unsorted array: ");
        mergeSort.display(arr);
        System.out.print("SOrted array: ");
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        mergeSort.display(arr);
    }

}
