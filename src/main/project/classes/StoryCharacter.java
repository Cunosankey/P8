package main.project.classes;

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

    public List<Gesture> getCharacterGesture() {
        return characterGesture;
    }

    public void addGesture(String gestureID, String gestureImagePath) {
        System.out.println("Adding gesture with image path: " + gestureImagePath); // Print the image path for debugging
        Gesture newGesture = new Gesture(gestureID, gestureImagePath);
        characterGesture.add(newGesture);
    }

    public void addFacialExpression(String facialExpressionID, String facialExpressionImagePath) {
        FacialExpression newFacialExpression = new FacialExpression(facialExpressionID, facialExpressionImagePath);
        characterFacialExpression.add(newFacialExpression);
    }

    public List<FacialExpression> getCharacterFacialExpression() {
        return characterFacialExpression;
    }
}

