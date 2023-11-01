package ait.employee.model;

public class Manager extends Employee{
    private double baceSalary;
    private int grade;

    public Manager(int id, String firstNAme, String lastNAme, double hours, double baceSalary, int grade) {
        super(id, firstNAme, lastNAme, hours);
        this.baceSalary = baceSalary;
        this.grade = grade;
    }

    public double getBaceSalary() {
        return baceSalary;
    }

    public int getGrade() {
        return grade;
    }

    public void setBaceSalary(double baceSalary) {
        this.baceSalary = baceSalary;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    @Override
    public double calcSalary(){
        double salary = baceSalary + grade * hours;
        return ensureSalary(salary);
    }


}
