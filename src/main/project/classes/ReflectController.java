package main.project.classes;

import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
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

    @FXML
    private Text titleText;
    Font urbaneBold;

    private int facialExpressionIndex;
    private int gestureIndex;
    private StoryCharacter storyCharacter;

    @FXML
    private HBox circleContainer;

    @FXML
    private Button completeTask;

    @FXML
    private Button tryAgain;

    public StoryProgress storyProgress;

    // Constructor for the ReflectController class
    public ReflectController(StoryCharacter storyCharacter, int facialExpressionIndex, int gestureIndex) {
        this.storyCharacter = storyCharacter; // Call the constructor of the superclass to set the storyCharacter
        this.facialExpressionIndex = facialExpressionIndex;
        this.gestureIndex = gestureIndex;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        urbaneBold = Font.loadFont(getClass().getResource("/fonts/Urbane-Bold.ttf").toExternalForm(), 43);
        titleText.setFont(urbaneBold);
        titleText.setText("Tid til at\nreflektere!");
        titleText.setFill(Color.web("#222222"));

    // Load the facial expression and gesture images from the character's list
    List<FacialExpression> characterFacialExpressionList = storyCharacter.getCharacterFacialExpression();
    String imagePath = characterFacialExpressionList.get(facialExpressionIndex).getFacialExpressionImagePath();
    Image image = new Image(getClass().getResource(imagePath).toString());
    // Set the image of the facial expression
    facialExpressionImage.setImage(image);

    // Load the gesture image from the character's gesture list
    List<Gesture> characterGestureList = storyCharacter.getCharacterGesture();
    String gestureImagePath = characterGestureList.get(gestureIndex).getGestureImagePath();
    Image currentGestureImage = new Image(getClass().getResource(gestureImagePath).toString());
    // Set the image of the gesture
    gestureImage.setImage(currentGestureImage);

    // Create a new StoryProgress object to track the progress of the story
    storyProgress = new StoryProgress(circleContainer, 4);
    storyProgress.resetCircles();
    storyProgress.createCircles();
    storyProgress.fillCircle("Reflect");

    // Load Animation class
    Animations.buttonAnimation(completeTask);
    Animations.buttonAnimation(tryAgain);

}

    // Go back to the previous scene
    public void goBackReflect(ActionEvent event) {
        try {
            Parent previousSceneParent = FXMLLoader.load(getClass().getResource("/scenes/Task.fxml")); // replace with your previous scene file
            Scene previousScene = new Scene(previousSceneParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(previousScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to go to the Library scene
    public void ReflectToLibrary(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource(); // Get the source of the event (the button)
        Stage stage = (Stage) node.getScene().getWindow(); // Get the stage from the button
        Scene scene = stage.getScene(); // Get the scene from the stage
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/Library.fxml")); // Load the FXML file
        Parent root = fxmlLoader.load(); // Load the FXML file into a Parent object
        scene.setRoot(root); // Set the scene root to the new FXML file
    }

    // Method called when the JavaFX component is initialized
    public void switchToEndScene(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource(); // Get the source of the event (the button)
        Stage stage = (Stage) node.getScene().getWindow(); // Get the stage from the button
        Scene scene = stage.getScene(); // Get the scene from the stage
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/EndScene.fxml")); // Load the FXML file
        Parent root = fxmlLoader.load(); // Load the FXML file into a Parent object
        scene.setRoot(root); // Set the scene root to the new FXML file
    }
}