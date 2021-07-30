package justtobesafe.decoy;

import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityPaths;
import justtobesafe.asset.AssetPaths;

public class DecoyController {
    @FXML AnchorPane DecoyMenu;
    ActivityHandler activityHandler = new ActivityHandler();

    public void onFunctionKeyPress(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
            activityHandler.loadActivity(ActivityPaths.homeMenu, AssetPaths.title, AssetPaths.icon);
            activityHandler.closeStage(DecoyMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F1)) {
            activityHandler.loadActivity(ActivityPaths.homeMenu, AssetPaths.title, AssetPaths.icon);
            activityHandler.closeStage(DecoyMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F2)) {
            activityHandler.loadActivity(ActivityPaths.cardMenu,AssetPaths.title,AssetPaths.icon);
            activityHandler.closeStage(DecoyMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F3)) {
            activityHandler.loadActivity(ActivityPaths.accountMenu,AssetPaths.title,AssetPaths.icon);
            activityHandler.closeStage(DecoyMenu);
        }else if (keyEvent.getCode().equals(KeyCode.F4)) {
            activityHandler.loadActivity(ActivityPaths.settingsMenu,AssetPaths.title,AssetPaths.icon);
            activityHandler.closeStage(DecoyMenu);
        }else if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            if(Desktop.isDesktopSupported()){
                Desktop desktop = Desktop.getDesktop();
                try {
                    desktop.browse(new URI("http://www.google.com"));
                } catch (IOException | URISyntaxException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }else{
                Runtime runtime = Runtime.getRuntime();
                try {
                    runtime.exec("xdg-open " + "http://www.google.com");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            activityHandler.closeStage(DecoyMenu);
        }
    }
}
