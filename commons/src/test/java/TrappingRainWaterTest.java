import com.simao.common.TrappingRainWater;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author bosong
 * @date 2019-06-28
 */

public class TrappingRainWaterTest {

    @Test
    public void should_success_trap_water_1() {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        assertEquals(trappingRainWater.trap(arr), 6);
    }

    @Test
    public void should_success_trap_water_2() {
        int[] arr = {1, 7, 8};
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        assertEquals(trappingRainWater.trap(arr), 0);
    }
}
