package PACKAGE_NAME.src.main.project.classes;

public class Audio {
    private String audioFilePath;
    private String filePath;

    public Audio(String audioFilePath) {
        this.audioFilePath = audioFilePath;
    }

    // Getter method for audio file path
    public String getAudioFilePath() {
        return audioFilePath;
    }

    public String getFilePath() {
        return filePath;
    }

}
