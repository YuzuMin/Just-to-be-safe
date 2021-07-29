package justtobesafe.accountmenu;

import javafx.fxml.FXML;
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

    public void onCopyButtonClicked(MouseEvent mouseEvent) {
    }
}
