java
public class Developer extends Employee {
    protected double monthlySalary;

    public Developer(String firstName, String lastName, String ssn) {
        super(firstName, lastName, ssn);
    }

    // Static polymorphism: overloaded methods
    public void setMonthlySalary(int salary) {
        this.monthlySalary = salary;
    }

    public void setMonthlySalary(double salary) {
        this.monthlySalary = salary;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    // Dynamic polymorphism: can be overridden by subclasses
    public double calculateAnnualPayment(boolean goodProfit) {
        double annual = monthlySalary * 12;
        if (goodProfit) {
            annual += 5000; // company profit bonus
        }
        return annual;
    }

    public String getDetails(boolean goodProfit) {
        double total = calculateAnnualPayment(goodProfit);
        return String.format("Name: %s %s%nSSN: %s%nTotal Payment: $%,.2f",
                lastName, firstName, ssn, total);
    }
}