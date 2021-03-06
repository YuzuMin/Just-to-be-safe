package justtobesafe.login;

// JavaFX Imports
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
// Program Imports
import justtobesafe.activity.ActivityHandler;
import justtobesafe.encryption.EncryptionHandler;
import justtobesafe.activity.ActivityPaths;
import justtobesafe.asset.AssetPaths;
import justtobesafe.data.DataHandler;


public class LoginController {
    @FXML
    private PasswordField password;
    @FXML
    private Label pswd_warning;
    @FXML
    private AnchorPane LoginMenu;

    EncryptionHandler encryptionHandler=new EncryptionHandler();
    ActivityHandler activityHandler=new ActivityHandler();
    DataHandler dataHandler =new DataHandler();

    //Login Related Functions
    //Authenticate password when user presses on-screen Login button
    public void LoginButtonOnclick(MouseEvent mouseEvent) {
        authenticatePSWD();
    }
    //Authenticate password
    public void authenticatePSWD(){
        String passwd= dataHandler.readFile(AssetPaths.passwd);         //retrieve data from passwd
        String pswd=password.getText();                                                     //User Entered password
        pswd=encryptionHandler.cc_encrypt(pswd,69,420);                        //Caesar Cipher Encrypt password
        pswd=encryptionHandler.sha512(pswd);                                                //Hash Encrypted password using Secure Hashing Algorithm 512
        pswd=encryptionHandler.cc_encrypt(pswd,69,420);                        //Caesar Cipher Encrypt Hashed password
        //System.out.println(pswd);
        //Compare password string with string from passwd file
        if(pswd.equals(passwd)){
            activityHandler.closeStage(LoginMenu);
            activityHandler.loadActivity(ActivityPaths.homeMenu,AssetPaths.title, AssetPaths.icon);
        }else{
            pswd_warning.setText("Access Denied");
            password.setText("");
        }
    }

    public void onFunctionKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
            activityHandler.closeStage(LoginMenu);
        }else if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            authenticatePSWD();                                 //Authenticate password when user presses "Enter" key after typing in password field
        }
    }

    //MISC functions
    public void PSWDFieldOnclick(MouseEvent mouseEvent) {
        pswd_warning.setText("");
    }
}
