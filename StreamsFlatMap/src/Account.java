import java.util.List;

public class Account {
    private String AccountNumber;
    private double CurrentBalance;
    private String ProductCode;
    private List<String> ProductMode;

    public String getAccountNumber() {
        return AccountNumber;
    }

    public double getCurrentBalance() {
        return CurrentBalance;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public List<String> getProductMode() {
        return ProductMode;
    }

    public Account(String accountNumber, double currentBalance, String productCode, List<String> productMode) {
        AccountNumber = accountNumber;
        CurrentBalance = currentBalance;
        ProductCode = productCode;
        ProductMode = productMode;
    }
}