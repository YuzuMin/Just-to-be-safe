package justtobesafe;

// Java FX Imports
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityPaths;
import justtobesafe.asset.AssetPaths;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ActivityHandler activityHandler = new ActivityHandler();
        activityHandler.loadActivity(ActivityPaths.loginActivity, AssetPaths.title, AssetPaths.icon);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
