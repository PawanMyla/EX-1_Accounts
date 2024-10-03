import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Create phone details for the customer
        PhoneDetails phoneDetails = new PhoneDetails("1234567890", null,"Primary");

        // Create some account details
        Account account1 = new Account("ACC001", 15000.50, Arrays.asList("MODE1", "MODE2"));
        Account account2 = new Account("ACC002", 25000.00, Arrays.asList("MODE3", "MODE4"));

        // Create customer object
        Customer customer = new Customer("CUST123", "John", "Doe", phoneDetails, Arrays.asList(account1, account2));

        // Use CustomerService to display account details
        CustomerService customerService = new CustomerService();
        customerService.displayCustomerAccountDetails(customer);
    }
}
