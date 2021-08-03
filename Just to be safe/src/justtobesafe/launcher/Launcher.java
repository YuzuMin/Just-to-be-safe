package justtobesafe.launcher;

// JavaFX Imports
import javafx.application.Application;
import javafx.stage.Stage;
// Program imports
import justtobesafe.activity.ActivityHandler;
import justtobesafe.activity.ActivityPaths;
import justtobesafe.asset.AssetPaths;

public class Launcher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ActivityHandler activityHandler = new ActivityHandler();
        activityHandler.loadActivity(ActivityPaths.loginActivity, AssetPaths.title, AssetPaths.icon);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
