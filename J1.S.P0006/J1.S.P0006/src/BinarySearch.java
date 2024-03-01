
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
    public class BinarySearch {

        private int checkInputInt() {
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

        private int sizeOfArray() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter size of array: ");
            int sizeOfArray = checkInputInt();
            return sizeOfArray;
        }

        private int[] valueOfArray(int n) {
            Random random = new Random();
            int arr[] = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(10);
            }
            return arr;
        }

        private void display(int[] arr) {
            System.out.print("Sorted array: ");
            int leng = arr.length;
            System.out.print("[");
            for (int i = 0; i < leng; i++) {
                System.out.print(arr[i]);
                if (i != leng - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        private int binarySearch(int[] arr, int keySearch) {
            int left = 0;
            int right = arr.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] == keySearch) {
                    return mid;
                } else if (arr[mid] < keySearch) {
                   right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

        private void bubleSort(int[] arr) {
            int leng = arr.length;
            for (int i = 0; i < leng - 1; i++) {
                for (int j = 0; j < leng - i - 1; j++) {
                    if (arr[j] < arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            // TODO code application logic here

            BinarySearch binarySearch = new BinarySearch();
            int n = binarySearch.sizeOfArray();
            int[] arr = binarySearch.valueOfArray(n);
            binarySearch.bubleSort(arr);
            System.out.println("Enter search value: ");
            int valueSearch = binarySearch.checkInputInt();
            binarySearch.display(arr);
            int bianarySearch = binarySearch.binarySearch(arr, valueSearch);
            if (bianarySearch != - 1) {
                System.out.println("Found " + valueSearch + " at: " + bianarySearch);
            } else {
                System.out.println("Not found!!!");
            }
        }

    }
