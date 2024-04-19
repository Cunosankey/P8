package PACKAGE_NAME.src.main.project.classes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GestureTest {
    @Test
    void testCreateGesture() {
        Gesture gesture1 = new Gesture ("testGesture", "src/main/images/bab.jpg");
        assertEquals("testGesture", gesture1.GestureID);
        assertNotNull(gesture1.GestureImage);
    }
}
