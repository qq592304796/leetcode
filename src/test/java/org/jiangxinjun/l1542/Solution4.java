package org.jiangxinjun.l1542;
//给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。
//
// 「超赞子字符串」需满足满足下述两个条件：
//
//
// 该字符串是 s 的一个非空子字符串
// 进行任意次数的字符交换后，该字符串可以变成一个回文字符串
//
//
//
//
// 示例 1：
//
// 输入：s = "3242415"
//输出：5
//解释："24241" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "24142"
//
//
// 示例 2：
//
// 输入：s = "12345678"
//输出：1
//
//
// 示例 3：
//
// 输入：s = "213123"
//输出：6
//解释："213123" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "231132"
//
//
// 示例 4：
//
// 输入：s = "00"
//输出：2
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10^5
// s 仅由数字组成
//
//
// Related Topics 位运算 哈希表 字符串
// 👍 126 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {

    @SuppressWarnings("DuplicateExpressions")
    public int longestAwesome(String s) {
        int[] numSize = new int[10];
        int maxLength = 0;
        int oddBitNumber = 0;
        for (int i = 0; i < s.length(); i++) {
            int iNumericValue = Character.getNumericValue(s.charAt(i));
            oddBitNumber = oddBitNumber - (numSize[iNumericValue] & 1)
                    + (++numSize[iNumericValue] & 1);
            if (i < 1) {
                continue;
            }
            // 记录当前数字片段的数字长度
            int[] currentNumSize = Arrays.copyOf(numSize, numSize.length);
            int currentOddBitNumber = oddBitNumber;
            for (int j = 0; j < (i - maxLength + 1); j++) {
                if (currentOddBitNumber > 1) {
                    int jNumericValue = Character.getNumericValue(s.charAt(j));
                    currentOddBitNumber = currentOddBitNumber - (currentNumSize[jNumericValue] & 1)
                            + (--currentNumSize[jNumericValue] & 1);
                    continue;
                }
                maxLength = Math.max(maxLength, (i + 1 - j) >> 1 << 1);
            }
        }
        return maxLength + (s.length() > maxLength  ? 1 : 0);
    }

}
//leetcode submit region end(Prohibit modification and deletion)


