package main.project.classes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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

    @FXML
    private HBox circleContainer;

    @FXML
    private Label titleLabel;

    @FXML
    private TextFlow descriptionTextFlow;

    @FXML
    private Button FacialExpressionReverse;

    @FXML
    private Button FacialExpressionUpdate;

    @FXML
    private Button GestureReverse;

    @FXML
    private Button GestureUpdate;

    @FXML
    private Button taskAfslut;

    @FXML
    private Button taskTilbage;

    @FXML
    private Button playAudioButton;


    private StoryProgress storyProgress;

    public TaskController() {
        // Create the StoryCharacter object
        storyCharacter = new StoryCharacter("Character1", "Gesture1", "/images/0_0.png", "FacialExpression1", "/images/10.png");

        // Add more gestures and facial expressions
        storyCharacter.addGesture("Gesture2", "/images/1_1.png");
        storyCharacter.addGesture("Gesture3", "/images/2_2.png");
        storyCharacter.addGesture("Gesture4", "/images/3_3.png");
        storyCharacter.addGesture("Gesture5", "/images/4_4.png");
        storyCharacter.addGesture("Gesture6", "/images/5_5.png");
        storyCharacter.addFacialExpression("FacialExpression2", "/images/1.png");
        storyCharacter.addFacialExpression("FacialExpression3", "/images/0.png");
        storyCharacter.addFacialExpression("FacialExpression4", "/images/2.png");
        storyCharacter.addFacialExpression("FacialExpression5", "/images/3.png");
        storyCharacter.addFacialExpression("FacialExpression6", "/images/4.png");
        storyCharacter.addFacialExpression("FacialExpression7", "/images/5.png");
        storyCharacter.addFacialExpression("FacialExpression8", "/images/6.png");
        storyCharacter.addFacialExpression("FacialExpression9", "/images/7.png");
        storyCharacter.addFacialExpression("FacialExpression10", "/images/8.png");
        storyCharacter.addFacialExpression("FacialExpression11", "/images/9.png");
    }

    @FXML
    private void playAudio() {
        if(!AudioController.isAudioPlaying()) {
            // Create an instance of Audio
            Audio audio = new Audio("audio_files/Task1.mp3");

            // Create an instance of AudioController and play the audio
            AudioController.playAudio(audio);
        } else {
            AudioController.stopAudio();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Load images as soon as TaskController is initialized
        updateCharacterFacialExpression();
        updateCharacterGesture();

        // Create the ProgressManager object
        storyProgress = new StoryProgress(circleContainer, 4);
        storyProgress.resetCircles();
        storyProgress.createCircles();
        storyProgress.fillCircle("Task");

        // Load Animations Class
        Animations.buttonAnimation(FacialExpressionReverse);
        Animations.buttonAnimation(FacialExpressionUpdate);
        Animations.buttonAnimation(GestureReverse);
        Animations.buttonAnimation(GestureUpdate);
        Animations.buttonAnimation(taskAfslut);
        Animations.buttonAnimation(taskTilbage);
        Animations.buttonAnimation(playAudioButton);
    }

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

        // Increment currentGestureIndex
        currentGestureIndex = (currentGestureIndex + 1) % characterGestureList.size();

        String imagePath = characterGestureList.get(currentGestureIndex).getGestureImagePath();
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        if (image.isError()) {
            System.out.println("Error loading image: " + image.getException()); // Print the exception if there is an error loading the image
        }
        characterGestureImage.setImage(image);
    }

    // Method to reverse the character gesture
    public void reverseCharacterGesture() {
        List<Gesture> characterGestureList = storyCharacter.getCharacterGesture();

        // Decrement currentGestureIndex
        if (currentGestureIndex == 0) {
            currentGestureIndex = characterGestureList.size() - 1; // Wrap around to the end of the list
        } else {
            currentGestureIndex--;
        }

        String imagePath = characterGestureList.get(currentGestureIndex).getGestureImagePath();
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        if (image.isError()) {
            System.out.println("Error loading image: " + image.getException()); // Print the exception if there is an error loading the image
        }
        characterGestureImage.setImage(image);
    }

    private static int currentFacialExpressionIndex = 0;

    @FXML
    private ImageView characterFacialExpressionImage;

    // Method to update the character's facial expression
    public void updateCharacterFacialExpression() {
        List<FacialExpression> characterFacialExpressionList = storyCharacter.getCharacterFacialExpression();

        // Increment currentFacialExpressionIndex
        currentFacialExpressionIndex = (currentFacialExpressionIndex + 1) % characterFacialExpressionList.size();

        String imagePath = characterFacialExpressionList.get(currentFacialExpressionIndex).getFacialExpressionImagePath();
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        if (image.isError()) {
            System.out.println("Error loading image: " + image.getException()); // Print the exception if there is an error loading the image
        }
        characterFacialExpressionImage.setImage(image);
    }

    // Method to reverse the Facial Expression
    public void reverseCharacterFacialExpression() {
        List<FacialExpression> characterFacialExpressionList = storyCharacter.getCharacterFacialExpression();

        // Decrement currentGestureIndex
        if (currentFacialExpressionIndex == 0) {
            currentFacialExpressionIndex = characterFacialExpressionList.size() - 1; // Wrap around to the end of the list
        } else {
            currentFacialExpressionIndex--;
        }

        String imagePath = characterFacialExpressionList.get(currentFacialExpressionIndex).getFacialExpressionImagePath();
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        if (image.isError()) {
            System.out.println("Error loading image: " + image.getException()); // Print the exception if there is an error loading the image
        }
        characterFacialExpressionImage.setImage(image);
    }


    // Method to go back to the previous scene
    public void backButton(ActionEvent event) throws IOException {
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("/scenes/Story1-1.fxml"));
        Scene newScene = new Scene(newSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    // Method to go to the Library scene
    public void TaskToLibrary(ActionEvent event) throws IOException {
        AudioController.stopAudio();
        Node node = (Node) event.getSource(); // Get the source of the event (the button)
        Stage stage = (Stage) node.getScene().getWindow(); // Get the stage from the button
        Scene scene = stage.getScene(); // Get the scene from the stage
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/scenes/Library.fxml")); // Load the FXML file
        Parent root = fxmlLoader.load(); // Load the FXML file into a Parent object
        scene.setRoot(root); // Set the scene root to the new FXML file
    }

    // Method to go to the Reflect scene
    public void gotoReflect(ActionEvent event) throws IOException {
        if (storyCharacter == null) {
            System.out.println("storyCharacter is null");
            return;
        }

        AudioController.stopAudio();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scenes/Reflect.fxml"));

        // lambda function that creates a new instance of ReflectController
        loader.setControllerFactory(c -> new ReflectController(storyCharacter, currentFacialExpressionIndex, currentGestureIndex));

        Parent newSceneParent = loader.load();
        Scene newScene = new Scene(newSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

}

