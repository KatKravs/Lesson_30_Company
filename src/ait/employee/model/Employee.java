package ait.employee.model;

public abstract class Employee {


    protected static double minWage=13;
    protected final int id;
    protected String firstNAme;
    protected String lastNAme;
    protected double hours;

    public Employee(int id, String firstNAme, String lastNAme, double hours) {
        this.id = id;
        this.firstNAme = firstNAme;
        this.lastNAme = lastNAme;
        this.hours = hours;
    }
    public static double getMinWage() {
        return minWage;
    }

    public static void setMinWage(double minWage) {
        if(minWage>Employee.minWage) {
            Employee.minWage = minWage;
        }
    }
    protected double ensureSalary(double salary){
        if (salary < hours * minWage) {
            salary = hours * minWage;
        }
        return salary;
    }
    public int getId() {
        return id;
    }

    public String getFirstNAme() {
        return firstNAme;
    }

    public String getLastNAme() {
        return lastNAme;
    }

    public double getHours() {
        return hours;
    }

    public void setFirstNAme(String firstNAme) {
        this.firstNAme = firstNAme;
    }

    public void setLastNAme(String lastNAme) {
        this.lastNAme = lastNAme;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public abstract double calcSalary();


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Employee employee = (Employee) object;

        return id == employee.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee");
        sb.append(" id=").append(id);
        sb.append(", firstNAme='").append(firstNAme).append('\'');
        sb.append(", lastNAme='").append(lastNAme).append('\'');
        sb.append(", hours=").append(hours);
        sb.append(", salary=").append(calcSalary());
        return sb.toString();
    }
}
