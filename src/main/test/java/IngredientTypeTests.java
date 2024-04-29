import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTests {

    private  final IngredientType type;

    private final String name;

    private final float price;

    @Mock
    private Ingredient ingredient;

    public IngredientTypeTests(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {IngredientType.SAUCE, "hot sauce", 100},
                {IngredientType.SAUCE, "sour cream", 200},
                {IngredientType.SAUCE, "chili sauce", 300},
                {IngredientType.FILLING, "cutlet", 100},
                {IngredientType.FILLING, "dinosaur", 200},
                {IngredientType.FILLING, "sausage", 300},
        });
    }

    @Test
    public void testIngredientCreation() {
        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals("Тип должен соответствовать", type, ingredient.getType());
        assertEquals("Название должно соответствовать", name, ingredient.getName());
        assertEquals("Цена должна соответствовать", price, ingredient.getPrice(), 0.01);
    }

}


