package praktikum;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {
    @Test
    public void enumTest() {
        assertNotNull(IngredientType.valueOf("SAUCE"));
        assertNotNull(IngredientType.valueOf("FILLING"));
    }
}