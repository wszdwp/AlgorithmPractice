import com.codingpan.leetcode.todo.LC739DailyTemperatures;
import org.junit.Assert;
import org.junit.Test;

public class LC739DailyTemperaturesTest {
    @Test public void testDailyTemperatures() {
        int[] testTemperatures1 = {73,74,75,71,69,72,76,73};
        int[] expected = {1,1,4,2,1,1,0,0};
        LC739DailyTemperatures dut = new LC739DailyTemperatures();
        Assert.assertArrayEquals(expected, dut.dailyTemperatures(testTemperatures1));
    }
}
