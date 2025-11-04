java
public class Employee {
    protected String firstName;
    protected String lastName;
    protected String ssn;

    public Employee(String firstName, String lastName, String ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getSsn() { return ssn; }
}