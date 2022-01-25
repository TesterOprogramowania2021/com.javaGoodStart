import org.testng.Assert;
import org.testng.annotations.Test;

public class Calculator {

    public int add(int a, int b) {
        int result = a + b;
        return result;
    }
    @Test
    public void asserions(){

        int result1 = add(2,2);
        int equals1 = 4;
        int equals2 = 10;
        Assert.assertTrue(result1 == equals1);
        Assert.assertFalse(result1 == equals2);
        Assert.assertEquals(result1,equals1);
    }

}