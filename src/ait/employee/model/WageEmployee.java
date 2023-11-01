package ait.employee.model;

public class WageEmployee extends Employee{
    private double wage;

    public WageEmployee(int id, String firstNAme, String lastNAme, double hours, double wage) {
        super(id, firstNAme, lastNAme, hours);
        this.wage = wage;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }
    @Override
    public double calcSalary(){
        double salary = wage * hours;
        return ensureSalary(salary);
    }


}
