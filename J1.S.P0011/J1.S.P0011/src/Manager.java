
import java.math.BigInteger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author truon
 */
public class Manager {

    public void menu() {
        Validate validate = new Validate();

        String inputNumber = "";
        while (true) {
            System.out.println("");
            System.out.println("=========Change Base=========");
            int choiceBaseInput = baseInput();
            int choiceBaseOutput = baseOutput();
            switch (choiceBaseInput) {
                case 0:
                    inputNumber = validate.checkInputString("Enter number: ", "^[0-1]+$");
                    break;
                case 1:
                    inputNumber = validate.checkInputString("Enter number: ", "^[0-9]+$");
                    break;
                case 2:
                    inputNumber = validate.checkInputString("Enter number: ", "^[0-9a-fA-F]+$");
                    break;
            }
            System.out.println("After convert base: "
                    + convertBase(inputNumber.toUpperCase(), choiceBaseInput, choiceBaseOutput));
            String c = validate.checkInputString("Do you want to continue?(Y/N) ", "[YyNn]");
            if (c.equalsIgnoreCase("N")) {
                return;
            }
        }
    }

    public int baseInput() {
        Validate validate = new Validate();
        System.out.println("0.Binary base"
                + "\n1.Decimal base"
                + "\n2.Hexadecimal base");
        int choiceInput = validate.checkInt("Base number input: ", 0, 2);
        return choiceInput;
    }

    public int baseOutput() {
        Validate validate = new Validate();
        int choiceOutput = validate.checkInt("Base number output: ", 0, 2);
        return choiceOutput;
    }

//    public String DecimalToOther(String decimal, int base) {
//        String hexacimal = "0123456789ABCDEF";
//
//        int num = Integer.parseInt(decimal);
//        String newNumber = "";
//        while (num > 0) {
//            int digit = num % base;
//            newNumber += hexacimal.charAt(digit);
//            num = num / base;
//        }
//        String result = "";
//        for (int i = newNumber.length() - 1; i >= 0; i--) {
//            result = result + newNumber.charAt(i);
//        }
//        return result;
//    }
    
//    public String DecimalToOther(String decimal, int base) {
//        String hexacimal = "0123456789ABCDEF";
//
//        BigInteger number = new BigInteger(decimal);
//        StringBuilder newNumber = new StringBuilder();
//
//        while (number.compareTo(BigInteger.ZERO) > 0) {
//            BigInteger[] digitAndRemainder = number.divideAndRemainder(BigInteger.valueOf(base));
//            int digit = digitAndRemainder[1].intValue();
//            newNumber.append(hexacimal.charAt(digit));
//            number = digitAndRemainder[0];
//        }
//
//        return newNumber.reverse().toString();
//    }
    public String convertDecimalToOther(String decimal, int base){
    String hexadecimal = "0123456789ABCDEF";
    BigInteger number = new BigInteger(decimal);
    StringBuilder newNumber = new StringBuilder();
    
        while (number.compareTo(BigInteger.ZERO) > 0) {            
            BigInteger[] digitAndRemainder = number.divideAndRemainder(BigInteger.valueOf(base));
            int digit = digitAndRemainder[1].intValue();
            newNumber.append(hexadecimal.charAt(digit));
            number = digitAndRemainder[0];
        }
        return newNumber.reverse().toString();
    }

    public String otherToDecimal(String number, int base) {
        String hexacimal = "0123456789ABCDEF";
        BigInteger decimal = BigInteger.ZERO;

        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = hexacimal.indexOf(number.charAt(i));
            decimal = decimal.add(BigInteger.valueOf(digit)
                    .multiply(BigInteger.valueOf(base).pow(number.length() - 1 - i)));
        }
        return decimal.toString();
    }

    // number - cho biết đầu vào
    // base là cơ số mấy
//    public String otherToDecimal(String number, int base) {
//        String hexacimal = "0123456789ABCDEF";
//
//        int k = 0;
//        int decimal = 0;
//        for (int i = number.length() - 1; i >= 0; i--) {
//            int digit = hexacimal.indexOf(number.charAt(i));
//            decimal = decimal + digit * (int) Math.pow(base, k);
//            k++;
//        }
//        return Integer.toString(decimal);
//    }
    public String convertBase(String number, int choiceBaseInput, int choiceBaseOutput) {
        int[] base = {2, 10, 16};
        if (choiceBaseInput == 1) {
            return DecimalToOther(number, base[choiceBaseOutput]);
        } else if (choiceBaseOutput == 1) {
            return otherToDecimal(number, base[choiceBaseInput]);
        } else {
            String n = otherToDecimal(number, base[choiceBaseInput]);
            return DecimalToOther(n, base[choiceBaseOutput]);
        }
    }
}
