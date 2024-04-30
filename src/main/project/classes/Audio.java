package PACKAGE_NAME.src.main.project.classes;

import java.io.File;

public class Audio {
    private String filePath;

    // Constructor
    public Audio(String filePath) {
        this.filePath = filePath;
    }

    // Getter method for the file path
    public String getFilePath() {
        File file = new File(filePath);
        return file.toURI().toString();
    }
}