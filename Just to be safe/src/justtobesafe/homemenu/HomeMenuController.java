package justtobesafe.homemenu;

// Java FX imports
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
// Program Imports
import justtobesafe.toast.Toast;
import justtobesafe.encryption.EncryptionHandler;
import justtobesafe.random.RandomHandler;
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityLocations;

public class HomeMenuController {

    RandomHandler randomHandler=new RandomHandler();
    ActivityHandler activityHandler=new ActivityHandler();
    final Clipboard clipboard = Clipboard.getSystemClipboard();
    final ClipboardContent content = new ClipboardContent();

    @FXML private AnchorPane HomeMenu;
    @FXML private TextField input_field;
    @FXML private TextField output_field;

    //Click Accounts & Passwords button
    public void onAccountButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(HomeMenu);
        activityHandler.loadActivity(ActivityLocations.accountMenu);
    }
    //Click Settings button
    public void onSettingsButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(HomeMenu);
        activityHandler.loadActivity(ActivityLocations.settingsMenu);
    }
    //Click Credit Cards button
    public void onCardButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(HomeMenu);
        activityHandler.loadActivity(ActivityLocations.cardMenu);
    }
    //Click Logout Button
    public void onLogoutButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(HomeMenu);
        activityHandler.loadActivity(ActivityLocations.loginActivity);
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

        Toast.makeText(((Stage) HomeMenu.getScene().getWindow()), "Copied to clipboard", 500, 100, 100);
    }
    //Click Reset Button
    public void onResetButtonClicked(MouseEvent mouseEvent) {
        input_field.setText("");
        output_field.setText("");
    }
}
