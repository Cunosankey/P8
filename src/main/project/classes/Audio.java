package main.project.classes;

import java.io.File;

public class Audio {
    private String filePath;

    // Constructor
    public Audio(String filePath) {
        this.filePath = filePath;
    }

    // Getter method for the file path
    public String getFilePath() {
        return filePath;
    }
}