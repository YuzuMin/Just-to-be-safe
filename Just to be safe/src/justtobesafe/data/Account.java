package justtobesafe.data;

public class Account extends DataObject{
    private String email;
    private String password;

    public String getName(){
        return DisplayName;
    }
    public void setName(String Name){
        this.DisplayName = Name;
    }

    public String getLink(){
        return UniqueIdentifier;
    }

    public void setLink(String Link){
        UniqueIdentifier=Link;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
