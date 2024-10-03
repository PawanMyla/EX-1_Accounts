import java.util.List;
import java.util.Optional;

public class Customer {
    private String customerNumber;
    private String firstName;
    private String surName;
    private PhoneDetails phoneDetails;
    private List<Account> accounts;

    public Customer(String customerNumber, String firstName, String surName,
                    PhoneDetails phoneDetails, List<Account> accounts) {
        this.customerNumber = customerNumber;
        this.firstName = firstName;
        this.surName = surName;
        this.phoneDetails = phoneDetails;
        this.accounts = accounts;
    }

    // Only necessary methods for business logic
    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getFullName() {
        return Optional.ofNullable(surName)
                .filter(s -> !s.isEmpty())
                .map(s -> s + " " + firstName)
                .orElse(firstName); // if surname is null/empty, return firstName alone
    }

    public PhoneDetails getPhoneDetails() {
        return phoneDetails;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
