package manager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import object.Worker;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author truon
 */
public class Validation {

    // input: int, double, id
    public int checkInputInt(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            try {
                System.out.print(message);
                number = Integer.parseInt(scanner.nextLine().trim());
                if (number >= min && number <= max) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException ex) {
                System.err.println("Please enter integer number in range: " + min + " to " + max);
                System.out.println("Please enter again: ");
            }
        }
        return number;
    }

    public double checkDoubleInput(String message, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double number;
        while (true) {
            try {
                System.out.print(message);
                number = Double.parseDouble(scanner.nextLine().trim());
                if (number <= min || number <= max) {
                    break;
                }
                throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.err.println("Please enter double number in range: " + min + " to " + max);
                System.out.println("Please enter again: ");
            }
        }
        return number;
    }

    public String getId(String message, String err, List<Worker> workList, int mode) {
        String s;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            s = scanner.nextLine();
            // Mode:
            // 1: input - id not exist
            // 2: update - id must exist
            if (!s.isEmpty()) {
                if ((mode == 1 && idExistWorker(s, workList) == null)
                        || (mode == 2 && idExistWorker(s, workList) != null)) {
                    break;
                }
            }
            System.err.println(err);
        }
        return s;
    }

    public Worker idExistWorker(String id, List<Worker> workerList) {
        for (Worker w : workerList) {
            if (w.getId().equals(id)) {
                return w;
            }
        }
        return null;
    }
}
