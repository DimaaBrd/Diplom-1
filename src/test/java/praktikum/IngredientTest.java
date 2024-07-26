package praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final String name;
    private final float price;
    private final IngredientType ingredientType;

    public IngredientTest(String name, float price, IngredientType ingredientType) {
        this.name = name;
        this.price = price;
        this.ingredientType = ingredientType;
    }

    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {"Tomato", 0.5f, IngredientType.SAUCE},
                {"Lettuce", 1.0f, IngredientType.FILLING}
        };
    }

    @Test
    public void ingredientTypeTest() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        assertEquals(price, ingredient.getPrice(), 0.0f);
        assertEquals(name, ingredient.getName());
        assertEquals(ingredientType, ingredient.getType());
    }


}