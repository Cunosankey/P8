package main.project.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class StoryController2 extends StoryController1 {
    @FXML
    private Label titleLabel;
    @FXML
    private TextArea storyDescriptionLabel;
    @FXML
    private TextArea storyDescriptionLabel2;

    private final int currentStory = 0;

    private final List<Story> stories = new ArrayList<>();

    public StoryController2() {
        loadStoriesFromFile("src/main/project/scenes/Stories/Story2.txt");
    }

    public List<Story> getStories() {
        return stories;
    }

    @FXML
    private HBox circleContainer;

    public StoryProgress storyProgress;

    /**
     * @param filename This method reads the stories from a file and adds them to the stories list.
     *                 It seperates the title and the story description by a comma.
     */
    // This method reads the stories from a file and adds them to the stories ArrayList.
    private void loadStoriesFromFile(String filename) {

        // The method uses a try-with-resources statement to ensure that the BufferedReader is closed after it's no longer needed. This is a good practice to avoid resource leaks.
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            // While loop to read the file line by line
            while ((line = reader.readLine()) != null) {
                // Each line is split into parts using a plus (+) as the delimiter.
                // + is a special character in regular expressions, so it needs to be escaped with two backslashes (\\) to be treated as a literal plus sign.
                String[] parts = line.split("\\+");
                // The first part is considered the title, and the second part is considered the story description.
                String title = parts[0];
                String storyDescription = parts[1];
                String storyDescription2 = parts[2];

                // A new Story object is created using the extracted title and story description.
                Story story = new Story(title, storyDescription, storyDescription2);

                // Then add the newly created story object to the "stories" ArrayList.
                stories.add(story);
            }
            // If any IOException occurs during the file reading process, it's caught and the error message is printed to the console.
            //  IOException is typically thrown when an error occurs while performing input or output operations, such as reading or writing to a file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // This method is called when the user clicks the "Continue" button
    public void handleButtonAction(ActionEvent event) throws IOException {
        AudioController.stopAudio();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/Story2-1.fxml"));
        Parent root = fxmlLoader.load();
        scene.setRoot(root);
    }
    // This method is called when the user clicks the "Back" button
    public void backHandle(ActionEvent event) throws IOException {
        AudioController.stopAudio();
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Scene scene = stage.getScene();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../scenes/Library.fxml"));
        Parent root = fxmlLoader.load();
        scene.setRoot(root);
    }

    /**
     * if the story list is not empty, it sets the title and story description of the first story
     * in the list to the corresponding labels.
     */
    public void initialize() {
         if (!stories.isEmpty()) {
            if (titleLabel != null && storyDescriptionLabel != null) {
                // The setText() method is used to set the text content of the labels to the title and story description of the first story in the list.
                // The get() method is used to access the story object at the specified index (0 in this case).
                // The getTitle() and getStoryDescription() methods are used to retrieve the title and story description of the story object.
                titleLabel.setText(stories.get(currentStory).getTitle());
                storyDescriptionLabel.setText(stories.get(currentStory).getStoryDescription());
            }
        }
        // The ProgressManager class is instantiated with the circleContainer and the total number of circles (4 in this case).
        storyProgress = new StoryProgress(circleContainer, 4);
        storyProgress.resetCircles();
        storyProgress.createCircles();
        storyProgress.fillCircle("Story2");
    }

    // Why do we put these as protected? This is because we want to be able to access them from the subclasses.
    protected TextArea getStoryDescriptionLabel2() {
        return storyDescriptionLabel2;
    }

    protected int getCurrentStory() {
        return currentStory;
    }
    protected Label getTitleLabel() {
        return titleLabel;
    }

}
