package PACKAGE_NAME.src.main.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import PACKAGE_NAME.src.main.project.classes.StoryCharacter;


import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("scenes/Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 810);
        scene.getStylesheets().add(App.class.getResource("styles.css").toExternalForm());
        stage.setTitle("Hello Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
        StoryCharacter StoryCharacter = new StoryCharacter("Character1", "Gesture1", "src/main/images/body.png", "FacialExpression1", "src/main/images/Face.png");

        //add more gestures and facial expressions
        StoryCharacter.addGesture("Gesture2", "src/main/images/body2.png");
        StoryCharacter.addFacialExpression("FacialExpression2", "src/main/images/Face2.png");
        //Here, it is possible to add more facial expressions and gestures to the list in the character
    }
}