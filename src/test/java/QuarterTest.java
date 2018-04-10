import coins.Dime;
import coins.Quarter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuarterTest {

    Quarter quarter;

    @Before
    public void before(){
        quarter = new Quarter();
    }

    @Test
    public void hasCoinValue(){
        assertEquals(25, quarter.getCoinValue());
    }
}
