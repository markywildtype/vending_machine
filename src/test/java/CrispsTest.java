import org.junit.Before;
import org.junit.Test;
import vendables.Crisps;

import static org.junit.Assert.assertEquals;

public class CrispsTest {

    Crisps monsterMunch;

    @Before
    public void before(){
        monsterMunch = new Crisps("Monster Munch", 100);
    }

    @Test
    public void hasName(){
        assertEquals("Monster Munch", monsterMunch.getName());
    }

    @Test
    public void hasPrice(){
        assertEquals(100, monsterMunch.getPrice(), 0.01);
    }

}
