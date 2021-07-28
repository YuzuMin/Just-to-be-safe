package justtobesafe.accountmenu;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityLocations;

public class AccountMenuController {
    ActivityHandler activityHandler = new ActivityHandler();

    @FXML
    private AnchorPane AccountMenu;
    
    
    public void onLogoutButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(AccountMenu);
        activityHandler.loadActivity(ActivityLocations.loginActivity);
    }

    public void onHomeButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(AccountMenu);
        activityHandler.loadActivity(ActivityLocations.homeMenu);
    }

    public void onSetButtonClicked(MouseEvent mouseEvent) {
    }

    public void onClearButtonClicked(MouseEvent mouseEvent) {
    }

    public void onCopyButtonClicked(MouseEvent mouseEvent) {
    }
}
