package PACKAGE_NAME.src.main.project;

// THis class is used to keep track of the progress of the story.
public class StoryProgress {
    private static boolean isStory1Completed = false;

    public static boolean isStory1Completed() {
        return isStory1Completed;
    }

    public static void setStory1Completed(boolean story1Completed) {
        isStory1Completed = story1Completed;
    }
}
