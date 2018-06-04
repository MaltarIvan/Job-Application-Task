import org.junit.Before;
import org.junit.Test;

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
        int expected1 = 1;
        int expected2 = 2;
    }
}
