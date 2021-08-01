package justtobesafe.cardmenu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityPaths;
import justtobesafe.alert.AlertPopup;
import justtobesafe.asset.AssetPaths;
import justtobesafe.data.Account;
import justtobesafe.data.Card;
import justtobesafe.data.DataHandler;
import justtobesafe.encryption.EncryptionHandler;

import java.util.LinkedList;

public class CardMenuController {
    EncryptionHandler encryptionHandler = new EncryptionHandler();
    ActivityHandler activityHandler = new ActivityHandler();
    DataHandler dataHandler = new DataHandler();

    @FXML private AnchorPane CardMenu;
    @FXML private TextField cardName_field;
    @FXML private TextField cardNum_field;
    @FXML private TextField cvv_field;
    @FXML private TextField expiry_field;
    @FXML private TextField cardholder_field;
    @FXML private ListView<String> cardView;
    @FXML private Button setBtn;
    @FXML private Button clearBtn;

    int position;
    boolean deleteBtnIsActive=false;

    LinkedList<Card> cardList = new LinkedList<Card>();
    LinkedList<String> cardEncryptedStringList = new LinkedList<String>();

    //Click Logout Button
    public void onLogoutButtonClicked(MouseEvent mouseEvent) {
        String displayText="Are you sure you want to logout now?";
        String smallText="";
        String displayTitle="Confirm Logout";

        if((!cardName_field.getText().isBlank())||(!cardNum_field.getText().isBlank())){
            smallText = "You still have some unsaved changes";
        }

        boolean confirmed= AlertPopup.confirmation(displayText,smallText,displayTitle);
        if(confirmed){
            activityHandler.loadActivity(ActivityPaths.loginActivity, AssetPaths.title, AssetPaths.icon);
            activityHandler.closeStage(CardMenu);
        }
    }

    public void onHomeButtonClicked(MouseEvent mouseEvent) {
        activityHandler.loadActivity(ActivityPaths.homeMenu,AssetPaths.title, AssetPaths.icon);
        activityHandler.closeStage(CardMenu);
    }

    public void onCopyButtonClicked(MouseEvent mouseEvent) {
        setBtn.setText("Update Card");
    }

    public void onClearButtonClicked(MouseEvent mouseEvent) {
    }

    public void onSetButtonClicked(MouseEvent mouseEvent) {
    }

    public void cardnumOnKeyTyped(KeyEvent keyEvent) {

    }

    private void displayAccounts(){
        LinkedList<String> list = dataHandler.readCsvFile(AssetPaths.acctCSV);
        cardEncryptedStringList.clear();
        cardEncryptedStringList =list;
        cardList.clear();
        cardView.getItems().clear();

        for(int i=0; i<list.size();i++){
            String[] EAX = list.get(i).split(",");

            EAX[0]=encryptionHandler.cc_decrypt(EAX[0],69,420);     //Decrypt NAME
            EAX[1]=encryptionHandler.cc_decrypt(EAX[1],70,421);     //Decrypt LINK
            EAX[2]=encryptionHandler.cc_decrypt(EAX[2],71,422);     //Decrypt Email
            EAX[3]=encryptionHandler.cc_decrypt(EAX[3],72,423);     //Decrypt Password

            Card card = new Card(EAX[0],EAX[1],EAX[2],EAX[3]);
            String EBX="";
            EBX=(i+1)+". "+EAX[0];
            cardList.add(card);

            cardView.getItems().add(EBX);
        }
    }

    public void onFunctionKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
            activityHandler.loadActivity(ActivityPaths.decoyActivity,AssetPaths.decoyTitle,AssetPaths.decoyIcon);
            activityHandler.closeStage(CardMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F1)) {
            activityHandler.loadActivity(ActivityPaths.homeMenu, AssetPaths.title, AssetPaths.icon);
            activityHandler.closeStage(CardMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F3)) {
            activityHandler.loadActivity(ActivityPaths.accountMenu,AssetPaths.title,AssetPaths.icon);
            activityHandler.closeStage(CardMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F4)) {
            activityHandler.loadActivity(ActivityPaths.settingsMenu,AssetPaths.title,AssetPaths.icon);
            activityHandler.closeStage(CardMenu);
        }
    }

    public void onDeleteButtonClicked(MouseEvent mouseEvent) {
        System.out.println("delet");
    }
}
