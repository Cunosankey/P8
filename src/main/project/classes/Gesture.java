package main.project.classes;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Gesture {
    private BufferedImage GestureImage;
    private String gestureID;
    private String gestureImagePath;

    // Constructor for the Gesture class
    public Gesture(String gestureID, String imagePath) {
        this.gestureID = gestureID; // Call the constructor of the superclass (Gesture) with the gestureID
        this.gestureImagePath = imagePath;
        try {
            // Try to read the image file from the specified path. This can throw an IOException if the file can't be read for any reason.
            this.GestureImage = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException e) {
            // If an IOException is thrown, print the stack trace to help with debugging.
            e.printStackTrace();
            this.GestureImage = null; // Set GestureImage to null to indicate that the image couldn't be loaded if the image file cannot be read
        }
    }

    public String getGestureID() {
        return gestureID;
    }

    public String getGestureImagePath() {
        return gestureImagePath;
    }
}