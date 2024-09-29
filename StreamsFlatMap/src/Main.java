import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerProcessor processor = new CustomerProcessor();

        // Input for PhoneDetails
        System.out.println("Enter primary phone, primary country code, primary phone type (format: primaryPhone|primaryCountryCode|primaryPhoneType): ");
        String[] phoneInput = scanner.nextLine().split("\\|");
        PhoneDetails phoneDetails = new PhoneDetails(phoneInput[0], phoneInput[1], phoneInput[2]);

        // Input for number of accounts
        System.out.print("Enter number of accounts: ");
        int numberOfAccounts = Integer.parseInt(scanner.nextLine());

        // Input for account details using Stream
        System.out.println("Enter account details (format: accountNumber|currentBalance|productCode|productModes): ");
        List<Account> accounts = IntStream.range(0, numberOfAccounts)
                .mapToObj(i -> {
                    String accountInput = scanner.nextLine();
                    String[] accountDetails = accountInput.split("\\|");
                    return new Account(accountDetails[0],
                            Double.parseDouble(accountDetails[1]),
                            accountDetails[2],
                            Arrays.asList(accountDetails[3].split(",")));
                })
                .collect(Collectors.toList());

        // Input for customer details
        System.out.println("Enter customer details and linked accounts (format: customerNumber|firstName|surname|linkedAccountNumbers): ");
        String[] customerDetails = scanner.nextLine().split("\\|");
        List<String> linkedAccountNumbers = Arrays.asList(customerDetails[3].split(","));
        Customer customer = new Customer(customerDetails[0], customerDetails[1], customerDetails[2], Arrays.asList(phoneDetails), linkedAccountNumbers);

        // Display customer details
        processor.displayCustomerDetails(customer);

        // Display matched accounts
        processor.displayMatchedAccounts(processor.findMatchedAccounts(customer, accounts), customer);

        // Display product mode matched accounts
        processor.displayProductModeMatchedAccounts(processor.findProductModeMatchedAccounts(accounts), customer);

        // Display all product modes
        System.out.println("All Product Modes: " + processor.getAllProductModes(accounts));

        // Close the scanner
        scanner.close();
    }
}
