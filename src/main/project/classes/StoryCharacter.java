package PACKAGE_NAME.src.main.project.classes;
import java.util.List;
import java.util.ArrayList;

public class StoryCharacter {
    private String CharacterName;
    private List<Gesture> characterGesture;
    private List<FacialExpression> characterFacialExpression;
    public Gesture CurrentGesture;
    public FacialExpression CurrentFacialExpression;

    public StoryCharacter(String characterName, String gestureID, String gestureImagePath, String facialExpressionID, String facialExpressionImagePath) {
        this.CharacterName = characterName;
        this.characterGesture = new ArrayList<Gesture>();
        this.characterFacialExpression = new ArrayList<FacialExpression>();

        addGesture(gestureID, gestureImagePath);
        addFacialExpression(facialExpressionID, facialExpressionImagePath);
    }

    public void addGesture(String gestureID, String gestureImagePath) {
        Gesture newGesture = new Gesture(gestureID, gestureImagePath);
        characterGesture.add(newGesture);
    }

    public void addFacialExpression(String facialExpressionID, String facialExpressionImagePath) {
        FacialExpression newFacialExpression = new FacialExpression(facialExpressionID, facialExpressionImagePath);
        characterFacialExpression.add(newFacialExpression);
    }
}
/*
    public void setCurrentGesture(ChosenGesture){
        CurrentGesture = ChosenGesture;
    }

    public void setCurrentFacialExpression(ChosenFacialExpression){
        CurrentFacialExpression = ChosenFacialExpression;
    }
}

 */