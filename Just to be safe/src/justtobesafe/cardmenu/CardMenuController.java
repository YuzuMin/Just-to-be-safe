package justtobesafe.cardmenu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityLocations;

public class CardMenuController {
    ActivityHandler activityHandler = new ActivityHandler();

    @FXML private AnchorPane CardMenu;
    @FXML private TextField cardNum_field;
    @FXML private Button setBtn;
    @FXML private Button clearBtn;


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
        setBtn.setText("Update Card");
    }

    public void onClearButtonClicked(MouseEvent mouseEvent) {
    }

    public void onSetButtonClicked(MouseEvent mouseEvent) {
    }

    public void cardnumOnKeyTyped(KeyEvent keyEvent) {

    }
}
