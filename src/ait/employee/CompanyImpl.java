package ait.employee;

import ait.employee.dao.Company;
import ait.employee.model.Employee;
import ait.employee.model.SalesManager;

public class CompanyImpl implements Company {
    private Employee[] employees;
    private int size;
    public CompanyImpl(int capasity){
        employees=new Employee[capasity];
    }


    @Override
    public boolean addEmployee(Employee employee) {
        if(employee==null||size== employees.length||findEmloyee(employee.getId())!=null){
            return false;
        }
        employees [size]=employee; // кладем на ячейку сайз и добавляем сайз
        size++;
        return true;
    }

    @Override
    public Employee removeEmployee(int id) {
        Employee employee = findEmloyee(id);
        for (int i = 0; i <size ; i++) {
            if(employee!=null&&employees[i].equals(employee)){
                employees[i] = employees[size-1];
                employees[size-1] = null;
                size--;
                return employee;
            }
        }
        return null;

    }

    @Override
    public Employee findEmloyee(int id) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getId()==id){
                return employees[i];
            }

        }
        return null;
    }

    @Override
    public double totalSalary() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            if(employees[i]!=null){
                sum+=employees[i].calcSalary();
            }

        }
        return sum;
    }

    @Override
    public int quantity() {
        return size;
    }

    @Override
    public double avgSalary() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            if(employees[i]!=null){
                sum+=employees[i].calcSalary();
            }
        }
        return sum/4;
    }

    @Override
    public double totalSalas() {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            if(employees[i]instanceof SalesManager){
                sum +=((SalesManager)employees[i]).getSalesValue();
            }

        }
        return sum;
    }

    @Override
    public void printEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);

        }

    }
}
