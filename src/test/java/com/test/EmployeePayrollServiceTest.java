package com.test;
import com.main.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class EmployeePayrollServiceTest {

    @Test
    public void givenThreeEmployeesWhenWritten_ShouldMatchEmployeeEntries(){
        EmployeePayroll[] employeePayroll ={
                new EmployeePayroll(1,"Mukesh Ambani", 1000000),
                new EmployeePayroll(2,"Anand Adani",1000000),
                new EmployeePayroll(3,"Aditya Birla",5000000),
                new EmployeePayroll(4,"Shubham Pratap",1000000)
        };
        EmployeePayrollService employeePayrollService;
        employeePayrollService = new EmployeePayrollService(Arrays.asList(employeePayroll));
        employeePayrollService.writeEmployeePayroll(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        int entries = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(4,entries);
    }
}
