package justtobesafe.cardmenu;

// JavaFX Imports
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
// Program Imports
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityPaths;
import justtobesafe.alert.AlertPopup;
import justtobesafe.asset.AssetPaths;
import justtobesafe.data.Card;
import justtobesafe.data.DataHandler;
import justtobesafe.encryption.EncryptionHandler;
import justtobesafe.toast.Toast;
// Java Imports
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class CardMenuController implements Initializable {
    EncryptionHandler encryptionHandler = new EncryptionHandler();
    ActivityHandler activityHandler = new ActivityHandler();
    DataHandler dataHandler = new DataHandler();

    final Clipboard clipboard = Clipboard.getSystemClipboard();
    final ClipboardContent content = new ClipboardContent();

    @FXML private AnchorPane CardMenu;
    @FXML private TextField cardName_field;
    @FXML private TextField cardNum_field;
    @FXML private TextField cvv_field;
    @FXML private TextField expiry_field;
    @FXML private TextField cardholder_field;
    @FXML private ListView<String> cardView;
    @FXML private Label warning;
    @FXML private Button setBtn;

    int position;
    boolean deleteBtnIsActive=false;

    LinkedList<Card> cardList = new LinkedList<Card>();
    LinkedList<String> cardEncryptedStringList = new LinkedList<String>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayAccounts();

        cardView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

                String[] EAX =newValue.split(". ");
                int value = Integer.parseInt(EAX[0]);
                value--;
                position=value;
                deleteBtnIsActive=true;
                cardName_field.setText(cardList.get(value).getCardName());
                cardNum_field.setText(cardList.get(value).getCardNumber());
                cvv_field.setText(cardList.get(value).getCvv());
                expiry_field.setText(cardList.get(value).getExpiry());
                cardholder_field.setText(cardList.get(value).getCardHolder());
                setBtn.setText("Update");
            }
        });
    }

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
        if((!cardName_field.getText().isBlank())||(!cardNum_field.getText().isBlank())){
            String displayText="Are you sure you want to leave?";
            String smallText="You have unsaved changes.";
            String displayTitle="Confirm Logout";
            boolean confirmed= AlertPopup.confirmation(displayText,smallText,displayTitle);
            if(confirmed) {
                activityHandler.loadActivity(ActivityPaths.homeMenu,AssetPaths.title, AssetPaths.icon);
                activityHandler.closeStage(CardMenu);
            }
        }else{
            activityHandler.loadActivity(ActivityPaths.homeMenu,AssetPaths.title, AssetPaths.icon);
            activityHandler.closeStage(CardMenu);
        }
    }

    public void onCopyButtonClicked(MouseEvent mouseEvent) {
        content.putString(cardNum_field.getText());
        clipboard.setContent(content);

        Toast.makeText(((Stage) CardMenu.getScene().getWindow()), "Copied to clipboard", 500, 100, 100);
    }

    public void onClearButtonClicked(MouseEvent mouseEvent) {
        activityHandler.loadActivity(ActivityPaths.cardMenu,AssetPaths.title,AssetPaths.icon);
        activityHandler.closeStage(CardMenu);
    }

    public void onSetButtonClicked(MouseEvent mouseEvent) {
        if(cardName_field.getText().isBlank()){
            cardName_field.setText("");
            warning.setText("Card Name Empty");
        }else if(cardNum_field.getText().isBlank()){
            cardNum_field.setText("");
            warning.setText("Card Number Empty");
        }else {
            //Encrypt CardName
            String cardName =cardName_field.getText();
            cardName = cardName.replace(",","|");
            cardName = encryptionHandler.cc_encrypt(cardName, 69, 420);
            cardName = cardName + ",";

            //Encrypt Card Number
            String cardNum =cardNum_field.getText();
            cardNum = cardNum.replace(",","|");
            for(int i = 0;i<cardList.size();i++){
                if(cardNum.equals(cardList.get(i).getCardNumber())){
                    deleteBtnIsActive=true;
                    position=i;
                    setBtn.setText("Update");
                    break;
                }
            }
            cardNum = encryptionHandler.cc_encrypt(cardNum, 70, 421);
            cardNum = cardNum + ",";

            //Encrypt CVV
            String cvv =cvv_field.getText();
            if(cvv.isBlank()){
                cvv=" ";
            }
            cvv = cvv.replace(",","|");
            cvv = encryptionHandler.cc_encrypt(cvv, 71, 422);
            cvv = cvv + ",";

            //Encrypt Expiry
            String expiry =expiry_field.getText();
            if(expiry.isBlank()){
                expiry=" ";
            }
            expiry = expiry.replace(",","|");
            expiry = encryptionHandler.cc_encrypt(expiry, 72, 423);
            expiry = expiry + ",";

            //Encrypt CardHolder
            String cardHolder =cardholder_field.getText();
            if(cardHolder.isBlank()){
                cardHolder=" ";
            }
            cardHolder = cardHolder.replace(",","|");
            cardHolder = encryptionHandler.cc_encrypt(cardHolder, 73, 424);

            //Write as String
            String data = cardName + cardNum + cvv + expiry + cardHolder;

            if(setBtn.getText().equals("Update")){
                String displayText="Are you sure you want to update?";
                String smallText="";
                String displayTitle="Confirm Update";

                boolean confirmed= AlertPopup.confirmation(displayText,smallText,displayTitle);
                if(confirmed){
                    try {
                        cardEncryptedStringList.set(position, data);
                        dataHandler.deleteCSVFile(AssetPaths.cardCSV, cardEncryptedStringList);
                    }finally{
                        onClearButtonClicked(mouseEvent);
                    }
                }
                //Toast.makeText(((Stage) CardMenu.getScene().getWindow()), "Card Updated Successfully", 500, 1000, 500);
            }else{
                try {
                    dataHandler.writeCsvFile(AssetPaths.cardCSV, data+ "\n");
                }finally{
                    onClearButtonClicked(mouseEvent);
                }
                //Toast.makeText(((Stage) CardMenu.getScene().getWindow()), "Card Added Successfully", 500, 1000, 500);
            }
        }
    }

    public void cardnumOnKeyTyped(KeyEvent keyEvent) {

    }

    private void displayAccounts(){
        LinkedList<String> list = dataHandler.readCsvFile(AssetPaths.cardCSV);
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
            EAX[4]=encryptionHandler.cc_decrypt(EAX[4],73,424);     //Decrypt Password

            Card card = new Card(EAX[0],EAX[1],EAX[2],EAX[3],EAX[4]);
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

    private void deleteAccount(){
        if(deleteBtnIsActive){
            String displayText="Are you sure you want delete "+cardList.get(position).getCardName() +"?";
            String smallText="";
            String displayTitle="Confirm Delete";
            boolean confirmed= AlertPopup.confirmation(displayText,smallText,displayTitle);
            if(confirmed) {
                cardEncryptedStringList.remove(position);
                dataHandler.deleteCSVFile(AssetPaths.cardCSV, cardEncryptedStringList);
                activityHandler.loadActivity(ActivityPaths.cardMenu, AssetPaths.title, AssetPaths.icon);
                activityHandler.closeStage(CardMenu);
            }
        }
    }

    public void onTextFieldClicked(MouseEvent mouseEvent) {
        warning.setText("");
    }

    public void onDeleteButtonClicked(MouseEvent mouseEvent) {
        deleteAccount();
    }

}
