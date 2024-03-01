package manager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import object.Worker;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import object.SalaryHistory;

/**
 *
 * @author truon
 */
public class Management {

    private List<Worker> workList;
    private List<SalaryHistory> salaryHistory;

    public Management() {
        workList = new ArrayList<>();
        salaryHistory = new ArrayList<>();
        readWorkersFromFile("workers.txt");
        readWorkersHistoryFromFile("historySalary.txt");
    }

    public void addWorker() {

        String fileName = "workers.txt";

        Validation validation = new Validation();

        Scanner scanner = new Scanner(System.in);

        String id, name, workLocation;

        int age;
        double salary;

        id = validation.getId("Enter work id: ", "Id should be unique and not null", workList, 1);
        System.out.print("Enter worker name: ");
        name = scanner.nextLine();
        age = validation.checkInputInt("Enter worker age: ", 18, 50);
        salary = validation.checkDoubleInput("Enter worker salary: ", 0.1, Double.MAX_VALUE);
        System.out.print("Enter work location: ");
        workLocation = scanner.nextLine();

        workList.add(new Worker(id, name, age, salary, workLocation));
        writeWorkersToFile(fileName);
    }

    public void updateSalary(int mode) {
        Validation validation = new Validation();
        String id = validation.getId("Enter worker id to be updated: ",
                "ID must exist in database and not null", workList, 2);
        double money = validation.checkDoubleInput("Amount of money: ", 0.1, Double.MAX_VALUE);
        Worker worker = validation.idExistWorker(id, workList);
        double updateMoney = 0;
        String status = "";
        if (mode == 1) {
            updateMoney = worker.getSalary() + money;
            status = "up";
        } else if (mode == 2) {
            if (worker.getSalary() > money) {
                updateMoney = worker.getSalary() - money;
                status = "down";
            } else {
                updateMoney = 0;
            }
        }

        worker.setSalary(updateMoney);
        salaryHistory.add(new SalaryHistory(id, worker.getName(), worker.getAge(),
                worker.getSalary(), status, java.time.LocalDate.now()));

        writeWorkersToFile("workers.txt");
        writeSalaryHistoryToFile("historySalary.txt");
    }

    public void getInformation() {
        if (salaryHistory.isEmpty()) {
            System.out.println("List is empty!!!");
            return;
        }
        display(salaryHistory);
    }

    public void displayAll() {
        System.out.println(String.format("%-5s  %-8s  %2s  %-7s  %15s", 
                "ID", "Name", "Age", "Salary", "Work Location"));

        if (workList.isEmpty()) {
            System.out.println("No wokers in the list!!!");
            return;
        }
        //readWorkersFromFile(fileName);
        display(workList);
    }

    public void displayHistorySalary() {
        System.out.println(String.format("%-8s         %-8s  %-2s  %-7s  %-4s  %-10s", 
                "ID", "Name", "Age", "UpdateSalary", "Status", "Date"));
        if (salaryHistory.isEmpty()) {
            System.out.println("No wokers history in the list!!!");
            return;
        }
        display(salaryHistory);
    }

    public void display() {
        for (Worker worker : workList) {
            System.out.println(worker);
        }
    }

    public void display(List list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    public void readWorkersFromFile(String fileName) {
        // workList.clear(); // Xóa danh sách workList trước khi đọc dữ liệu mới
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] workerData = line.split(",");
                if (workerData.length == 5) {
                    String id = workerData[0];
                    String name = workerData[1];
                    int age = Integer.parseInt(workerData[2]);
                    double salary = Double.parseDouble(workerData[3]);
                    String workLocation = workerData[4];

                    workList.add(new Worker(id, name, age, salary, workLocation));
                }
            }

            bufferedReader.close();
            fileReader.close();

            System.out.println("Workers data has been read from the file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed to read workers data from the file.");
            e.printStackTrace();
        }
    }

    public void writeWorkersToFile(String fileName) {
        try {
            // Tạo đối tượng File
            File file = new File(fileName);
            // Kiểm tra sự tồn tại của file
            if (!file.exists()) {
                System.out.println("File does not exist. Creating a new file: " + fileName);
                file.createNewFile();
            }
            // Xóa nội dung file cũ
            FileWriter fileWriter = new FileWriter(file, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(""); // Ghi chuỗi rỗng để xóa nội dung file
            bufferedWriter.close();

            // Ghi danh sách workList vào file
            fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (Worker worker : workList) {
                bufferedWriter.write(worker.getId() + ","
                        + worker.getName() + ","
                        + worker.getAge() + ","
                        + worker.getSalary() + ","
                        + worker.getWorkLocation());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Workers data has been written to the file.");
        } catch (IOException e) {
            System.out.println("Failed to write workers data to the file.");
            e.printStackTrace();
        }
    }

    public void writeSalaryHistoryToFile(String fileName) {
        try {// Xóa nội dung file cũ
            FileWriter fileWriter = new FileWriter(fileName, false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(""); // Ghi chuỗi rỗng để xóa nội dung file
            bufferedWriter.close();
            fileWriter.close();

            fileWriter = new FileWriter(fileName, true);
            bufferedWriter = new BufferedWriter(fileWriter);

            // Ghi thông tin lịch sử lương vào file
            for (SalaryHistory history : salaryHistory) {
                bufferedWriter.write(history.getId() + ","
                        + history.getName() + ","
                        + history.getAge() + ","
                        + history.getUpdateSalary() + ","
                        + history.getStatus() + ","
                        + history.getDate());
                bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();

            System.out.println("Salary history has been written to the file.");
        } catch (IOException e) {
            System.out.println("Failed to write salary history to the file.");
            e.printStackTrace();
        }
    }

    public void readWorkersHistoryFromFile(String fileName) {
        //salaryHistory.clear(); // Xóa danh sách workList trước khi đọc dữ liệu mới
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] historyData = line.split(",");
                if (historyData.length == 6) {
                    String id = historyData[0];
                    String name = historyData[1];
                    int age = Integer.parseInt(historyData[2]);
                    double salary = Double.parseDouble(historyData[3]);
                    String workLocation = historyData[4];
                    LocalDate date = LocalDate.parse(historyData[5]);

                    salaryHistory.add(new SalaryHistory(id, name, age, salary,
                            workLocation, date));
                }
            }

            bufferedReader.close();
            fileReader.close();

            System.out.println("Workers data has been read from the file.");
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed to read workers data from the file.");
            e.printStackTrace();
        }
    }
}
