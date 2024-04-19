package PACKAGE_NAME.src.main.project.classes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FacialExpressionTest {
    @Test
    void testCreateFacialExpression() {
        FacialExpression FacialExpression1 = new FacialExpression ("testFacialExpression", "src/main/images/bab.jpg");
        assertEquals("testFacialExpression", FacialExpression1.FacialExpressionID);
        assertNotNull(FacialExpression1.FacialExpressionImage);
    }
}