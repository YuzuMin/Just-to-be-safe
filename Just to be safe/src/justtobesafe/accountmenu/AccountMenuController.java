package justtobesafe.accountmenu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityPaths;
import justtobesafe.asset.AssetPaths;
import justtobesafe.data.Account;
import justtobesafe.data.DataHandler;
import justtobesafe.encryption.EncryptionHandler;
import justtobesafe.toast.Toast;

import java.util.LinkedList;

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
    @FXML private ListView<String> accountView;

    LinkedList<Account> accountList = new LinkedList<Account>();
    LinkedList<String> accountListView = new LinkedList<String>();

    //ListView<String> accountView = new ListView<String>();

    
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
            //Encrypt Site Name
            String Site=site_field.getText();
            Site=Site.replace(","," | ");
            Site=encryptionHandler.cc_encrypt(Site,69,420);
            Site=Site+",";

            //Encrypt Site Link
            String Link=link_field.getText();
            Link=Link.replace(","," | ");
            Link=encryptionHandler.cc_encrypt(Link,70,421);
            Link=Link+",";

            //Encrypt Email
            String Email=email_field.getText();
            Email=Email.replace(","," | ");
            Email=encryptionHandler.cc_encrypt(Email,71,422);
            Email=Email+",";

            //Encrypt Password
            String Password=pswd_field.getText();
            Password=Password.replace(","," | ");
            Password=encryptionHandler.cc_encrypt(Password,72,423);
            Password=Password+"\n";

            //Write as String
            String data=Site+Link+Email+Password;
            dataHandler.writeCsvFile(AssetPaths.acctCSV,data);

            onClearButtonClicked(mouseEvent);
            Toast.makeText(((Stage) AccountMenu.getScene().getWindow()),"Account Added Successfully",500,1000,500);
        }
    }

    public void onClearButtonClicked(MouseEvent mouseEvent) {
        displayAccounts();

        site_field.setText("");
        link_field.setText("");
        email_field.setText("");
        pswd_field.setText("");
    }

    private void displayAccounts(){
        LinkedList<String> list = dataHandler.readCsvFile(AssetPaths.acctCSV);
        for(int i=0; i<list.size();i++){
            String[] EAX = list.get(i).split(",");

            EAX[0]=encryptionHandler.cc_decrypt(EAX[0],69,420);
            EAX[1]=encryptionHandler.cc_decrypt(EAX[1],70,421);
            EAX[2]=encryptionHandler.cc_decrypt(EAX[2],71,422);
            EAX[3]=encryptionHandler.cc_decrypt(EAX[3],72,423);

            Account account = new Account();
            account.setName(EAX[0]);
            account.setLink(EAX[1]);
            account.setEmail(EAX[2]);
            account.setPassword(EAX[3]);

            accountList.add(account);
            accountListView.add(EAX[0]);
            accountView.getItems().add(EAX[0]);
        }

        for(int i=0; i<accountList.size();i++){
            Account acc = accountList.get(i);
            System.out.println(acc.getName());
            System.out.println(acc.getLink());
            System.out.println(acc.getEmail());
            System.out.println(acc.getPassword());
        }

        for(int i=0; i<accountListView.size();i++){
            String BX = accountListView.get(i);
            System.out.println(BX);
        }
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

    public void onTextFieldClicked(MouseEvent mouseEvent) {
        warning1.setText("");
        warning2.setText("");
    }
}
