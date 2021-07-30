package justtobesafe.accountmenu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityPaths;
import justtobesafe.asset.AssetPaths;
import justtobesafe.data.DataHandler;
import justtobesafe.encryption.EncryptionHandler;
import justtobesafe.toast.Toast;

public class AccountMenuController {
    EncryptionHandler encryptionHandler = new EncryptionHandler();
    ActivityHandler activityHandler = new ActivityHandler();
    DataHandler dataHandler = new DataHandler();

    @FXML private AnchorPane AccountMenu;
    @FXML private TextField site_field;
    @FXML private TextField link_field;
    @FXML private TextField email_field;
    @FXML private TextField pswd_field;
    @FXML private Label warning1;
    @FXML private Label warning2;

    
    public void onLogoutButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(AccountMenu);
        activityHandler.loadActivity(ActivityPaths.loginActivity, AssetPaths.title, AssetPaths.icon);
    }

    public void onHomeButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(AccountMenu);
        activityHandler.loadActivity(ActivityPaths.homeMenu,AssetPaths.title, AssetPaths.icon);
    }

    public void onSetButtonClicked(MouseEvent mouseEvent) {
        if(site_field.getText().isBlank()){
            site_field.setText("");
            warning1.setText("Site Name Empty");
            warning2.setText("");
        }else if(link_field.getText().isBlank()){
            link_field.setText("");
            warning1.setText("");
            warning2.setText("Site Link Empty");
        }else{
            String Site=site_field.getText();
            Site=Site.replace(","," | ");
            Site=encryptionHandler.cc_encrypt(Site,3,23);
            Site=Site+",";

            String Link=link_field.getText();
            Link=Link.replace(","," | ");
            Link=encryptionHandler.cc_encrypt(Link,4,22);
            Link=Link+",";

            String Email=email_field.getText();
            Email=Email.replace(","," | ");
            Email=encryptionHandler.cc_encrypt(Email,5,21);
            Email=Email+",";

            String Password=pswd_field.getText();
            Password=Password.replace(","," | ");
            Password=encryptionHandler.cc_encrypt(Password,6,20);
            Password=Password+"\n";

            String data=Site+Link+Email+Password;
            dataHandler.writeCsvFile(AssetPaths.acctCSV,data);

            onClearButtonClicked(mouseEvent);
            Toast.makeText(((Stage) AccountMenu.getScene().getWindow()),"Account Added Successfully",500,1000,500);
        }
    }

    public void onClearButtonClicked(MouseEvent mouseEvent) {
        site_field.setText("");
        link_field.setText("");
        email_field.setText("");
        pswd_field.setText("");
    }

    public void onFunctionKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
            activityHandler.loadActivity(ActivityPaths.decoyActivity,AssetPaths.decoyTitle,AssetPaths.decoyIcon);
            activityHandler.closeStage(AccountMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F1)) {
            activityHandler.loadActivity(ActivityPaths.homeMenu, AssetPaths.title, AssetPaths.icon);
            activityHandler.closeStage(AccountMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F2)) {
            activityHandler.loadActivity(ActivityPaths.cardMenu,AssetPaths.title,AssetPaths.icon);
            activityHandler.closeStage(AccountMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F4)) {
            activityHandler.loadActivity(ActivityPaths.settingsMenu,AssetPaths.title,AssetPaths.icon);
            activityHandler.closeStage(AccountMenu);
        }
    }
}
