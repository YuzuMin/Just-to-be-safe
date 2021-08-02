package justtobesafe.activity;

// JavaFX imports
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
// Java imports
import java.io.IOException;

public class ActivityHandler {

    public void loadActivity(String activityLocation,String title,String iconPath) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(activityLocation));
            Stage primaryStage = new Stage();
            primaryStage.setTitle(title);
            primaryStage.getIcons().add(new Image(iconPath));
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch (IOException ex) {
        }
    }
    //Close activity
    public void closeStage(AnchorPane anchorPane) {
        ((Stage) anchorPane.getScene().getWindow()).close();
    }
}
