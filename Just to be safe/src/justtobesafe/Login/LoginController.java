package justtobesafe.login;

// JAVA FX Imports
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
// JAVA imports
import java.io.IOException;
// Other imports
import justtobesafe.encryption.EncryptionHandler;



public class LoginController {
    @FXML
    private PasswordField password;
    @FXML
    private Label pswd_warning;

    EncryptionHandler encryptionHandler=new EncryptionHandler();
    String file = "src/resources/passwd/passwd";

    //Login Related Functions
    //Authenticate password when user presses "Enter" key after typing in password field
    public void EnterKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            authenticatePSWD();
        }
    }
    //Authenticate password when user presses on-screen Login button
    public void LoginButtonOnclick(MouseEvent mouseEvent) {
        authenticatePSWD();
    }
    //Authenticate password
    public void authenticatePSWD(){
        String passwd=encryptionHandler.readPasswordFile(file);         //retrieve data from passwd
        String pswd=password.getText();                                 //User Entered password
        pswd=encryptionHandler.cc_encrypt(pswd);                        //Caesar Cipher Encrypt password
        pswd=encryptionHandler.sha512(pswd);                            //Hash Encrypted password using Secure Hashing Algorithm 512
        pswd=encryptionHandler.cc_encrypt(pswd);                        //Caesar Cipher Encrypt Hashed password

        //System.out.println(pswd);
        //Compare password string with string from passwd file
        if(pswd.equals(passwd)){
            //pswd_warning.setText("Access Granted");
            //password.setText("");
            closeStage();
            loadHomeMenu();
        }else{
            pswd_warning.setText("Access Denied");
            password.setText("");
        }
    }


    //MISC functions

    public void PSWDFieldOnclick(MouseEvent mouseEvent) {
        pswd_warning.setText("");
        password.setPromptText("Enter Password");
    }

    private void closeStage() {
        ((Stage) password.getScene().getWindow()).close();
    }

    private void loadHomeMenu() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/justtobesafe/homemenu/homemenu_activity.fxml"));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Just to be safe");
            primaryStage.getIcons().add(new Image("/resources/icon_inverse.png"));
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch (IOException ex) {
        }
    }
}
