import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        // Sample data for PhoneDetails
        PhoneDetails phoneDetails1 = new PhoneDetails("1234567890", "0987654321", null, "Primary");
        PhoneDetails phoneDetails2 = new PhoneDetails("1122334455", "5566778899", "+44", "Secondary");

        // Sample data for Accounts
        Account account1 = new Account("A001", 5000.0, "PC01", Arrays.asList("Mode1", "Mode2"), Arrays.asList("A001", "A002"));
        Account account2 = new Account("A002", 7500.0, "PC02", Arrays.asList("Mode3"), Arrays.asList("A002", "A003"));

        // Sample data for Customer
        Customer customer = new Customer("C001", "John", "Doe", Arrays.asList(phoneDetails1, phoneDetails2));

        // Process and Output Data
        System.out.println("Customer Number: " + customer.getCustomerNumber());
        System.out.println("Full Name: " + customer.getFullName());

        // Print primary phone number using streams
        customer.getPhoneDetailsList().stream()
                .filter(phone -> "Secondary".equalsIgnoreCase(phone.getPhoneType()))
                .forEach(phone -> System.out.println("Secondary Mobile: " + phone.getSecondaryNumber()));

        // Print all linked accounts and product mode lists for the accounts
        List<Account> accounts = Arrays.asList(account1, account2);

        // Collect all linked account numbers using flatMap
        List<String> linkedAccountNumbers = accounts.stream()
                .flatMap(account -> account.getLinkedAccountNumbers().stream())
                .collect(Collectors.toList());
        System.out.println("Linked Account Numbers: " + linkedAccountNumbers);

        // Collect all product mode lists using flatMap
        List<String> allProductModes = accounts.stream()
                .flatMap(account -> account.getProductModeList().stream())
                .collect(Collectors.toList());
        System.out.println("Product Mode List: " + allProductModes);

        // Print current balance for each account using streams
        accounts.stream()
                .forEach(account -> System.out.println("Account Number: " + account.getAccountNumber() +
                        ", Current Balance: " + account.getCurrentBalance()));
    }
}
