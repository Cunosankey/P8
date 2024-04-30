package PACKAGE_NAME.src.main.project.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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

    // Load images as soon as TaskController is initialized
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        updateCharacterFacialExpression();
        updateCharacterGesture();
        Task task1 = new Task();
        TaskDescription taskDescription1 = TaskDescription.createTaskDescription1();
        task1.setTaskDescription(taskDescription1);
        setTask(task1);
    }

    // Check current task (to play audio)
    private Task currentTask;

    // Get the title and description of the task
    @FXML
    private Label titleLabel;

    @FXML
    private TextFlow descriptionTextFlow;

    // Method to set the title and description of the task

    public void setTask(Task task) {
        TaskDescription taskDescription = task.getTaskDescription();

        // Set the title
        titleLabel.setText(taskDescription.getTitle());

        // Create a Text object and set its text
        Text descriptionText = new Text(taskDescription.getDescription());

        // Clear the TextFlow and add the new Text
        descriptionTextFlow.getChildren().clear();
        descriptionTextFlow.getChildren().add(descriptionText);
    }

    // Method to change element in characterGesture arraylist
    // Static to keep track of current gesture index
    private static int currentGestureIndex = 0;

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


    // Method to change element in FacialExpression arraylist
    private static int currentFacialExpressionIndex = 0;

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

    // Method to go back to the previous scene
    public void backButton(ActionEvent event) throws IOException {
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("../scenes/Story1-1.fxml"));
        Scene newScene = new Scene(newSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    // Method to go to the Reflect scene
    public void gotoReflect(ActionEvent event) throws IOException {
        if (storyCharacter == null) {
            System.out.println("storyCharacter is null");
            return;
        }

        // Update image methods before going to Reflect scene to ensure the images are updated
        updateCharacterFacialExpression();
        updateCharacterGesture();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../scenes/Reflect.fxml"));
        // lambda function that creates a new instance of ReflectController
        loader.setControllerFactory(c -> new ReflectController(storyCharacter, currentFacialExpressionIndex, currentGestureIndex));

        Parent newSceneParent = loader.load();
        Scene newScene = new Scene(newSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

}

