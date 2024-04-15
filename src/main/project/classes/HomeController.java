package PACKAGE_NAME.src.main.project.classes;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HomeController {
    @FXML
    private Label helloLabel;

    @FXML
    private TextField inputField;
    private String name;

    @FXML
    public void initialize() {
        name = inputField.getText();
    }

    @FXML
    public void sayHello() {
        helloLabel.setText("Hello, JavaFX!");
    }


    public void displayVariable() {
        String myVariable = name;
        inputField.setText(myVariable);
        System.out.println(name);
    }
}
