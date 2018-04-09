import org.junit.Before;
import org.junit.Test;
import vendables.Drink;

import static org.junit.Assert.assertEquals;

public class DrinkTest {

    Drink pepsiMax;

    @Before
    public void before(){
        pepsiMax = new Drink("Pepsi Max",  150, 330);
    }

    @Test
    public void hasName(){
        assertEquals("Pepsi Max", pepsiMax.getName());
    }

    @Test
    public void hasPrice(){
        assertEquals(150, pepsiMax.getPrice(), 0.01);
    }

    @Test
    public void hasVolume(){
        assertEquals(330, pepsiMax.getVolume());
    }
}
