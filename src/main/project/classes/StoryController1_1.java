package PACKAGE_NAME.src.main.project.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StoryController1_1 extends StoryController1 {
    @Override
    public void initialize() {
        super.initialize();
        if (getStoryDescriptionLabel2() != null) {
            getTitleLabel().setText(getStories().get(getCurrentStory()).getTitle());
            getStoryDescriptionLabel2().setText(getStories().get(getCurrentStory()).getStoryDescription2());
        }
    }

    public boolean isStory1_1(){
        return true;
    }

    public void toTask(ActionEvent event) throws IOException {
        StoryProgress.setStory1Completed(true);
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("../scenes/Task.fxml"));
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
}
