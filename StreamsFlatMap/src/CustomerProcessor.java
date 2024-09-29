import java.util.List;
import java.util.stream.Collectors;

public class CustomerProcessor {

    public void displayCustomerDetails(Customer customer) {
        System.out.println("Customer Number: " + customer.getCustomerNumber());
        System.out.println("Full Name: " + customer.getFullName());

        customer.getPhoneDetails().stream()
                .findFirst()
                .ifPresent(phoneDetails -> System.out.println("Primary Phone Number: " + phoneDetails.getPrimaryNumber()));
    }

    public List<Account> findMatchedAccounts(Customer customer, List<Account> accounts) {
        return accounts.stream()
                .filter(account -> customer.getLinkedAccountNumbers().contains(account.getAccountNumber()))
                .collect(Collectors.toList());
    }

    public List<Account> findProductModeMatchedAccounts(List<Account> accounts) {
        return accounts.stream()
                .filter(account -> account.getProductMode().stream()
                        .anyMatch(mode -> mode.equals("IM") || mode.equals("CD")))
                .collect(Collectors.toList());
    }

    public List<String> getAllProductModes(List<Account> accounts) {
        return accounts.stream()
                .flatMap(account -> account.getProductMode().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public void displayMatchedAccounts(List<Account> matchedAccounts, Customer customer) {
        matchedAccounts.forEach(account -> {
            System.out.println("Matched Account Number: " + account.getAccountNumber());
            System.out.println("Product Code: " + account.getProductCode());
            System.out.println("Current Balance: " + account.getCurrentBalance());
            System.out.println("Product Modes: " + account.getProductMode());
        });
    }

    public void displayProductModeMatchedAccounts(List<Account> productModeMatchedAccounts, Customer customer) {
        productModeMatchedAccounts.forEach(account -> {
            System.out.println("Customer Number: " + customer.getCustomerNumber());
            System.out.println("Full Name: " + customer.getFullName());
            System.out.println("Matched Account Number: " + account.getAccountNumber());
            System.out.println("Product Code: " + account.getProductCode());
            System.out.println("Current Balance: " + account.getCurrentBalance());
            System.out.println("Product Modes: " + account.getProductMode());
        });
    }
}
