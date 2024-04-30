package PACKAGE_NAME.src.main.project.classes;

import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to manage the progress of the story.
 * It creates circles that represent the progress of the story.
 * It fills the circles based on the current scene.
 */
public class ProgressManager {
    private HBox circleContainer;
    private int totalCircles;
    private List<Circle> circles;

    public ProgressManager(HBox circleContainer, int totalCircles) {
        this.circleContainer = circleContainer;
        this.totalCircles = totalCircles;
        this.circles = new ArrayList<>(); // Initialize the list of circles
    }

    public void createCircles() {
        for (int i = 0; i < totalCircles; i++) {
            Circle circle = new Circle(5);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            circleContainer.getChildren().add(circle);
            circles.add(circle);
        }
    }

    public void fillCircle(String sceneName) {
        switch (sceneName) {
            case "Story1":
                circles.get(0).setFill(Color.BLACK);
                break;
            case "Story1-1":
                circles.get(1).setFill(Color.BLACK);
                break;
            case "Story2":
                circles.get(0).setFill(Color.BLACK);
                break;
            case "Story2-1":
                circles.get(1).setFill(Color.BLACK);
                break;
            case "Task":
                circles.get(2).setFill(Color.BLACK);
                break;
            case "Reflect":
                circles.get(3).setFill(Color.BLACK);
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
            circle.setFill(Color.WHITE);
        }
    }
}
