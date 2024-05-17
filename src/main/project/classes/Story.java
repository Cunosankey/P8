package main.project.classes;
import javafx.scene.image.Image;

public class Story {
    private String title;
    private String storyDescription;
    private String storyDescription2;

    public Story(String title, String storyDescription, String storyDescription2) {
        this.title = title;
        this.storyDescription = storyDescription;
        this.storyDescription2 = storyDescription2;
    }

    public String getTitle() {
        return title;
    }

    public String getStoryDescription() {
        return storyDescription;
    }

    public String getStoryDescription2() {
        return storyDescription2;
    }
}

