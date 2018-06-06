import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by Maltar on 4.6.2018..
 */
public class MainTest {
    private Niz A1;
    private Niz A2;

    @Before
    public void setUp() {
        A1 = new Niz(new int[]{1, 2, 3});
        A2 = new Niz(new int[]{2, 1, 3, 1});
    }

    @Test
    public void mainTest() {
        assertEquals(1, Main.doMagic(A1));
        assertEquals(2, Main.doMagic(A2));
    }
}
