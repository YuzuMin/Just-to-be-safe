package justtobesafe.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class AlertPopup {
    public static boolean confirmation(String displayText,String smallText, String displayTitle){
        boolean retValue=false;
        Alert alert =
                new Alert(Alert.AlertType.CONFIRMATION,
                        smallText,
                        ButtonType.YES,
                        ButtonType.NO);
        alert.setTitle(displayTitle);
        alert.setHeaderText(displayText);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.YES) {
            retValue= true;
        }
        return retValue;
    }
}
