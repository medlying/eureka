import com.simao.common.LeetCode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LeetCodeTest {

    @Test
    public void testConvertFor1() {
        LeetCode leetCode = new LeetCode();
        String str = leetCode.convert("LEETCODEISHIRING", 1);
        assertEquals(str, "LEETCODEISHIRING");
    }

    @Test
    public void testConvertFor2() {
        LeetCode leetCode = new LeetCode();
        String str = leetCode.convert("LEETCODEISHIRING", 2);
        assertEquals(str, "LECDIHRNETOESIIG");
    }

    @Test
    public void testConvertFor3() {
        LeetCode leetCode = new LeetCode();
        String str = leetCode.convert("LEETCODEISHIRING", 3);
        assertEquals(str, "LCIRETOESIIGEDHN");
    }

    @Test
    public void testConvertFor4() {
        LeetCode leetCode = new LeetCode();
        String str = leetCode.convert("LEETCODEISHIRING", 4);
        assertEquals(str, "LDREOEIIECIHNTSG");
    }

    @Test
    public void testConvertZFor1() {
        LeetCode leetCode = new LeetCode();
        String str = leetCode.convertZ("LEETCODEISHIRING", 1);
        assertEquals(str, "LEETCODEISHIRING");
    }

    @Test
    public void testConvertZFor2() {
        LeetCode leetCode = new LeetCode();
        String str = leetCode.convertZ("LEETCODEISHIRING", 2);
        assertEquals(str, "LECDIHRNETOESIIG");
    }

    @Test
    public void testConvertZFor3() {
        LeetCode leetCode = new LeetCode();
        String str = leetCode.convertZ("LEETCODEISHIRING", 3);
        assertEquals(str, "LCIRETOESIIGEDHN");
    }

    @Test
    public void testConvertZFor4() {
        LeetCode leetCode = new LeetCode();
        String str = leetCode.convertZ("LEETCODEISHIRING", 4);
        assertEquals(str, "LDREOEIIECIHNTSG");
    }

    @Test
    public void testReverse() {
        LeetCode leetCode = new LeetCode();
        assertEquals(leetCode.reverse(123), 321);
    }

    @Test
    public void testReverseNegative() {
        LeetCode leetCode = new LeetCode();
        assertEquals(leetCode.reverse(-123), -321);
    }

    @Test
    public void testReverseZeroEnd() {
        LeetCode leetCode = new LeetCode();
        assertEquals(leetCode.reverse(120), 21);
    }

    @Test
    public void testReverseRange() {
        LeetCode leetCode = new LeetCode();
        assertEquals(leetCode.reverse(1534236469), 0);
    }
}
