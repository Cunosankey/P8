package PACKAGE_NAME.src.main.project.classes;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class TaskController {
    @FXML
    private TextFlow taskDescription;

    public void displayTask() {
        Text description = new Text("Task description");
        taskDescription.getChildren().add(description);
    }
}
