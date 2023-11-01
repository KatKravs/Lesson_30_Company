package ait.employee.test;

import ait.employee.CompanyImpl;
import ait.employee.dao.Company;
import ait.employee.model.Employee;
import ait.employee.model.Manager;
import ait.employee.model.SalesManager;
import ait.employee.model.WageEmployee;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {
    Company company;
    Employee[] firm;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        company = new CompanyImpl(5);
        firm = new Employee[4];
        firm[0] = new Manager(1000, "John", "Smidt", 160, 5000, 5);
        firm[1] = new WageEmployee(2000, "Ann", "Smidt", 160, 15);
        firm[2] = new SalesManager(3000, "Peter", "Jakcson", 160, 1900, 0.1);
        firm[3] = new SalesManager(4000, "Rabindranat", "Ogroval", 80, 20000, 0.1);
        for (int i = 0; i < firm.length; i++) {
            company.addEmployee(firm[i]);

        }

    }

    @org.junit.jupiter.api.Test
    void addEmployee() {
        assertFalse(company.addEmployee(null));
        assertFalse(company.addEmployee(firm[1]));
        Employee employee = new SalesManager(5000, "Rabindranat", "Ogroval", 80, 20000, 0.1);
        assertTrue(company.addEmployee(employee));
        assertEquals(5,company.quantity());
        employee = new SalesManager(6000, "Rabindranat", "Ogroval", 80, 20000, 0.1);
        assertFalse(company.addEmployee(employee));
    }

    @org.junit.jupiter.api.Test
    void removeEmployee() {
        Employee employee = company.removeEmployee(3000);
        assertEquals(firm[2],employee);
        assertEquals(3,company.quantity());
        assertNull(company.removeEmployee(3000));
    }

    @org.junit.jupiter.api.Test
    void findEmloyee() {
        assertEquals(company.findEmloyee(2000),firm[1]);
        assertNull(company.findEmloyee(5000));
    }

    @org.junit.jupiter.api.Test
    void totalSalary() {
        assertEquals(12280, company.totalSalary(),0.01);
    }

    @org.junit.jupiter.api.Test
    void quantity() {
        assertEquals(4, company.quantity());
    }

    @org.junit.jupiter.api.Test
    void avgSalary() {
        assertEquals(12280.0/4,company.avgSalary(),0.01);
    }

    @org.junit.jupiter.api.Test
    void totalSalas() {
        assertEquals(21900,company.totalSalas(),0.01);

    }

    @org.junit.jupiter.api.Test
    void printEmployees() {
        company.printEmployees();
    }
}