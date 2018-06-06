import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Maltar on 4.6.2018..
 */
public class NizTest {
    private Niz niz1;
    private Niz niz2;

    @Before
    public void setUp() {
        niz1 = new Niz(new int[]{1, 2, 3});
        niz2 = new Niz(new int[]{2, 1, 3, 1});
    }

    @Test
    public void prefiksSufiksSuma() {
        assertEquals(7, niz1.prefiksSuma(1) + niz1.sufiksSuma(1), 0.000);
        assertEquals(8, niz1.prefiksSuma(2) + niz1.sufiksSuma(2), 0.000);
        assertEquals(9, niz1.prefiksSuma(3) + niz1.sufiksSuma(3), 0.000);

        assertEquals(9, niz2.prefiksSuma(1) + niz2.sufiksSuma(1), 0.000);
        assertEquals(8, niz2.prefiksSuma(2) + niz2.sufiksSuma(2), 0.000);
        assertEquals(10, niz2.prefiksSuma(3) + niz2.sufiksSuma(3), 0.000);
        assertEquals(8, niz2.prefiksSuma(4) + niz2.sufiksSuma(4), 0.000);
    }
}
