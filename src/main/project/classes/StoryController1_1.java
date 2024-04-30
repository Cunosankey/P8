package PACKAGE_NAME.src.main.project.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.Console;
import java.io.IOException;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class StoryController1_1 extends StoryController1 {
    @Override
    public void initialize() {
        super.initialize();
        if (getStoryDescriptionLabel2() != null) {
            getTitleLabel().setText(getStories().get(getCurrentStory()).getTitle());
            getStoryDescriptionLabel2().setText(getStories().get(getCurrentStory()).getStoryDescription2());
        }
        progressManager.resetCircles();
        progressManager.fillCircle("Story1-1");

    }

    public boolean isStory1_1() {
        return true;
    }

    public void toTask(ActionEvent event) throws IOException {
        StoryProgress.setStory1Completed(true);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../scenes/Task.fxml"));
        Parent newSceneParent = loader.load();
        TaskController controller = loader.getController();

        // Create the Task and TaskDescription
        Task task1 = new Task();
        TaskDescription taskDescription1 = TaskDescription.createTaskDescription1();
        task1.setTaskDescription(taskDescription1);

        // Set the task in the controller
        controller.setTask(task1);

        Scene newScene = new Scene(newSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    public void backAgain(ActionEvent event) throws IOException {
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("../scenes/Story1.fxml"));
        Scene newScene = new Scene(newSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }

    // Returns the current story object
    public Story getCurrentStoryObject() {
        return getStories().get(getCurrentStory());
    }
}
