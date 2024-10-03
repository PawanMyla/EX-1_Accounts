import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerService {

    public void displayCustomerAccountDetails(Customer customer) {
        // Print Customer Number
        System.out.println("Customer Number: " + customer.getCustomerNumber());

        // Print Full Name (SurName + FirstName or just FirstName if SurName is empty)
        System.out.println("Full Name: " + customer.getFullName());

        // Handling PhoneDetails with Optional and defaulting the country code if null
        PhoneDetails phoneDetails = customer.getPhoneDetails();

        String primaryPhone = Optional.ofNullable(phoneDetails.getPrimaryCountryCode())
                .orElse("+91") // default country code if null
                .concat(" " ).concat(phoneDetails.getPrimaryNumber());
        System.out.println("Mobile Number: " + primaryPhone);

        // Using flatMap to get all account numbers
        List<String> accountNumbers = customer.getAccounts()
                .stream()
                .map(Account::getAccountNumber)
                .collect(Collectors.toList());
        System.out.println("Linked Account Numbers: " + accountNumbers);

        // Print Product Mode List for each account
        customer.getAccounts()
                .stream()
                .flatMap(account -> account.getProductModeList().stream())
                .forEach(mode -> System.out.println("Product Mode: " + mode));

        // Print Current Balance for each account using map and lambda
        customer.getAccounts()
                .forEach(account -> System.out.println("Current Balance for Account "
                        + account.getAccountNumber() + ": "
                        + account.getCurrentBalance()));
    }
}
