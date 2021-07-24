package justtobesafe.Login;

import com.sun.javafx.logging.PlatformLogger;
import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

//import static jdk.internal.net.http.common.Utils.close;


public class LoginController {
    @FXML
    private TextField password;

    @FXML
    private Label pswd_warning;

    Preferences preference;



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




    public void LoginButtonOnclick(javafx.scene.input.MouseEvent mouseEvent) {
        //password.getStyleClass().add("wrong-credentials");
        pswd_warning.setText("Wrong Password");
        password.setText("");
    }

    public void PSWDFieldOnclick(javafx.scene.input.MouseEvent mouseEvent) {
        pswd_warning.setText("");
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
