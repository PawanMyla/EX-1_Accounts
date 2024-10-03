import java.util.List;

public class Account {
    private String accountNumber;
    private double currentBalance;
    private List<String> productModeList;

    public Account(String accountNumber, double currentBalance, List<String> productModeList) {
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.productModeList = productModeList;
    }

    // Only necessary getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public List<String> getProductModeList() {
        return productModeList;
    }
}
