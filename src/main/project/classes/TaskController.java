package PACKAGE_NAME.src.main.project.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javafx.scene.image.Image;

public class TaskController {
    public void changeSceneReflect(ActionEvent event) throws IOException {
        Parent newSceneParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("src/main/project/scenes/Reflect.fxml")));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    // Check current task (to play audio)
    private Task currentTask;

    // Method to play audio file (called in the FXML file)
    @FXML
    public void playAudio() {
        if (currentTask != null) {
            currentTask.playAudio();
        }
    }

    // Method to change element in characterGesture arraylist
    private ArrayList<String> characterGesture;
    private int currentGestureIndex = 0;

    @FXML
    private ImageView characterGestureImage;

    public void updateCharacterGesture() {
        String imagePath = characterGesture.get(currentGestureIndex);
        Image image = new Image("file:" + imagePath);
        characterGestureImage.setImage(image);

        // Increment currentGestureIndex
        currentGestureIndex = (currentGestureIndex + 1) % characterGesture.size();
    }

    // Getter for the ChosenGesture (use this to get the current gesture in REFLECT)
    public String ChosenGesture() {
        return characterGesture.get(currentGestureIndex);
    }



}
