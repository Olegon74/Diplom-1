import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient ingredientMock;

    @Test
    public void testAddIngredient_and_GetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);

        when(bunMock.getPrice()).thenReturn(100f);
        when(ingredientMock.getPrice()).thenReturn(200f);

        burger.addIngredient(ingredientMock);

        // Проверяем, что цена учитывает булочку и ингредиент
        float expectedPrice = 2 * 100f + 200f; // Цена за две булочки и один ингредиент
        assertEquals(expectedPrice, burger.getPrice(), 0.0);
    }

    @Test
    public void testRemoveIngredient() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock);
        assertFalse(burger.ingredients.isEmpty());

        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void testMoveIngredient() {
        Burger burger = new Burger();
        Ingredient ingredient1 = mock(Ingredient.class);
        Ingredient ingredient2 = mock(Ingredient.class);

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1);
        assertEquals(ingredient1, burger.ingredients.get(1));
        assertEquals(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);

        when(bunMock.getName()).thenReturn("black bun");
        when(ingredientMock.getName()).thenReturn("sour cream");
        when(ingredientMock.getType()).thenReturn(IngredientType.FILLING);

        String receipt = burger.getReceipt();
        assertTrue(receipt.contains("black bun"));
        assertTrue(receipt.contains("sour cream"));
        assertTrue(receipt.contains("Price:"));
    }
}
