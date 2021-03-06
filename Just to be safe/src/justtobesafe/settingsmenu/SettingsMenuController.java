package justtobesafe.settingsmenu;

//JavaFX Imports
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
//Program Imports
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityPaths;
import justtobesafe.alert.AlertPopup;
import justtobesafe.asset.AssetPaths;
import justtobesafe.encryption.EncryptionHandler;
import justtobesafe.data.DataHandler;
import justtobesafe.toast.Toast;

public class SettingsMenuController {
    ActivityHandler activityHandler=new ActivityHandler();
    EncryptionHandler encryptionHandler=new EncryptionHandler();
    DataHandler dataHandler =new DataHandler();

    @FXML private AnchorPane SettingsMenu;
    @FXML private Label pswd_warning;
    @FXML private TextField passwd_field;
    @FXML private TextField passwd_reenter_field;

    public void onPasswdResetButtonClicked(MouseEvent mouseEvent) {
        String passwd=passwd_field.getText();
        String confirmPasswd=passwd_reenter_field.getText();
        if(passwd.isBlank()){
            pswd_warning.setText("Please enter a value");
        }else if(confirmPasswd.isBlank()){
            pswd_warning.setText("Please confirm password");
        }else{
            if(passwd.equals(confirmPasswd)){
                String displayText="Are you sure you want to reset password?";
                String smallText="";
                String displayTitle="Confirm Password Reset";

                boolean confirmed= AlertPopup.confirmation(displayText,smallText,displayTitle);
                if(confirmed){
                    try{
                        String pswd = encryptionHandler.cc_encrypt(passwd,69,420);
                        pswd = encryptionHandler.sha512(pswd);
                        pswd = encryptionHandler.cc_encrypt(pswd,69,420);
                        dataHandler.writeFile(AssetPaths.passwd,pswd);
                    }catch(Exception ex){

                    }finally{
                        passwd_field.setText("");
                        passwd_reenter_field.setText("");
                        Toast.makeText(((Stage) SettingsMenu.getScene().getWindow()), "Password Changed Successfully", 500,1000,500);
                    }
                }
            }else{
                pswd_warning.setText("Passwords don't match");
            }
        }
    }

    public void onTextFieldClicked(MouseEvent mouseEvent) {
        pswd_warning.setText("");
    }

    public void onHomeButtonClicked(MouseEvent mouseEvent) {
        if((!passwd_field.getText().isBlank())||(!passwd_reenter_field.getText().isBlank())){
            String displayText="Are you sure you want to leave?";
            String smallText="You have unsaved changes.";
            String displayTitle="Confirm Logout";
            boolean confirmed= AlertPopup.confirmation(displayText,smallText,displayTitle);
            if(confirmed) {
                activityHandler.loadActivity(ActivityPaths.homeMenu, AssetPaths.title, AssetPaths.icon);
                activityHandler.closeStage(SettingsMenu);
            }
        }else{
            activityHandler.loadActivity(ActivityPaths.homeMenu, AssetPaths.title, AssetPaths.icon);
            activityHandler.closeStage(SettingsMenu);
        }
    }

    public void onAccountButtonClicked(MouseEvent mouseEvent) {
        activityHandler.loadActivity(ActivityPaths.accountMenu,AssetPaths.title, AssetPaths.icon);
        activityHandler.closeStage(SettingsMenu);
    }
    //Click Credit Cards button
    public void onCardButtonClicked(MouseEvent mouseEvent) {
        activityHandler.loadActivity(ActivityPaths.cardMenu,AssetPaths.title, AssetPaths.icon);
        activityHandler.closeStage(SettingsMenu);
    }
    //Click Logout Button
    public void onLogoutButtonClicked(MouseEvent mouseEvent) {
        String displayText="Are you sure you want to logout now?";
        String smallText="";
        String displayTitle="Confirm Logout";
        boolean confirmed= AlertPopup.confirmation(displayText,smallText,displayTitle);
        if(confirmed) {
            activityHandler.loadActivity(ActivityPaths.loginActivity, AssetPaths.title, AssetPaths.icon);
            activityHandler.closeStage(SettingsMenu);
        }
    }

    public void onFunctionKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
            activityHandler.loadActivity(ActivityPaths.decoyActivity,AssetPaths.decoyTitle,AssetPaths.decoyIcon);
            activityHandler.closeStage(SettingsMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F1)) {
            activityHandler.loadActivity(ActivityPaths.homeMenu, AssetPaths.title, AssetPaths.icon);
            activityHandler.closeStage(SettingsMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F2)) {
            activityHandler.loadActivity(ActivityPaths.cardMenu,AssetPaths.title,AssetPaths.icon);
            activityHandler.closeStage(SettingsMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F3)) {
            activityHandler.loadActivity(ActivityPaths.accountMenu,AssetPaths.title,AssetPaths.icon);
            activityHandler.closeStage(SettingsMenu);
        }
    }
}
