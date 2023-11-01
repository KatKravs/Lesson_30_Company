package ait.employee;

import ait.employee.model.Employee;
import ait.employee.model.Manager;
import ait.employee.model.SalesManager;
import ait.employee.model.WageEmployee;

public class EmployeeAppl {
    public static void main(String[] args) {
        Employee[] firm = new Employee[5];
        firm[0] = new Manager(1000, "John", "Smidt", 160, 5000, 5);
        firm[1] = new WageEmployee(2000, "Ann", "Smidt", 160, 15);
        firm[2] = new SalesManager(3000, "Peter", "Jakcson", 160, 1900, 0.1);
        firm[3] = new SalesManager(4000, "Rabindranat", "Ogroval", 80, 20000, 0.1);
        // firm[4]=new Employee(5000, "Ivan", "Idiot", 160);
        printArray(firm);
        double total = totalSalary(firm);
        System.out.println(total);
         total = totalSales(firm);
        System.out.println(total);

    }

    public static void printArray(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println(arr[i].toString());
            }
        }
    }

    public static double totalSalary(Employee[] employees) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null)
                sum += employees[i].calcSalary();


        }
        return sum;
    }

    public static double totalSales(Employee[] employees) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] instanceof SalesManager) {
                sum += ((SalesManager) employees[i]).getSalesValue();// sm=Sa

            }

        }
        return sum;
    }

}
