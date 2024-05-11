package org.jiangxinjun.l2864;//给你一个 二进制 字符串 s ，其中至少包含一个 '1' 。
//
// 你必须按某种方式 重新排列 字符串中的位，使得到的二进制数字是可以由该组合生成的 最大二进制奇数 。
//
// 以字符串形式，表示并返回可以由给定组合生成的最大二进制奇数。
//
// 注意 返回的结果字符串 可以 含前导零。
//
//
//
// 示例 1：
//
//
//输入：s = "010"
//输出："001"
//解释：因为字符串 s 中仅有一个 '1' ，其必须出现在最后一位上。所以答案是 "001" 。
//
//
// 示例 2：
//
//
//输入：s = "0101"
//输出："1001"
//解释：其中一个 '1' 必须出现在最后一位上。而由剩下的数字可以生产的最大数字是 "100" 。所以答案是 "1001" 。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 仅由 '0' 和 '1' 组成
// s 中至少包含一个 '1'
//
//
// Related Topics 贪心 数学 字符串
// 👍 9 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Solution {
    public String maximumOddBinaryNumber(String s) {
        // 把字符串拆分成char数组
        char[] charArray = s.toCharArray();
        // 至少要保证第1位有一个1
        // 循环char数组，如果为1逐级从最高位开始放，如果为0逐级从第2位开始放
        int highestPosition = charArray.length - 1;
        int lowestPosition = charArray.length - 2;
        char[] newCharArray = new char[charArray.length];
        for (char c : charArray) {
            if (c == '1') {
                // 把第1个1放到第一位
                if (highestPosition == (charArray.length - 1)) {
                    newCharArray[newCharArray.length - 1] = c;
                    // 设置最高位，char数组长度-1
                    highestPosition = 0;
                } else {
                    // 按位置放到最高位
                    newCharArray[highestPosition] = c;
                    highestPosition++;
                }
            } else {
                newCharArray[lowestPosition] = c;
                lowestPosition--;
            }
        }
        return new String(newCharArray);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
