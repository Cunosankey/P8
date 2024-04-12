package PACKAGE_NAME.src.main.sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label helloLabel;

    @FXML
    public void sayHello() {
        helloLabel.setText("Hello, JavaFX!");
    }
}
