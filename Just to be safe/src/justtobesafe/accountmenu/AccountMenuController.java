package justtobesafe.accountmenu;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityPaths;
import justtobesafe.asset.AssetPaths;

public class AccountMenuController {
    ActivityHandler activityHandler = new ActivityHandler();

    @FXML
    private AnchorPane AccountMenu;
    
    
    public void onLogoutButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(AccountMenu);
        activityHandler.loadActivity(ActivityPaths.loginActivity, AssetPaths.title, AssetPaths.icon);
    }

    public void onHomeButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(AccountMenu);
        activityHandler.loadActivity(ActivityPaths.homeMenu,AssetPaths.title, AssetPaths.icon);
    }

    public void onSetButtonClicked(MouseEvent mouseEvent) {
    }

    public void onClearButtonClicked(MouseEvent mouseEvent) {
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
