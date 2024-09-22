import java.util.List;

public class Account {
    private String accountNumber;
    private double currentBalance;
    private String productCode;
    private List<String> productModeList;
    private List<String> linkedAccountNumbers; // List of linked account numbers

    public Account(String accountNumber, double currentBalance, String productCode, List<String> productModeList, List<String> linkedAccountNumbers) {
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.productCode = productCode;
        this.productModeList = productModeList;
        this.linkedAccountNumbers = linkedAccountNumbers;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public List<String> getProductModeList() {
        return productModeList;
    }

    public List<String> getLinkedAccountNumbers() {
        return linkedAccountNumbers;
    }
}
