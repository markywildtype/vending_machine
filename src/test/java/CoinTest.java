import coins.Coin;
import coins.CoinValue;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinTest {

    Coin coin;

    @Before
    public void before(){
        coin = new Coin(CoinValue.NICKEL);
    }

    @Test
    public void hasCoinValue(){
        assertEquals(CoinValue.NICKEL, coin.getValue());
    }

    @Test
    public void hasNumericalValue(){
        assertEquals(5, coin.getValue().numericalValue());
    }
}
