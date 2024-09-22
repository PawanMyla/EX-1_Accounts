import java.util.List;

public class Customer {
    private String customerNumber;
    private String firstName;
    private String surname;
    private List<PhoneDetails> phoneDetailsList;

    public Customer(String customerNumber, String firstName, String surname, List<PhoneDetails> phoneDetailsList) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.surname = surname;
        this.phoneDetailsList = phoneDetailsList;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getFullName() {
        return surname != null && !surname.isEmpty() ? surname + " " + firstName : firstName;
    }

    public List<PhoneDetails> getPhoneDetailsList() {
        return phoneDetailsList;
    }
}
