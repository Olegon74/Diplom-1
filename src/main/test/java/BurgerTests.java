import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTests {

    @Mock
    private Bun bunMock;
    @Mock
    private Ingredient ingredientMock;
    @Mock
    private Ingredient ingredientMock2;
    @Mock
    private Ingredient ingredientMock3;

    @Test
    public void testAddIngredient() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        when(bunMock.getPrice()).thenReturn(100f);
        burger.addIngredient(ingredientMock);
        assertTrue(burger.ingredients.contains(ingredientMock));

    }

    @Test
    public void testGetPrice() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        when(bunMock.getPrice()).thenReturn(100f);
        when(ingredientMock.getPrice()).thenReturn(200f);
        burger.addIngredient(ingredientMock);
        float expectedPrice = 2 * 100f + 200f;
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
        burger.setBuns(bunMock);

        burger.addIngredient(ingredientMock);// Добавление мок-ингредиентов в burger
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);

        assertEquals(ingredientMock, burger.ingredients.get(0)); // Проверяем начальный порядок
        assertEquals(ingredientMock2, burger.ingredients.get(1));
        assertEquals(ingredientMock3, burger.ingredients.get(2));

        burger.moveIngredient(0, 2);// Выполнение перемещения

        assertEquals(ingredientMock2, burger.ingredients.get(0));
        assertEquals(ingredientMock3, burger.ingredients.get(1));
        assertEquals(ingredientMock, burger.ingredients.get(2));


    }

    @Test
    public void testGetReceipt() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);

        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(ingredientMock.getName()).thenReturn("sour cream");
        when(ingredientMock.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock.getPrice()).thenReturn(200f);

        when(ingredientMock2.getName()).thenReturn("cutlet");
        when(ingredientMock2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock2.getPrice()).thenReturn(100f);

        when(ingredientMock3.getName()).thenReturn("dinosaur");
        when(ingredientMock3.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock3.getPrice()).thenReturn(200f);

        String actualReceipt = burger.getReceipt();
        String expectedReceipt = String.format(
                "(==== black bun ====)%n" +
                        "= sauce sour cream =%n" +
                        "= filling cutlet =%n" +
                        "= filling dinosaur =%n" +
                        "(==== black bun ====)%n" +
                        "%nPrice: 700,000000%n");

        assertEquals(expectedReceipt, actualReceipt);

    }
    @Test
    public void testSetBuns() {
        Burger burger = new Burger();
        assertNull(burger.bun); // Проверяем, что изначально булочки не установлены

        burger.setBuns(bunMock);
        assertSame(bunMock, burger.bun); // Проверяем, что переданная булочка корректно установлена

        burger.setBuns(null);
        assertNull(burger.bun);
    }

}
