package ait.employee.model;

public class SalesManager extends Employee {
    private double salesValue;
    private double perzent;

    public SalesManager(int id, String firstNAme, String lastNAme, double hours, double salesValue, double perzent) {
        super(id, firstNAme, lastNAme, hours);
        this.salesValue = salesValue;
        this.perzent = perzent;
    }

    public double getSalesValue() {
        return salesValue;
    }

    public double getPerzent() {
        return perzent;
    }

    public void setSalesValue(double salesValue) {
        this.salesValue = salesValue;
    }

    public void setPerzent(double perzent) {
        this.perzent = perzent;
    }

    @Override
    public double calcSalary() {
        double salary = salesValue * perzent;
        return ensureSalary(salary);
    }

}
