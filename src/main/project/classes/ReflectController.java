package PACKAGE_NAME.src.main.project.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;


public class ReflectController {
    @FXML
    private HBox circleContainer;

    public StoryProgress storyProgress;

    public void initialize() {
        // Create the ProgressManager object
        storyProgress = new StoryProgress(circleContainer, 4);
        storyProgress.resetCircles();
        storyProgress.createCircles();
        storyProgress.fillCircle("Reflect");
    }


    public void done(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/Library.fxml"));
        Parent root = fxmlLoader.load();
        scene.setRoot(root);
    }
}
