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
        return super.getDetails(goodProfit);
    }
}