public class NewDeveloper extends Developer {
    public static final double BASE_MONTHLY = 10000;

    public NewDeveloper(String firstName, String lastName, String ssn) {
        super(firstName, lastName, ssn);
        setMonthlySalary((int) BASE_MONTHLY); // example of calling overloaded int
    }

    @Override
    public double calculateAnnualPayment(boolean goodProfit) {
        return super.calculateAnnualPayment(goodProfit);
    }

    @Override
    public String getDetails(boolean goodProfit) {
        double base = monthlySalary * 12;
        double total = calculateAnnualPayment(goodProfit);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s%nSSN: %s%n", lastName, firstName, ssn));
        sb.append(String.format("Base Annual Salary: $%,.2f%n", base));
        if (goodProfit) sb.append(String.format("Profit Bonus: $5,000.00%n"));
        sb.append(String.format("Total Payment: $%,.2f", total));
        return sb.toString();
    }
}