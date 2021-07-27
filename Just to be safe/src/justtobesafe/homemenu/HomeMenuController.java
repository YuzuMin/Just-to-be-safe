package justtobesafe.homemenu;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import justtobesafe.encryption.EncryptionHandler;

import justtobesafe.activity.ActivityHandler;

public class HomeMenuController {
    private String accountMenu_location="/justtobesafe/accountmenu/accountmenu_activity.fxml";
    private String cardMenu_location="/justtobesafe/cardmenu/cardmenu_activity.fxml";
    private String settingsMenu_location="/justtobesafe/settingsmenu/settingsmenu_activity.fxml";

    EncryptionHandler encryptionHandler=new EncryptionHandler();
    ActivityHandler activityHandler=new ActivityHandler();

    @FXML
    AnchorPane HomeMenu;

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
}
