package PACKAGE_NAME.src.main.project.classes;

import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.event.ActionEvent;

public class LibraryController {

    @FXML
    private GridPane gridPane;

    @FXML
    public void Spil(ActionEvent event) {
        System.out.println("Spil button clicked");
    }
}

