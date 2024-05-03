import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/scenes/Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1080, 810);
        scene.getStylesheets().add(App.class.getResource("/styles.css").toExternalForm());
        stage.setTitle("Hello Hello!");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {

        launch();
    }
}