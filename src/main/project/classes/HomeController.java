package main.project.classes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HomeController {

    @FXML
    private Button continueButton;

    @FXML
    private Text titleText;

    Font urbaneBold;

    @FXML
    public void initialize() {
        urbaneBold = Font.loadFont(getClass().getResource("/fonts/Urbane-Bold.ttf").toExternalForm(), 50);
        titleText.setFont(urbaneBold);
        titleText.setText("Hej og\nvelkommen!");
        titleText.setFill(Color.web("#222222"));
        // Load Animation class
        Animations.buttonAnimation(continueButton);
    }

    @FXML
    public void changeScene(ActionEvent event) throws IOException {
        Parent newSceneParent = FXMLLoader.load(getClass().getResource("/scenes/Library.fxml"));
        Scene newScene = new Scene(newSceneParent);
        // This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
    }
}
