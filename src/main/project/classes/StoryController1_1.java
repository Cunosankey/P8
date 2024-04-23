package PACKAGE_NAME.src.main.project.classes;

public class StoryController1_1 extends StoryController1 {
    @Override
    public void initialize() {
        super.initialize();
        if (getStoryDescriptionLabel2() != null) {
            getTitleLabel().setText(getStories().get(getCurrentStory()).getTitle());
            getStoryDescriptionLabel2().setText(getStories().get(getCurrentStory()).getStoryDescription2());
        }

    }
}
