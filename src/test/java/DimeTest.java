import coins.Dime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DimeTest {

    Dime dime;

    @Before
    public void before(){
        dime = new Dime();
    }

    @Test
    public void hasCoinValue(){
        assertEquals(10, dime.getCoinValue());
    }
}
