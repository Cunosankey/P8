package main.project.classes;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReflectController implements Initializable {

    @FXML
    private ImageView facialExpressionImage;

    @FXML
    private ImageView gestureImage;

    private int facialExpressionIndex;
    private int gestureIndex;
    private StoryCharacter storyCharacter;

    @FXML
    private HBox circleContainer;

    public StoryProgress storyProgress;

    public ReflectController(StoryCharacter storyCharacter, int facialExpressionIndex, int gestureIndex) {
        this.storyCharacter = storyCharacter;
        this.facialExpressionIndex = facialExpressionIndex;
        this.gestureIndex = gestureIndex;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<FacialExpression> characterFacialExpressionList = storyCharacter.getCharacterFacialExpression();
        String imagePath = characterFacialExpressionList.get(facialExpressionIndex).getFacialExpressionImagePath();
        Image image = new Image("file:" + imagePath);
        facialExpressionImage.setImage(image);

        List<Gesture> characterGestureList = storyCharacter.getCharacterGesture();
        String gestureImagePath = characterGestureList.get(gestureIndex).getGestureImagePath();
        Image currentGestureImage = new Image("file:" + gestureImagePath);
        gestureImage.setImage(currentGestureImage);

        // Create the ProgressManager object
        storyProgress = new StoryProgress(circleContainer, 4);
        storyProgress.resetCircles();
        storyProgress.createCircles();
        storyProgress.fillCircle("Reflect");
    }

    // Go back to the previous scene
    public void goBackReflect(ActionEvent event) {
        try {
            Parent previousSceneParent = FXMLLoader.load(getClass().getResource("../scenes/Task.fxml")); // replace with your previous scene file
            Scene previousScene = new Scene(previousSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(previousScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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