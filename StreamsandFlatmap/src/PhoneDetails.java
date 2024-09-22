public class PhoneDetails {
    private String primaryNumber;
    private String secondaryNumber;
    private String countryCode;
    private String phoneType; // "Primary" or "Secondary"

    public PhoneDetails(String primaryNumber, String secondaryNumber, String countryCode, String phoneType) {
        this.primaryNumber = primaryNumber;
        this.secondaryNumber = secondaryNumber;
        this.countryCode = countryCode != null ? countryCode : "+91"; // Add default country code
        this.phoneType = phoneType;
    }

    public String getPrimaryNumber() {
        return countryCode + " " + primaryNumber;
    }

    public String getSecondaryNumber() {
        return countryCode + " " + secondaryNumber;
    }

    public String getPhoneType() {
        return phoneType;
    }
}
