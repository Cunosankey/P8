package PACKAGE_NAME.src.main.project.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
