package PACKAGE_NAME.src.main.project.classes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;


public class LibraryController {
    @FXML
    private GridPane gridPane;

    @FXML
    private Label story1TooltipLabel;

    @FXML
    private Label story2TooltipLabel;

    // Method called when the JavaFX component is initialized
    @FXML
    public void initialize() {
        // Create two tooltips with custom text
        Tooltip story1Tooltip = new Tooltip("YO AND WELCOME TO DTORY MOTHERFUCKING 1 BITCH");
        Tooltip story2Tooltip = new Tooltip("HELLO AND WELCOME TO STORY 2 CUTE PATOTTIE :)");

        // Set up the tooltips for the corresponding labels
        setupTooltip(story1TooltipLabel, story1Tooltip);
        setupTooltip(story2TooltipLabel, story2Tooltip);
    }


    /**
     * Sets up a tooltip for a given label.
     *
     * @param label the label to which the tooltip will be attached
     * @param tooltip the tooltip to be displayed
     */
    // Private method to set up a tooltip for our "?" labels (helper method)
    private void setupTooltip(Label label, Tooltip tooltip) {
        // Add a mouse click event handler to the label
        label.setOnMouseClicked(event -> {
            // Check if the tooltip is currently showing
            if (tooltip.isShowing()) {
                // If it is, hide it
                tooltip.hide();
            } else {
                // Get the screen coordinates of the label
                Bounds bounds = label.localToScreen(label.getBoundsInLocal());
                // Show the tooltip right above the label
                tooltip.show(label, bounds.getMinX(), bounds.getMinY() - tooltip.getHeight());
            }
        });
        // Add a change listener to the scene property of the label
        label.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                // Add a mouse press event filter to the root of the scene
                newScene.getRoot().addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
                    // Get the node that was clicked
                    Node node = (Node) event.getTarget();
                    // Check if the node is not the label and the tooltip is showing
                    if (node != label && tooltip.isShowing()) {
                        // If it is, hide the tooltip
                        tooltip.hide();
                    }
                });
            }
        });
    }



    @FXML
    public void spil(ActionEvent event) throws IOException {
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("../scenes/Story1.fxml"));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
    public void spil2(ActionEvent event) throws IOException {
        if (!StoryProgress.isStory1Completed()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Denne historie er låst");
            alert.setHeaderText(null);
            alert.setContentText("Færdiggør den første historie først!");

            alert.showAndWait();
            // We return here to ensure the scene shift does not happend.
            // (Return to exit the method early if the first condition is true) It doesn't actually return a value.
            return;
        }
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("../scenes/Story2.fxml"));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
}

