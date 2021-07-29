package justtobesafe.settingsmenu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javafx.stage.Stage;
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityPaths;
import justtobesafe.asset.AssetPaths;
import justtobesafe.encryption.EncryptionHandler;
import justtobesafe.toast.Toast;

public class SettingsMenuController {
    ActivityHandler activityHandler=new ActivityHandler();
    EncryptionHandler encryptionHandler=new EncryptionHandler();

    @FXML private AnchorPane SettingsMenu;
    @FXML private Label pswd_warning;
    @FXML private Label pswd_warning1;
    @FXML private Label pswd_warning2;
    @FXML private TextField passwd_field;
    @FXML private TextField passwd_reenter_field;

    public void onPasswdResetButtonClicked(MouseEvent mouseEvent) {
        String passwd=passwd_field.getText();
        String confirmPasswd=passwd_reenter_field.getText();
        if(passwd.isBlank()){
            pswd_warning.setText("");
            pswd_warning1.setText("Please enter a value");
            pswd_warning2.setText("");
        }else if(confirmPasswd.isBlank()){
            pswd_warning.setText("Please confirm password");
            pswd_warning1.setText("");
            pswd_warning2.setText("");
        }else{
            if(passwd.equals(confirmPasswd)){
                try{
                    String pswd = encryptionHandler.cc_encrypt(passwd,69,420);
                    pswd = encryptionHandler.sha512(pswd);
                    pswd = encryptionHandler.cc_encrypt(pswd,69,420);
                    encryptionHandler.writePasswordFile(AssetPaths.passwd,pswd);
                }catch(Exception ex){

                }finally{
                    Toast.makeText(((Stage) SettingsMenu.getScene().getWindow()), "Password Changed Successfully", 500, 100, 100);
                }
            }else{
                pswd_warning.setText("");
                pswd_warning1.setText("");
                pswd_warning2.setText("Passwords don't match");
            }
        }
    }

    public void onHomeButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(SettingsMenu);
        activityHandler.loadActivity(ActivityPaths.homeMenu,AssetPaths.title, AssetPaths.icon);
    }

    public void onAccountButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(SettingsMenu);
        activityHandler.loadActivity(ActivityPaths.accountMenu,AssetPaths.title, AssetPaths.icon);
    }

    //Click Credit Cards button
    public void onCardButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(SettingsMenu);
        activityHandler.loadActivity(ActivityPaths.cardMenu,AssetPaths.title, AssetPaths.icon);
    }
    //Click Logout Button
    public void onLogoutButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(SettingsMenu);
        activityHandler.loadActivity(ActivityPaths.loginActivity,AssetPaths.title, AssetPaths.icon);
    }
}
