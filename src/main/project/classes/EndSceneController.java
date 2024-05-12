package main.project.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class EndSceneController {

    @FXML
    Label endSceneTitle;

    @FXML
    private Button endButton;

    public void initialize() {
        // Load Font
        Font urbaneBold = Font.loadFont(getClass().getResource("/fonts/Urbane-Bold.ttf").toExternalForm(), 50);
        endSceneTitle.setFont(urbaneBold);
        endSceneTitle.setTextFill(Color.web("#222222"));

        // Load Animation class
        Animations.buttonAnimation(endButton);
    }

    // Method called when the JavaFX component is initialized
    public void switchToLibrary(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource(); // Get the source of the event (the button)
        Stage stage = (Stage) node.getScene().getWindow(); // Get the stage from the button
        Scene scene = stage.getScene(); // Get the scene from the stage
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/Library.fxml")); // Load the FXML file
        Parent root = fxmlLoader.load(); // Load the FXML file into a Parent object
        scene.setRoot(root); // Set the scene root to the new FXML file
    }
}
