package PACKAGE_NAME.src.main.project.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ReflectController {
    // Method called when the JavaFX component is initialized
    public void switchToEndScene(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource(); // Get the source of the event (the button)
        Stage stage = (Stage) node.getScene().getWindow(); // Get the stage from the button
        Scene scene = stage.getScene(); // Get the scene from the stage
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/EndScene.fxml")); // Load the FXML file
        Parent root = fxmlLoader.load(); // Load the FXML file into a Parent object
        scene.setRoot(root); // Set the scene root to the new FXML file
    }
}
