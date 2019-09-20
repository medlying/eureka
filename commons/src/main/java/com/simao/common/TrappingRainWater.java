package com.simao.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @author bosong
 * @date 2019-06-26
 * @descrption :
 * step1: 找到不重复积水并且能积水的两个位置
 * step2: 计算step1得到两个位置间的积水数
 * 优化：step1需要优化，最好能将step1和step2合并计算
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < height.length - 2;) {
            if (height[i] == 0) {
                i++;
                continue;
            }
            Map<String, Object> pair = calculateSinkEndIndex(height, i);
            if (!pair.isEmpty() && (Boolean) pair.get("count")) {
                count += calculateSinkCount(height, i, (int)pair.get("index"));
            }
            if (!pair.isEmpty()) {
                i = (int) pair.get("index");
            } else {
                i++;
            }
        }
        return count;
    }

    /**
     * 返回map中的count表示是否需要计算积水数， index表示计算积水数的末尾的下标，map为空表示没有可以计算积水数的位置
     */
    private Map<String, Object> calculateSinkEndIndex(int[] height, int start) {
        Map<String, Object> pair = new HashMap<>();
        if (height[start + 1] >= height[start]) {
            for (int i = start + 1; i < height.length - 1; i++) {
                if (height[i + 1] < height[i]) {
                    break;
                }
                pair.put("count", false);
                pair.put("index", i);
            }
        } else {
            for (int i = start + 2; i < height.length; i++) {
                boolean sink = true;
                boolean over = false;
                for (int j = start + 1; j < i; j++) {
                    if (height[j] >= height[start] || height[j] >= height[i]) {
                        sink = false;
                        break;
                    } else {
                        sink = true;
                        if (height[j] >= height[start]) {
                            over = true;
                        }
                    }
                }
                if (sink) {
                    pair.put("count", true);
                    pair.put("index", i);
                }
                if (over) {
                    break;
                }
            }
        }
        return pair;
    }

    private int calculateSinkCount(int[] height, int start, int end) {
        int count = 0;
        int min = Math.min(height[start], height[end]);
        for (int i = start + 1; i < end; i++) {
            count += (min - height[i]);
        }
        return count;
    }
}
