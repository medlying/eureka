package com.simao.common;

import java.util.Objects;

public class LeetCode {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        int step = 2 * numRows - 2, length = s.length();
        String result = "";
        for (int i = 0; i < numRows; i++) {
            int index = i;
            do {
                if (index - 2 * i < length) {
                    if (i > 0 && i < numRows - 1 && index != i) {
                        result += s.charAt(index - 2 * i);
                    }
                    if (index < length)
                        result += s.charAt(index);
                }
                index += step;
            } while (index < length + step);
        }
        return result;
    }

    public String convertZ(String s, int numRows) {
        /*
         * 找规律:当前的数加上后面一个数一定是delt的倍数
         */
        if (numRows == 1) return s;
        String ans = "";
        int delt = (numRows - 1) * 2, len = s.length();
        for (int i = 0; i < numRows; ++i) {
            for (int j = i; j < len; ) {
                ans += s.charAt(j);
                j = (2 * j / delt + 1) * delt - j;  // 找到比当前数大的下一个可以整除delt的数
            }
        }
        return ans;
    }

    public int reverse(int x) {
        String str = String.valueOf(x);
        StringBuilder result = new StringBuilder();
        int res = 0;
        if (Objects.equals(String.valueOf(str.charAt(0)), "-")) {
            result.append("-");
        }
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!Objects.equals(str.charAt(i), "0") && !Objects.equals(String.valueOf(str.charAt(i)), "-")) {
                result.append(str.charAt(i));
            }
        }
        try {
            res = Integer.valueOf(result.toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 10. 正则表达式匹配
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        return false;
    }
}
