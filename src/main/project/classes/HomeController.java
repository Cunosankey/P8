package PACKAGE_NAME.src.main.project.classes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HomeController {
    @FXML
    private Label helloLabel;

    @FXML
    public void sayHello() {
        helloLabel.setText("Hello, JavaFX!");
    }
}
