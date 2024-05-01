package PACKAGE_NAME.src.main.project.classes;

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

    public StoryProgress(HBox circleContainer, int totalCircles) {
        this.circleContainer = circleContainer;
        this.totalCircles = totalCircles;
        this.circles = new ArrayList<>(); // Initialize the list of circles
    }

    public void createCircles() {
        for (int i = 0; i < totalCircles; i++) {
            Circle circle = new Circle(5);
            circle.setFill(Color.rgb(0xDC, 0xDC, 0xDC));
            // circle.setStroke(Color.rgb(0xE6, 0xD8, 0xFA));
            circleContainer.getChildren().add(circle);
            circles.add(circle);
        }
    }

    public void fillCircle(String sceneName) {
        switch (sceneName) {
            case "Story1":
                circles.get(0).setFill(Color.rgb(0x7B, 0x68, 0xEE));
                break;
            case "Story1-1":
                circles.get(1).setFill(Color.rgb(0x7B, 0x68, 0xEE));
                break;
            case "Story2":
                circles.get(0).setFill(Color.rgb(0x7B, 0x68, 0xEE));
                break;
            case "Story2-1":
                circles.get(1).setFill(Color.rgb(0x7B, 0x68, 0xEE));
                break;
            case "Task":
                circles.get(2).setFill(Color.rgb(0x7B, 0x68, 0xEE));
                break;
            case "Reflect":
                circles.get(3).setFill(Color.rgb(0x7B, 0x68, 0xEE));
                break;
            default:
                break;
        }
    }

    /**
     * Makes the circles white to reset the progress when we change scene.
     */
    public void resetCircles() {
        for (Circle circle : circles) {
            circle.setFill(Color.rgb(0xDC, 0xDC, 0xDC));
        }
    }

    public static boolean isStory1Completed() {
        return isStory1Completed;
    }

    public static void setStory1Completed(boolean story1Completed) {
        isStory1Completed = story1Completed;
    }
}
