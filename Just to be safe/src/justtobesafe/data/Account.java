package justtobesafe.data;

public class Account extends DataObject{
    private String email;
    private String password;

    public Account(String Name, String Link,String Email,String Password){
        DisplayName = Name;
        UniqueIdentifier = Link;
        this.email = Email;
        this.password = Password;
    }


    public String getName(){
        return DisplayName;
    }
    public void setName(String Name){
        DisplayName = Name;
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
