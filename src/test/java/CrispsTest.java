import org.junit.Before;
import org.junit.Test;
import vendables.Crisps;

import static org.junit.Assert.assertEquals;

public class CrispsTest {

    Crisps monsterMunch;

    @Before
    public void before(){
        monsterMunch = new Crisps("Monster Munch", 1.00);
    }

    @Test
    public void hasName(){
        assertEquals("Monster Munch", monsterMunch.getName());
    }

    @Test
    public void hasPrice(){
        assertEquals(1.00, monsterMunch.getPrice(), 0.01);
    }

}
