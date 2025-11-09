public class JuniorDeveloper extends Developer {
    public static final double BASE_MONTHLY = 13000;

    public JuniorDeveloper(String firstName, String lastName, String ssn) {
        super(firstName, lastName, ssn);
        setMonthlySalary(BASE_MONTHLY); // calls double overload
    }

    @Override
    public double calculateAnnualPayment(boolean goodProfit) {
        double base = monthlySalary * 12;
        double extraOnePercent = base * 0.01; // additional 1% of annual salary
        double total = base + extraOnePercent;
        if (goodProfit) total += 5000;
        return total;
    }

    @Override
    public String getDetails(boolean goodProfit) {
        double base = monthlySalary * 12;
        double extraOnePercent = base * 0.01;
        double total = calculateAnnualPayment(goodProfit);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s%nSSN: %s%n", lastName, firstName, ssn));
        sb.append(String.format("Base Annual Salary: $%,.2f%n", base));
        sb.append(String.format("Additional 1%%: $%,.2f%n", extraOnePercent));
        if (goodProfit) sb.append("Profit Bonus: $5,000.00%n");
        sb.append(String.format("Total Payment: $%,.2f", total));
        return sb.toString();
    }
}