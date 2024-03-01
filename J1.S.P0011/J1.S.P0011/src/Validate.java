
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
public class Validate {

    public String checkInputString(String Mess, String Regex) {
        Scanner sc = new Scanner(System.in);
        String txt;
        do {
            System.out.print(Mess);
            txt = sc.nextLine().trim();
            if (txt.matches(Regex)) {
                break;
            }
            System.out.println("Invalid input, plz enter by following: '" + Regex + "'");
        } while (true);
        return txt;
    }

    public int checkInt(String mess, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            System.out.print(mess);
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number >= min && number <= max) {
                    break;
                } else {
                    System.out.println("Out of range, "
                            + "please enter in range (from " + min + " to " + max + ")");
                }
            } catch (NumberFormatException e) {
                System.out.println("Value must be digit!" + e);
            }
        } while (true);
        return number;
    }
}
