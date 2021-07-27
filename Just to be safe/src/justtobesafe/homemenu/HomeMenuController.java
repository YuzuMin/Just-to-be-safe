package justtobesafe.homemenu;

// Java FX imports
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
// Program Imports
import javafx.stage.Stage;
import justtobesafe.Toast;
import justtobesafe.encryption.EncryptionHandler;
import justtobesafe.random.RandomHandler;
import justtobesafe.activity.ActivityHandler;

public class HomeMenuController {

    private String loginActivity_location="/justtobesafe/login/login_activity.fxml";
    private String accountMenu_location="/justtobesafe/accountmenu/accountmenu_activity.fxml";
    private String cardMenu_location="/justtobesafe/cardmenu/cardmenu_activity.fxml";
    private String settingsMenu_location="/justtobesafe/settingsmenu/settingsmenu_activity.fxml";

    RandomHandler randomHandler=new RandomHandler();
    EncryptionHandler encryptionHandler=new EncryptionHandler();
    ActivityHandler activityHandler=new ActivityHandler();
    final Clipboard clipboard = Clipboard.getSystemClipboard();
    final ClipboardContent content = new ClipboardContent();


    @FXML private AnchorPane HomeMenu;
    @FXML private TextField input_field;
    @FXML private TextField output_field;
    @FXML private Button generateBtn;
    @FXML private Button resetBtn;
    @FXML private Button copyBtn;
    @FXML private Button cardBtn;
    @FXML private Button accountBtn;
    @FXML private Button settingsBtn;
    @FXML private Button logoutBtn;

    //Click Accounts & Passwords button
    public void onAccountButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(HomeMenu);
        activityHandler.loadActivity(accountMenu_location);
    }
    //Click Settings button
    public void onSettingsButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(HomeMenu);
        activityHandler.loadActivity(settingsMenu_location);
    }
    //Click Credit Cards button
    public void onCardButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(HomeMenu);
        activityHandler.loadActivity(cardMenu_location);
    }
    //Click Logout Button
    public void onLogoutButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(HomeMenu);
        activityHandler.loadActivity(loginActivity_location);
    }
    //Click Generate Random Passwords with hashing
    public void onGenerateButtonClicked(MouseEvent mouseEvent) {
        String user_input=input_field.getText();
        String program_output="";
        if(user_input.isBlank()){
            output_field.setText("");
            user_input= randomHandler.generateRandomString();
        }
        program_output=randomHandler.generateRandomPassword(user_input);
        output_field.setText(program_output);
    }
    //Click Copy to Clipboard Button
    public void onCopyButtonClicked(MouseEvent mouseEvent) {
        content.putString(output_field.getText());
        clipboard.setContent(content);

        String toastMsg = "Copied to clipboard";
        int toastMsgTime = 500; //1.5 seconds
        int fadeInTime = 100; //0.5 seconds
        int fadeOutTime= 100; //0.5 seconds
        Toast.makeText(((Stage) HomeMenu.getScene().getWindow()), toastMsg, toastMsgTime, fadeInTime, fadeOutTime);
    }
    //Click Reset Button
    public void onResetButtonClicked(MouseEvent mouseEvent) {
        input_field.setText("");
        output_field.setText("");
    }
}
