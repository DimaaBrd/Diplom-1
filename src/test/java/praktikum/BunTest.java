package praktikum;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String name, float price, String expectedName, float expectedPrice) {
        this.name = name;
        this.price = price;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"sesame bun", 1.25F, "sesame bun", 1.25F},
                {"buckwheat bun", 2.50F, "buckwheat bun", 2.50F},
                {"wholewheat bun", 1.99F, "wholewheat bun", 1.99F}
        };
    }

    @Test
    public void bunTest(){
        Bun bun = new Bun(name, price);
        assertEquals("Не устанавливается название булки", expectedName, bun.getName());
        assertEquals("Не устанавливается цена булки", expectedPrice, bun.getPrice(), 0.0f);
    }






}
