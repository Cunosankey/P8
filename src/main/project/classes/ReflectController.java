package PACKAGE_NAME.src.main.project.classes;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ReflectController implements Initializable {

    @FXML
    private ImageView facialExpressionImage;

    @FXML
    private ImageView gestureImage;

    private int facialExpressionIndex;
    private int gestureIndex;
    private StoryCharacter storyCharacter;

    public ReflectController(StoryCharacter storyCharacter, int facialExpressionIndex, int gestureIndex) {
        this.storyCharacter = storyCharacter;
        this.facialExpressionIndex = facialExpressionIndex;
        this.gestureIndex = gestureIndex;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<FacialExpression> characterFacialExpressionList = storyCharacter.getCharacterFacialExpression();
        String imagePath = characterFacialExpressionList.get(facialExpressionIndex).getFacialExpressionImagePath();
        Image image = new Image("file:" + imagePath);
        facialExpressionImage.setImage(image);

        List<Gesture> characterGestureList = storyCharacter.getCharacterGesture();
        String gestureImagePath = characterGestureList.get(gestureIndex).getGestureImagePath();
        Image currentGestureImage = new Image("file:" + gestureImagePath);
        gestureImage.setImage(currentGestureImage);
    }
}
