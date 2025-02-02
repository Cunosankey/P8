package main.project.classes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class LibraryController {
    @FXML
    private GridPane gridPane;

    @FXML
    private Label story1TooltipLabel;

    @FXML
    private Label story2TooltipLabel;

    @FXML
    private Button story2Button;

    @FXML
    private Button startSpil1;

    @FXML
    private ImageView storyImage;

    @FXML
    private Label mainTitle;

    @FXML
    Label title1;

    @FXML
    Label title2;


    // Method called when the JavaFX component is initialized
    @FXML
    public void initialize() {
        // Load font
        Font urbaneBoldSize50 = Font.loadFont(getClass().getResource("/fonts/Urbane-Bold.ttf").toExternalForm(), 50);
        mainTitle.setFont(urbaneBoldSize50);
        mainTitle.setTextFill(Color.web("#222222"));

        Font urbaneBoldSize26 = Font.loadFont(getClass().getResource("/fonts/Urbane-Bold.ttf").toExternalForm(), 26);
        title1.setFont(urbaneBoldSize26);
        title1.setTextFill(Color.web("#222222"));
        title2.setFont(urbaneBoldSize26);
        title2.setTextFill(Color.web("#222222"));

        Font urbaneBoldSize30 = Font.loadFont(getClass().getResource("/fonts/Urbane-Bold.ttf").toExternalForm(), 30);
        story1TooltipLabel.setFont(urbaneBoldSize30);
        story1TooltipLabel.setTextFill(Color.web("#ffffff"));
        story2TooltipLabel.setFont(urbaneBoldSize30);
        story2TooltipLabel.setTextFill(Color.web("#ffffff"));
        // Load Animation class
        Animations.buttonAnimation(story2Button);
        Animations.buttonAnimation(startSpil1);

        // Create two tooltips with custom text
        Tooltip story1Tooltip = new Tooltip("Jeppe spiller Roblox med en ven. Tryk på Play-knappen for at starte historien.");
        Tooltip story2Tooltip = new Tooltip("Historie 2 er endnu ikke tilgængelig. Færdiggør historie 1 for at låse op.");

        // Set up the tooltips for the corresponding labels
        setupTooltip(story1TooltipLabel, story1Tooltip);
        setupTooltip(story2TooltipLabel, story2Tooltip);

        // Disable the spil2 button if the first story is not completed
        story2Button.setDisable(!StoryProgress.isStory1Completed());
        Image lockedImage;
        if (StoryProgress.isStory1Completed()) {
            lockedImage = new Image(getClass().getResourceAsStream("/images/Story1billede2.png"));
        } else {
            lockedImage = new Image(getClass().getResourceAsStream("/images/Story2lock.png"));
        }
        storyImage.setImage(lockedImage);
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


    // Method called when the "Historie 1" button is clicked
    @FXML
    public void spil(ActionEvent event) throws IOException {
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("/scenes/Story1.fxml"));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
    // Method called when the "Historie 2" button is clicked. Kinda useless since it does nothing anymore?
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
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("/scenes/Story2.fxml"));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
}

