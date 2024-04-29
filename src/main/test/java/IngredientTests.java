import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class IngredientTests {

    @Test
    public void testIngredient() {

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "chili sauce", 300);

     Assert.assertEquals("Должен быть SAUCE", IngredientType.SAUCE, ingredient.getType());
     Assert.assertEquals("Название должно быть chili sauce", "chili sauce", ingredient.getName());
     Assert.assertEquals("Цена должна быть 300", 300, ingredient.getPrice(), 0.001);

     }
   }


