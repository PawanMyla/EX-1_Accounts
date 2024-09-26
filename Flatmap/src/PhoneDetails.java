import java.util.Optional;
public class PhoneDetails {

    private String PrimaryNumber;
    private String PrimaryCountryCode;
    private String PrimaryPhoneType;
    private String SecondaryNumber;
    private String SecondaryCountryCode;
    private String  SecondaryPhoneType;

    public PhoneDetails(String PrimaryNumber, String PrimaryCountryCode, String PrimaryPhoneType) {
        this.PrimaryNumber = PrimaryNumber;
        this.PrimaryCountryCode = Optional.ofNullable(PrimaryCountryCode).orElse("+91");
        this.PrimaryPhoneType = PrimaryPhoneType;
    }

    public String getPrimaryNumber() {
        return PrimaryCountryCode.concat(" ").concat(PrimaryNumber);
    }

    public String getPrimaryCountryCode() {
        return PrimaryCountryCode;
    }

    public String getPrimaryPhoneType() {
        return PrimaryPhoneType;
    }
}
