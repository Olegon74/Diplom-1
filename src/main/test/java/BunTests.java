import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BunTests {
    @Test
    public void testGetName() {
        Bun bun = new Bun("black bun", 100f);

        assertEquals("Название должно быть, black bun ", "black bun",  bun.getName());

    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun("black bun", 100f);

        assertEquals("Цена должна быть, 100 ", 100f,  bun.getPrice(), 0.001);

    }
}

