import org.junit.Before;
import org.junit.Test;
import vendables.Sweet;

import static org.junit.Assert.assertEquals;

public class SweetsTest {

    Sweet skittles;

    @Before
    public void before(){
        skittles = new Sweet("Skittles", 65);
    }

    @Test
    public void hasName(){
        assertEquals("Skittles", skittles.getName());
    }

    @Test
    public void hasPrice(){
        assertEquals(65, skittles.getPrice(), 0.01);
    }


}
