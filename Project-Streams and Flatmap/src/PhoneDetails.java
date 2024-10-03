public class PhoneDetails {
    private String primaryNumber;
    private String primaryCountryCode;
    private String primaryPhoneType;
    private String secondaryNumber;
    private String secondaryCountryCode;
    private String secondaryPhoneType;

    public PhoneDetails(String primaryNumber, String primaryCountryCode, String primaryPhoneType) {
        this.primaryNumber = primaryNumber;
        this.primaryCountryCode = primaryCountryCode;
        this.primaryPhoneType = primaryPhoneType;

    }

    // Getters
    public String getPrimaryNumber() {
        return primaryNumber;
    }

    public String getPrimaryCountryCode() {
        return primaryCountryCode;
    }

    public String getPrimaryPhoneType() {
        return primaryPhoneType;
    }


}
