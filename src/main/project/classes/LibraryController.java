package PACKAGE_NAME.src.main.project.classes;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.control.Tooltip;

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

    @FXML
    public void initialize() {
        Tooltip story1Tooltip = new Tooltip("YO AND WELCOME TO DTORY MOTHERFUCKING 1 BITCH");
        Tooltip story2Tooltip = new Tooltip("HELLO AND WELCOME TO STORY 2 CUTE PATOTTIE :)");

        setupTooltip(story1TooltipLabel, story1Tooltip);
        setupTooltip(story2TooltipLabel, story2Tooltip);
    }

    private void setupTooltip(Label label, Tooltip tooltip) {
        label.setOnMouseEntered(event -> {
            Node node = (Node) event.getSource();
            Tooltip.install(node, tooltip);
        });

        label.setOnMouseExited(event -> {
            Node node = (Node) event.getSource();
            Tooltip.uninstall(node, tooltip);
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

