package com.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService  {
    /*Creating an object of enum class, IOService
            which is storing variable constants CONSOLE_IO, FILE_IO, DB_IO, REST_IO */
    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}

    //Declaring a list variable of EmployeePayroll class
    private List<EmployeePayroll> employeePayrollList;

    //Generated default constructor
    public EmployeePayrollService() {
    }

    //Generated parameterised constructor having variable as EmployeePayroll class
    public EmployeePayrollService(List<EmployeePayroll> employeePayrolls) {
        this.employeePayrollList = employeePayrolls;
    }

    //Main method
    public static void main(String[] args) throws IOException {
        ArrayList<EmployeePayroll> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeePayroll(consoleInputReader);
        employeePayrollService.writeEmployeePayroll(IOService.CONSOLE_IO);
    }

    //Method to read data written in the console
    public void readEmployeePayroll(Scanner consoleInputReader){
        System.out.println("Enter employee ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter employee name: ");
        String name = consoleInputReader.next();
        System.out.println("Enter employee salary: ");
        double salary = consoleInputReader.nextInt();
        employeePayrollList.add(new EmployeePayroll(id,name,salary));
    }

    //Method to write data from console
    public void writeEmployeePayroll(IOService ioService){
        if(ioService.equals(IOService.CONSOLE_IO))
        System.out.println("Writing employee payroll into console: \n"+employeePayrollList);
    else if(ioService.equals(IOService.FILE_IO))
        new EmployeePayrollFileIOService().writeData(employeePayrollList);
    }

    public void printData(IOService ioService) {
    if(ioService.equals(IOService.FILE_IO))
        new EmployeePayrollFileIOService().printData();
    }

    public int countEntries(IOService ioService) {
    if(ioService.equals(IOService.FILE_IO))
        return new EmployeePayrollFileIOService().countEntries();
        return 0;
    }
}
