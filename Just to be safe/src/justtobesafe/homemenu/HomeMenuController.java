package justtobesafe.homemenu;

// Java FX imports
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
// Program Imports
import justtobesafe.alert.AlertPopup;
import justtobesafe.asset.AssetPaths;
import justtobesafe.toast.Toast;
import justtobesafe.random.RandomHandler;
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityPaths;

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
        activityHandler.loadActivity(ActivityPaths.accountMenu, AssetPaths.title, AssetPaths.icon);
    }
    //Click Settings button
    public void onSettingsButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(HomeMenu);
        activityHandler.loadActivity(ActivityPaths.settingsMenu,AssetPaths.title, AssetPaths.icon);
    }
    //Click Credit Cards button
    public void onCardButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(HomeMenu);
        activityHandler.loadActivity(ActivityPaths.cardMenu,AssetPaths.title, AssetPaths.icon);
    }
    //Click Logout Button
    public void onLogoutButtonClicked(MouseEvent mouseEvent) {
        String displayText="Are you sure you want to logout now?";
        String smallText="";
        String displayTitle="Confirm Logout";
        boolean confirmed= AlertPopup.confirmation(displayText,smallText,displayTitle);
        if(confirmed) {
            activityHandler.closeStage(HomeMenu);
            activityHandler.loadActivity(ActivityPaths.loginActivity, AssetPaths.title, AssetPaths.icon);
        }
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

    public void onFunctionKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
            activityHandler.loadActivity(ActivityPaths.decoyActivity,AssetPaths.decoyTitle,AssetPaths.decoyIcon);
            activityHandler.closeStage(HomeMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F2)) {
                activityHandler.loadActivity(ActivityPaths.cardMenu,AssetPaths.title,AssetPaths.icon);
                activityHandler.closeStage(HomeMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F3)) {
            activityHandler.loadActivity(ActivityPaths.accountMenu,AssetPaths.title,AssetPaths.icon);
            activityHandler.closeStage(HomeMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F4)) {
            activityHandler.loadActivity(ActivityPaths.settingsMenu,AssetPaths.title,AssetPaths.icon);
            activityHandler.closeStage(HomeMenu);
        }else if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            String user_input=input_field.getText();
            String program_output="";
            if(user_input.isBlank()){
                output_field.setText("");
                user_input= randomHandler.generateRandomString();
            }
            program_output=randomHandler.generateRandomPassword(user_input);
            output_field.setText(program_output);
        }
    }
}
