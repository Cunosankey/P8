package main.project.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StoryController2_1 extends StoryController2{
    @Override
    public void initialize() {
        super.initialize(); // Call the initialize method from the superclass
        if (getStoryDescriptionLabel2() != null) {
            getTitleLabel().setText(getStories().get(getCurrentStory()).getTitle()); // Set the title of the story
            getStoryDescriptionLabel2().setText(getStories().get(getCurrentStory()).getStoryDescription2()); // Set the story description
        }
        storyProgress.resetCircles(); // Reset the circles in the progress bar in the bottom
        storyProgress.fillCircle("Story2-1"); // Fill the circle for the second story
    }
    // This method is called when the user clicks the "To Task" button
    public void toTask(ActionEvent event) throws IOException {
        AudioController.stopAudio();
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("../scenes/Task.fxml"));
        Scene newScene = new Scene(newSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
    // This method is called when the user clicks the "Back" button
    public void backAgain(ActionEvent event) throws IOException {
        AudioController.stopAudio();
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("../scenes/Story2.fxml"));
        Scene newScene = new Scene(newSceneParent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
}

