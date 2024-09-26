import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for PhoneDetails, including secondary country code and phone type
        System.out.println("Enter primary phone, primary country code, primary phone type(format: primaryPhone|primaryCountryCode|primaryPhoneType): ");
        String[] phoneInput = scanner.nextLine().split("\\|");
        String PrimaryNumber = phoneInput[0];
        String PrimaryCountryCode = phoneInput[1];
        String PrimaryPhoneType = phoneInput[2];


        // Create a PhoneDetails object
        PhoneDetails phoneDetails = new PhoneDetails(PrimaryNumber, PrimaryCountryCode,PrimaryPhoneType);

        // Input accounts
        System.out.print("Enter number of accounts: ");
        int numberOfAccounts = Integer.parseInt(scanner.nextLine());
        List<Account> accounts = new ArrayList<>();

        System.out.println("Enter account details (format: accountNumber|currentBalance|productCode|productModes): ");

        // Replacing IntStream with a traditional for loop
        for (int i = 0; i < numberOfAccounts; i++) {
            String accountInput = scanner.nextLine(); // Read input for each account
            String[] accountDetails = accountInput.split("\\|");
            String accountNumber = accountDetails[0];
            double currentBalance = Double.parseDouble(accountDetails[1]);
            String productCode = accountDetails[2];
            List<String> productModes = Arrays.asList(accountDetails[3].split(","));
            accounts.add(new Account(accountNumber, currentBalance, productCode, productModes));
        }

        // Input customer details
        System.out.println("Enter customer details and linked accounts (format: customerNumber|firstName|surname|linkedAccountNumbers): ");
        String[] customerDetails = scanner.nextLine().split("\\|");
        String customerNumber = customerDetails[0];
        String firstName = customerDetails[1]; // Will use Optional in Customer class
        String surname = customerDetails[2];   // Will use Optional in Customer class
        List<String> linkedAccountNumbers = Arrays.asList(customerDetails[3].split(","));

        // Create a Customer object with linked accounts and phone details
        Customer customer = new Customer(customerNumber, firstName, surname, Arrays.asList(phoneDetails), linkedAccountNumbers);

        // Display customer information
        System.out.println("Customer Number: " + customer.getCustomerNumber());
        System.out.println("Full Name: " + customer.getFullName());

        // Display phone numbers
        System.out.println("Primary Phone Number: " + phoneDetails.getPrimaryNumber());

        // Check if any linked accounts match with the accounts provided
        List<Account> matchedAccounts = accounts.stream()
                .filter(account -> customer.getLinkedAccountNumbers().contains(account.getAccountNumber()))
                .collect(Collectors.toList());

        // Display the matched accounts' details
        if (!matchedAccounts.isEmpty()) {
            System.out.println("Matched Accounts:");
            matchedAccounts.forEach(account -> {
                System.out.println("Matched Account Number: " + account.getAccountNumber());
                System.out.println("Primary Phone Number: " + phoneDetails.getPrimaryNumber());
                System.out.println("Product Code: " + account.getProductCode());
                System.out.println("Current Balance: " + account.getCurrentBalance());
                System.out.println("Product Modes: " + account.getProductMode());
            });
        } else {
            System.out.println("No linked accounts matched the existing accounts.");
        }

        // NEW FEATURE: Check for Product Mode Matching (IM or CD)
        List<Account> productModeMatchedAccounts = accounts.stream()
                .filter(account -> account.getProductMode().contains("IM") || account.getProductMode().contains("CD"))
                .collect(Collectors.toList());

        // Display details of customers whose accounts have IM or CD in the product modes
        if (!productModeMatchedAccounts.isEmpty()) {
            System.out.println("Accounts with 'IM' or 'CD' Product Modes:");
            productModeMatchedAccounts.forEach(account -> {
                System.out.println("Customer Number: " + customer.getCustomerNumber());
                System.out.println("Full Name: " + customer.getFullName());
                System.out.println("Matched Account Number: " + account.getAccountNumber());
                System.out.println("Product Code: " + account.getProductCode());
                System.out.println("Current Balance: " + account.getCurrentBalance());
                System.out.println("Product Modes: " + account.getProductMode());
            });
        } else {
            System.out.println("No accounts found with 'IM' or 'CD' product modes.");
        }

        // Collect and display all product modes from the accounts using flatMap
        List<String> allProductModes = accounts.stream()
                .flatMap(account -> account.getProductMode().stream())
                .distinct()
                .collect(Collectors.toList());

        System.out.println("All Product Modes: " + allProductModes);

        // Close the scanner
        scanner.close();
    }
}