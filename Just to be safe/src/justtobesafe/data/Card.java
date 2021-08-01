package justtobesafe.data;

public class Card extends DataObject {
    private String cvv;
    private String expiry;

    public Card(String CardName, String CardNumber, String cvv, String expiry ) {
        DisplayName=CardName;
        UniqueIdentifier=CardNumber;
        this.cvv=cvv;
        this.expiry=expiry;
    }

    public String getCardName() {
        return DisplayName;
    }

    public void setCardName(String CardName){
        DisplayName=CardName;
    }

    public String getCardNumber() {
        return UniqueIdentifier;
    }

    public void setCardNumber(String CardNumber){
        UniqueIdentifier=CardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }
}
