package PACKAGE_NAME.src.main.project.classes;

public class Audio {
    private String filePath;

    // Constructor
    public Audio(String filePath) {
        this.filePath = filePath;
    }

    // Getter method for the file path
    public String getFilePath() {
        return getClass().getResource(filePath).toExternalForm();
    }
}