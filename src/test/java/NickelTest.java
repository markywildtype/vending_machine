import coins.Nickel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NickelTest {

    Nickel nickel;

    @Before
    public void before(){
        nickel = new Nickel();
    }

    @Test
    public void hasCoinValue(){
        assertEquals(5, nickel.getCoinValue());
    }
}
