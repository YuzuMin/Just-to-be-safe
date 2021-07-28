package justtobesafe.cardmenu;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityLocations;

public class CardMenuController {
    ActivityHandler activityHandler = new ActivityHandler();

    @FXML private AnchorPane CardMenu;

    //Click Logout Button
    public void onLogoutButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(CardMenu);
        activityHandler.loadActivity(ActivityLocations.loginActivity);
    }

    public void onHomeButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(CardMenu);
        activityHandler.loadActivity(ActivityLocations.homeMenu);
    }

    public void onCopyButtonClicked(MouseEvent mouseEvent) {
    }

    public void onClearButtonClicked(MouseEvent mouseEvent) {
    }

    public void onSetButtonClicked(MouseEvent mouseEvent) {
    }
}
