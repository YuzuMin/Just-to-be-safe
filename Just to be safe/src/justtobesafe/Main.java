package justtobesafe;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
//import javafx.scene.layout.StackPane;

public class Main extends Application {


    @FXML
    private TextField password;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Login/login_activity.fxml"));
        primaryStage.setTitle("Just to be safe");
        Image image = new Image("file:/icon.png");
        primaryStage.getIcons().add(new Image("/resources/icon_inverse.png"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void closeStage() {
        ((Stage) password.getScene().getWindow()).close();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
