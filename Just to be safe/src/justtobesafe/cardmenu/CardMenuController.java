package justtobesafe.cardmenu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityPaths;
import justtobesafe.asset.AssetPaths;

public class CardMenuController {
    ActivityHandler activityHandler = new ActivityHandler();

    @FXML private AnchorPane CardMenu;
    @FXML private TextField cardNum_field;
    @FXML private Button setBtn;
    @FXML private Button clearBtn;


    //Click Logout Button
    public void onLogoutButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(CardMenu);
        activityHandler.loadActivity(ActivityPaths.loginActivity, AssetPaths.title, AssetPaths.icon);
    }

    public void onHomeButtonClicked(MouseEvent mouseEvent) {
        activityHandler.closeStage(CardMenu);
        activityHandler.loadActivity(ActivityPaths.homeMenu,AssetPaths.title, AssetPaths.icon);
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
}
