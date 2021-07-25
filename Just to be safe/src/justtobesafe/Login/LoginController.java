package justtobesafe.login;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.awt.event.MouseEvent;
import java.util.prefs.Preferences;

import justtobesafe.encryption.EncryptionHandler;

import javax.swing.*;


public class LoginController {
    public CheckBox pswd_checkbox;
    @FXML
    private PasswordField password;
    @FXML
    private Label pswd_warning;



    Preferences preference;
    EncryptionHandler encryptionHandler=new EncryptionHandler();
    String file = "src/resources/passwd/passwd";



    @FXML
    private void handleLoginButtonAction(MouseEvent event) {
        //String pword = DigestUtils.shaHex(password.getText());

        //if (pword.equals(preference.getPassword())) {
            //closeStage();
            //loadMain();
            //LOGGER.log(PlatformLogger.Level.INFO, "User successfully logged in {}", uname);
        //}
        //else {
        password.getStyleClass().add("wrong-credentials");
        //}
    }

    //Login Related Functions
    public void EnterKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            authenticatePSWD();
        }
    }

    public void LoginButtonOnclick(javafx.scene.input.MouseEvent mouseEvent) {
        authenticatePSWD();
    }

    public void authenticatePSWD(){
        String pswd=encryptionHandler.sha512(password.getText());             //User Entered password
        String passwd=encryptionHandler.cc_decrypt(encryptionHandler.readPasswordFile(file));      //Program stored password

        if(pswd.equals(passwd)){
            pswd_warning.setText("Access Granted");
            password.setText("");
        }else{
            pswd_warning.setText("Access Denied");
            password.setText("");
        }
    }

    //MISC functions
    public void PSWDFieldOnclick(javafx.scene.input.MouseEvent mouseEvent) {
        pswd_warning.setText("");
        password.setPromptText("Enter Password");
    }
    //private void closeStage() {
        //close();
    //}

    /*void loadMain() {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/library/assistant/ui/main/main.fxml"));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Library Assistant");
            stage.setScene(new Scene(parent));
            stage.show();
            LibraryAssistantUtil.setStageIcon(stage);
        }
        catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

     */

}
