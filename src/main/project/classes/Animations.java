package main.project.classes;
import javafx.animation.ScaleTransition;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class Animations {

        public static void buttonAnimation(Button button) {
            // Create a scale transition
            ScaleTransition st = new ScaleTransition(Duration.millis(100), button);
            st.setByX(0.15);  // scale factor for x-axis
            st.setByY(0.15);  // scale factor for y-axis
            st.setCycleCount(2);  // number of cycles
            st.setAutoReverse(true);  // reverse the animation

            // Set the mouse pressed event
            button.setOnMousePressed(event -> st.playFromStart());
        }

}
