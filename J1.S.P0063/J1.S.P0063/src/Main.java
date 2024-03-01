
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
class PersonWrapper {

    Person p;

    public PersonWrapper() {
    }

    public PersonWrapper(Person p) {
        this.p = p;
    }
}

public class Main {

    private String checkInputString() {
        Scanner scanner = new Scanner(System.in);
        //loop until user input true value
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty.");
            } else {
                return result;
            }
        }
    }

    private int checkInputInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine());
                if (result <= 0) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException ex) {
                System.err.println("Input must be digit.");
            }
        }
    }

    private double checkInputSalary() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                double result = Double.parseDouble(scanner.nextLine());
                if (result < 0) {
                    System.err.println("Salary is greater than zero");
                    System.out.print("Please input salary: ");
                } else {
                    return result;
                } 
            } catch (NumberFormatException ex) {
                System.err.println("You must input digidt.");
                System.out.print("Please input salary: ");
            }
        }
    }

    private int checkInputNumberStudent() {
        System.out.print("Enter number student: ");
        int n = checkInputInt();
        return n;
    }

    private Person inputPersonInfo() {
        System.out.println("Input Information of Person");
        System.out.print("Please input name: ");
        String name = checkInputString();
        System.out.print("Please input address: ");
        String address = checkInputString();
        System.out.print("Please input salary: ");
        double salary = checkInputSalary();
        return new Person(name, address, salary);
    }

//    private void swap(PersonWrapper person1, PersonWrapper person2) {
//        Person temp = person1.p;
//        person1.p = person2.p;
//        person2.p = temp;
//    }
//
//    private void sortBySalary(Person[] persons, PersonWrapper[] listPersonWrapper) {
//        int n = persons.length;
//
//        for (int i = 0; i < persons.length; i++) {
//            listPersonWrapper[i] = new PersonWrapper(persons[i]);
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (listPersonWrapper[i].p.getSalary() > listPersonWrapper[j].p.getSalary()) {
//                    swap(listPersonWrapper[i], listPersonWrapper[j]);
//                }
//            }
//        }
//        //return;
//    }
    
    
    private void swap(PersonWrapper personOne, PersonWrapper personTwo){
    Person temp = personOne.p;
    personOne.p = personTwo.p;
    personTwo.p = temp;
    }
    
    private void sortBySalary(Person[] person, PersonWrapper[] personWrapper){
    int leng = person.length;
        for (int i = 0; i < leng; i++) {
            personWrapper[i] = new PersonWrapper(person[i]);
        }
        for (int i = 0; i < leng; i++) {
            for (int j = i + 1; j < leng; j++) {
                if(personWrapper[i].p.getSalary() > personWrapper[j].p.getSalary()){
                    swap(personWrapper[i], personWrapper[j]);
                }
            }
        }
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("=====Management Person of Person=====");
        Main main = new Main();
        int n = main.checkInputNumberStudent();
        Person[] persons = new Person[n];
        for (int i = 0; i < persons.length; i++) {
            persons[i] = main.inputPersonInfo();
        }
        PersonWrapper[] listPersonWrapper = new PersonWrapper[persons.length];
        main.sortBySalary(persons, listPersonWrapper);
        for (int i = 0; i < persons.length; i++) {
            listPersonWrapper[i].p.printPersonInformation();
        }

    }

}
