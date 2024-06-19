package main.project.classes;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

// THis class is used to keep track of the progress of the story.
public class StoryProgress {
    private static boolean isStory1Completed = false;
    private HBox circleContainer;
    private int totalCircles;
    private List<Circle> circles;

    // Constructor for the StoryProgress class
    public StoryProgress(HBox circleContainer, int totalCircles) {
        this.circleContainer = circleContainer; // Call the constructor of the superclass (StoryProgress) with the circle container
        this.totalCircles = totalCircles;
        this.circles = new ArrayList<>(); // Initialize the list of circles
    }
    // This method creates the circles that represent the progress of the story.
    public void createCircles() {
        for (int i = 0; i < totalCircles; i++) {
            Circle circle = new Circle(5);
            circle.setFill(Color.rgb(0xDC, 0xDC, 0xDC));
            // Add the circle to the circle container
            circleContainer.getChildren().add(circle);
            circles.add(circle);
        }
    }

    // This method fills the circle with a color when a scene is completed.
    public void fillCircle(String sceneName) {
        switch (sceneName) {
            case "Story1":
                circles.get(0).setFill(Color.rgb(182, 137, 192));
                break;
            case "Story1-1":
                circles.get(1).setFill(Color.rgb(182, 137, 192));
                break;
            case "Story2":
                circles.get(0).setFill(Color.rgb(182, 137, 192));
                break;
            case "Story2-1":
                circles.get(1).setFill(Color.rgb(182, 137, 192));
                break;
            case "Task":
                circles.get(2).setFill(Color.rgb(182, 137, 192));
                break;
            case "Reflect":
                circles.get(3).setFill(Color.rgb(182, 137, 192));
                break;
            default:
                break;
        }
    }

    /**
     * Makes the circles white to reset the progress when we change scene.
     */
    public void resetCircles() {
        for (Circle circle : circles) { // Loop through the circles
            circle.setFill(Color.rgb(0xDC, 0xDC, 0xDC)); // Set the fill color of the circle to white
        }
    }

    // This method checks if the first story is completed.
    public static boolean isStory1Completed() {
        return isStory1Completed;
    }

    // This method sets the first story as completed.
    public static void setStory1Completed(boolean story1Completed) {
        isStory1Completed = story1Completed;
    }
}
