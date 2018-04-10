import coins.Dollar;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DollarTest {

    Dollar dollar;

    @Before
    public void before(){
        dollar = new Dollar();
    }

    @Test
    public void hasCoinValue(){
        assertEquals(100, dollar.getCoinValue());
    }
}
