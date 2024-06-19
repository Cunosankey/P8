package main.project.classes;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FacialExpression {
    public BufferedImage FacialExpressionImage;
    private String facialExpressionImagePath;
    private String facialExpressionID;

    // Constructor for the class
    public FacialExpression(String facialExpressionID, String imagePath) {
        this.facialExpressionID = facialExpressionID; // Call the constructor of the superclass (Gesture) with the gestureID
        this.facialExpressionImagePath = imagePath; // Call the [...]
        try {
            // Try to read the image file from the specified path. This can throw an IOException if the file can't be read for any reason.
            this.FacialExpressionImage = ImageIO.read(getClass().getResource(imagePath));
        } catch (IOException e) {
            // If an IOException is thrown, print the stack trace to help with debugging.
            e.printStackTrace();
            this.FacialExpressionImage = null; // Set GestureImage to null to indicate that the image couldn't be loaded if the image file cannot be read
        }

    }

    public String getFacialExpressionImagePath() {
        return facialExpressionImagePath;
    }

    public String getFacialExpressionID() {
        return facialExpressionID;
    }
}
