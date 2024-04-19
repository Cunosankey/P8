package PACKAGE_NAME.src.main.project.classes;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class FacialExpression {
    public String FacialExpressionID;
    public BufferedImage FacialExpressionImage;

    // Constructor for the class
    public FacialExpression(String facialExpressionID, String imagePath) {
        this.FacialExpressionID = facialExpressionID;
        try {
            // Try to read the image file from the specified path. This can throw an IOException if the file can't be read for any reason.
            this.FacialExpressionImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            // If an IOException is thrown, print the stack trace to help with debugging.
            e.printStackTrace();
            this.FacialExpressionImage = null; // Set GestureImage to null to indicate that the image couldn't be loaded if the image file cannot be read
        }

    }

}
