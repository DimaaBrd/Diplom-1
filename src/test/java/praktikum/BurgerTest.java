package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient1;
    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        burger.setBuns(bun);
        assertEquals(bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0); // Убедитесь, что удаляемый индекс правильный
        assertEquals(1, burger.ingredients.size());
        assertEquals(ingredient2, burger.ingredients.get(0)); // Проверка правильного элемента
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(2.0F);
        when(ingredient1.getPrice()).thenReturn(1.5F);
        when(ingredient2.getPrice()).thenReturn(1.0F);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float expectedPrice = 2.0F * 2 + 1.5F + 1.0F;
        assertEquals(expectedPrice, burger.getPrice(), 0.0F);
    }

    @Test
    public void getReceiptTest() {
        when(bun.getName()).thenReturn("Sesame Bun");
        when(bun.getPrice()).thenReturn(2.0F);
        when(ingredient1.getName()).thenReturn("Lettuce");
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient1.getPrice()).thenReturn(0.5F);
        when(ingredient2.getName()).thenReturn("Ketchup");
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getPrice()).thenReturn(0.7F);

        // Устанавливаем булочку и добавляем ингредиенты
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Формируем ожидаемый чек
        String expectedReceipt = "(==== Sesame Bun ====)\n" +
                "= filling Lettuce =\n" +
                "= sauce Ketchup =\n" +
                "(==== Sesame Bun ====)\n" +
                "\nPrice: 5,200000\n";

        // Проверяем, что метод getReceipt() возвращает ожидаемый чек
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
