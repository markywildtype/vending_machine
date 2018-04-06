import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CrispsTest {

    Crisps monsterMunch;

    @Before
    public void before(){
        monsterMunch = new Crisps("Monster Munch");
    }

    @Test
    public void hasName(){
        assertEquals("Monster Munch", monsterMunch.getName());
    }

}
