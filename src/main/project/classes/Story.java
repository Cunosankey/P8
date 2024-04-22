package PACKAGE_NAME.src.main.project.classes;

import javafx.scene.image.Image;

public class Story {
    private String title;
    private String storyDescription;
    private Image storyImage;
    private String moreInfo;
    private Image backGround;
    private boolean locked;
    private Audio audioFile;
    private boolean completed;

    public Story(String title, String storyDescription) {
        this.title = title;
        this.storyDescription = storyDescription;
    }

    public String getTitle() {
        return title;
    }

    public String getStoryDescription() {
        return storyDescription;
    }

    public Image getStoryImage() {
        return storyImage;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public Image getBackGround() {
        return backGround;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isCompleted(){
        return completed;
    }

    public void setCompleted(boolean completed){
        this.completed = completed;
    }

    public Audio getAudioFile() {
        return audioFile;
    }

    /*public void playAudio() {
        if (audioFile != null) {
            AudioController.playAudio(audioFile.getFilePath());
        }
    }
*/
}

