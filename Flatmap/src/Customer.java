import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class Customer {
    private String CustomerNumber;
    private String FirstName;
    private  String Surname;

    private List<PhoneDetails> phoneDetails;
    private List<String> linkedAccountNumbers;



    public Customer(String customerNumber, String firstName, String surname, List<PhoneDetails> phoneDetails, List<String> linkedAccountNumbers ) {
        this.CustomerNumber = customerNumber;
        this.FirstName = firstName;
        this.Surname = surname;
        this.phoneDetails = phoneDetails;
        this.linkedAccountNumbers = linkedAccountNumbers;


    }

    public String getCustomerNumber() {
        return CustomerNumber;
    }

    public String getFullName(){
        return Optional.ofNullable(Surname)
                .filter(s -> !s.isEmpty())
                .map(Surname -> Surname.concat(" ").concat(FirstName)).orElse(FirstName);
    }

    public List<PhoneDetails> getPhoneDetails() {
        return phoneDetails;
    }

    public List<String> getLinkedAccountNumbers() {
        return linkedAccountNumbers;
    }
}
