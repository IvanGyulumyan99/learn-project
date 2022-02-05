import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleTest {

    @Test
    public void simpleTest() {
        Assert.assertTrue(false, "Test failed");
    }
}
