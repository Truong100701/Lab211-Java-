
import java.util.ArrayList;
import java.util.List;
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
public class LinearSearch {

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

    private static int sizeOfArray() {
        System.out.println("Enter number of array: ");
        int n = checkInputInt();
        return n;
    }

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
            arr[i] = random.nextInt(10);
        }
        return arr;
    }

    private void display(int[] arr) {

        String result = "";
        result += arr[0];
        for (int i = 1; i < arr.length; i++) {
            result += "," + arr[i];
        }
        System.out.println("[" + result + "]");
    }

//    private int linearSearch(int[] arr, int key) {
//        int leng = arr.length;
//        for (int i = 0; i < leng; i++) {
//            if (arr[i] == key) {
//                return i;
//            }
//        }
//        return -1;
//    }
//    private List<Integer> linearSearch(int[] arr, int key) {
//        int leng = arr.length;
//        int count = 0;
//        List<Integer> listIndex = new ArrayList<>();
//        for (int i = 0; i < leng; i++) {
//            if (arr[i] == key) {
////                count++;
////                if (count == 2) {
////                    listIndex.clear();
////                }
//                listIndex.add(i);
//            }
//        }
//        return listIndex;
//    }
//    private int[] linearSearch(int[] arr, int valueSearch) {
//        int leng = arr.length;
//        int[] result = new int[leng];
//        int countIndex = 0;
//        for (int i = 0; i < leng; i++) {
//            if (arr[i] == valueSearch) {
//                result[countIndex] = i;
//                countIndex++;
//            }
//        }
//        int[] foundIndex = new int[countIndex];
//        System.arraycopy(result, 0, foundIndex, 0, countIndex);
//        return foundIndex;
//    }
    // try hard with use array
    private int[] linearSearch(int[] arr, int valueSearch) {
        int leng = arr.length;
        int[] result = new int[leng];
        int count = 0;
        for (int i = 0; i < leng; i++) {
            if(arr[i] == valueSearch){
            result[count] = i;
            count++;
            }
        }
        int[] foundIndex = new int[count];
        System.arraycopy(result, 0, foundIndex, 0, count);
        return foundIndex;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinearSearch linearSearch = new LinearSearch();
        //Scanner scanner = new Scanner(System.in);
        int sizeOfArray = linearSearch.sizeOfArray();
        System.out.println("Enter search value: ");
        int searchValue = linearSearch.checkInputInt();
        System.out.print("The array: ");
        int[] arr = linearSearch.valueOfArray(sizeOfArray);
        linearSearch.display(arr);

        // TRY HARD with use List
        int[] arrIndex = linearSearch.linearSearch(arr, searchValue);
        if (arrIndex.length > 0) {
            System.out.println("Found " + searchValue + " at: ");
            for (int i = 0; i < arrIndex.length; i++) {
                System.out.println(arrIndex[i] + " ");
            }
        }

        //Hoan chinh
//        List<Integer> indexSearch = linearSearch.linearSearch(arr, searchValue);
//        if (!indexSearch.isEmpty()) {
//            System.out.println("Found " + searchValue + " at index: ");
//            for (int i = 0; i < indexSearch.size(); i++) {
//                System.out.print(indexSearch.get(i));
//                if (i < indexSearch.size() - 1) {
//                    System.out.print(", ");
//                }
//            }
//        } else {
//            System.out.println("Found " + searchValue + " not found!!!");
//        }
//        int[] indexSearch = linearSearch.linearSearch(arr, searchValue);
//        if(indexSearch.length > 0){
//            System.out.println("Found " + searchValue + " at: ");
//            for (int i = 0; i < indexSearch.length; i++) {
//                System.out.print(indexSearch[i]);
//                if(i != indexSearch.length -1){
//                    System.out.print(", ");
//                }
//            }
//        } else{
//                    System.out.println("Not found " + searchValue + " in array!!!");
//        }
//        int index = linearSearch.linearSearch(arr, searchValue);
//        if (index != -1) {
//            System.out.println("Fount " + searchValue + " ar " + index);
//        } else {
//            System.out.println("Not found " + searchValue + " in array!!!");
//        }
    }

}
