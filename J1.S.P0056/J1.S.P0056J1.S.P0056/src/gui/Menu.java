package gui;

import java.util.Scanner;
import manager.Management;
import manager.Validation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author truon
 */
public class Menu {

    private String[] ops = {
        "Add Worker",
        "Up salary",
        "Down salary",
        "Display Information salary",
        "Display Information all worker",
        "Exist"
    };

    private int getChoice() {
        Validation validation = new Validation();
        Scanner SC = new Scanner(System.in);
        for (int i = 0; i < ops.length; i++) {
            System.out.println((i + 1) + ", " + ops[i]);
        }
        return validation.checkInputInt("Your choice:  ", 1, 6);
    }

    public void display() {
        Management manage = new Management();
        int choice;
        do {
            System.out.println("========= Worker Management =========");
            choice = getChoice();
            switch (choice) {
                case 1:
                    manage.addWorker();
                    break;
                case 2:
                    manage.updateSalary(1);
                    break;
                case 3:
                    manage.updateSalary(2);
                    break;
                case 4:
                    manage.displayHistorySalary();
                    break;
                case 5:
                    manage.displayAll();
                    break;
                case 6:
                    break;
            }
        } while (choice != 6);
    }
}
