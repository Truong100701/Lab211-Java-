
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuickSort {

    private static int checkInputInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int n = Integer.parseInt(scanner.nextLine().trim());
                return n;
            } catch (Exception e) {
                System.err.println("Failed format for input. Please enter again: ");
            }
        }
    }

    private int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    private void display(int[] arr) {
        StringBuilder result = new StringBuilder();
        result.append(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            result.append(",").append(arr[i]);
        }
        System.out.println("[" + result + "]");
    }

    public void quickSort(int[] arr, int low, int high) {
        List<Integer> stack = new ArrayList<>();
        stack.add(low);
        stack.add(high);
        
        while (!stack.isEmpty()) {
            high = stack.remove(stack.size() - 1);
            low = stack.remove(stack.size() - 1);

            int pivot = partition(arr, low, high);  

            if (pivot - 1 > low) {
                stack.add(low);
                stack.add(pivot - 1);
            }

            if (pivot + 1 < high) {
                stack.add(pivot + 1);
                stack.add(high);
            }
        }
    }
    
    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

//    public void quickSort(int[] arr, int low, int high) {
//        if (low < high) {
//            int pi = partition(arr, low, high);
//
//            quickSort(arr, low, pi - 1);
//            quickSort(arr, pi + 1, high);
//        }
//    }
//
//    public int partition(int[] arr, int low, int high) {
//        // Chọn phần tử chủ chốt là phần tử đầu tiên của mảng
//        int pivot = arr[low];
//        int i = low + 1;
//
//        for (int j = low + 1; j <= high; j++) {
//            if (arr[j] < pivot) {
//                // Hoán đổi phần tử arr[j] với phần tử arr[i]
//                int temp = arr[j];
//                arr[j] = arr[i];
//                arr[i] = temp;
//                i++;
//            }
//        }
//
//        // Hoán đổi phần tử chủ chốt (arr[low]) với phần tử arr[i-1]
//        int temp = arr[low];
//        arr[low] = arr[i - 1];
//        arr[i - 1] = temp;
//
//        return i - 1;
//    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        System.out.println("Enter number of array: ");
        int n = checkInputInt();
        int[] arr = quickSort.generateRandomArray(n);

//        System.out.println("Unsorted array: "); 
//        quickSort.display(arr);
        quickSort.quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: ");
        quickSort.display(arr);
    }
}
