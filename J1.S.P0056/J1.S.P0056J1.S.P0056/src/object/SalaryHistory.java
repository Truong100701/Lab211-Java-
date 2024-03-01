/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author truon
 */
public class SalaryHistory {
    private String id;
    private String name;
    private int age;
    private double updateSalary;
    private String status;
    private LocalDate date;

    public SalaryHistory() {
    }

    public SalaryHistory(String id, String name, int age, double updateSalary, String status, LocalDate date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.updateSalary = updateSalary;
        this.status = status;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getUpdateSalary() {
        return updateSalary;
    }

    public void setUpdateSalary(double updateSalary) {
        this.updateSalary = updateSalary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format("%s | %-8s | %2d | %-7.1f | %-4s | %-10s", id, name, age, updateSalary, status, date);              
    }
    
}
