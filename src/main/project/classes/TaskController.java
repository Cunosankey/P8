package PACKAGE_NAME.src.main.project.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.scene.image.Image;

public class TaskController implements Initializable {

    private StoryCharacter storyCharacter;

    public TaskController() {
        // Create the StoryCharacter object
        storyCharacter = new StoryCharacter("Character1", "Gesture1", "src/main/images/body.png", "FacialExpression1", "src/main/images/Face.png");
        // Add more gestures and facial expressions
        storyCharacter.addGesture("Gesture2", "src/main/images/bab.jpg");
        storyCharacter.addFacialExpression("FacialExpression2", "src/main/images/bab.jpg");
    }

    public void changeSceneReflect(ActionEvent event) throws IOException {
        Parent newSceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("src/main/project/scenes/Reflect.fxml")));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    // Load images as soon as TaskController is initialized
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateCharacterFacialExpression();
        updateCharacterGesture();
    }

    // Check current task (to play audio)
    private Task currentTask;

    // Method to play audio file (called in the FXML file)
//    @FXML
//    public void playAudio() {
//        if (currentTask != null) {
//            currentTask.playAudio();
//        }
//    }

    // Method to change element in characterGesture arraylist
    private int currentGestureIndex = 0;

    @FXML
    private ImageView characterGestureImage;

    public void updateCharacterGesture() {
        List<Gesture> characterGestureList = storyCharacter.getCharacterGesture();
        String imagePath = characterGestureList.get(currentGestureIndex).getGestureImagePath();
        Image image = new Image("file:" + imagePath);
        if (image.isError()) {
            System.out.println("Error loading image: " + image.getException()); // Print the exception if there is an error loading the image
        }
        characterGestureImage.setImage(image);

        // Increment currentGestureIndex
        currentGestureIndex = (currentGestureIndex + 1) % characterGestureList.size();
    }

    public String chosenGesture() {
        List<Gesture> characterGestureList = storyCharacter.getCharacterGesture();
        return characterGestureList.get(currentGestureIndex).getGestureID();
    }

    // Method to change element in FacialExpression arraylist
    private int currentFacialExpressionIndex = 0;

    @FXML
    private ImageView characterFacialExpressionImage;

    public void updateCharacterFacialExpression() {
        List<FacialExpression> characterFacialExpressionList = storyCharacter.getCharacterFacialExpression();
        String imagePath = characterFacialExpressionList.get(currentFacialExpressionIndex).getFacialExpressionImagePath();
        Image image = new Image("file:" + imagePath);
        if (image.isError()) {
            System.out.println("Error loading image: " + image.getException()); // Print the exception if there is an error loading the image
        }
        characterFacialExpressionImage.setImage(image);

        // Increment currentGestureIndex
        currentFacialExpressionIndex = (currentFacialExpressionIndex + 1) % characterFacialExpressionList.size();
    }

    public String chosenFacialExpression() {
        List<FacialExpression> characterFacialExpressionList = storyCharacter.getCharacterFacialExpression();
        return characterFacialExpressionList.get(currentFacialExpressionIndex).getFacialExpressionID();
    }

}

