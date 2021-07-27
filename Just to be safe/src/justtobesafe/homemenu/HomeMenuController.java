package justtobesafe.homemenu;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import justtobesafe.encryption.EncryptionHandler;

import java.io.IOException;

public class HomeMenuController {
    private String accountMenu_location="/justtobesafe/accountmenu/accountmenu_activity.fxml";
    private String cardMenu_location="/justtobesafe/cardmenu/cardmenu_activity.fxml";
    private String settingsMenu_location="/justtobesafe/settingsmenu/settingsmenu_activity.fxml";

    EncryptionHandler encryptionHandler=new EncryptionHandler();

    @FXML
    AnchorPane HomeMenu;







    private void loadActivity(String activityLocation) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(activityLocation));
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Just to be safe");
            primaryStage.getIcons().add(new Image("/resources/icon_inverse.png"));
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
        catch (IOException ex) {
        }
    }
    //Close activity
    private void closeStage() {
        ((Stage) HomeMenu.getScene().getWindow()).close();
    }

    //Click Accounts & Passwords button
    public void onAccountButtonClicked(MouseEvent mouseEvent) {
        closeStage();
        loadActivity(accountMenu_location);
    }
    //Click Settings button
    public void onSettingsButtonClicked(MouseEvent mouseEvent) {
        closeStage();
        loadActivity(settingsMenu_location);
    }
    //Click Credit Cards button
    public void onCardButtonClicked(MouseEvent mouseEvent) {
        closeStage();
        loadActivity(cardMenu_location);
    }
}
