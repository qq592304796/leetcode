package org.jiangxinjun.l171;
//给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
//
// 例如：
//
//
//A -> 1
//B -> 2
//C -> 3
//...
//Z -> 26
//AA -> 27
//AB -> 28
//...
//
//
//
// 示例 1:
//
//
//输入: columnTitle = "A"
//输出: 1
//
//
// 示例 2:
//
//
//输入: columnTitle = "AB"
//输出: 28
//
//
// 示例 3:
//
//
//输入: columnTitle = "ZY"
//输出: 701
//
//
//
// 提示：
//
//
// 1 <= columnTitle.length <= 7
// columnTitle 仅由大写英文组成
// columnTitle 在范围 ["A", "FXSHRXW"] 内
//
//
// Related Topics 数学 字符串
// 👍 409 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int titleToNumber(String columnTitle) {
//        int result = 0;
//        for (int i = 0; i < columnTitle.length(); i++) {
//            result = result * 26 + (columnTitle.charAt(i) - 'A' + 1);
//        }
//        return result;

        int result = (columnTitle.charAt(columnTitle.length() - 1) - 'A' + 1);
        for (int i = 1; i < columnTitle.length(); i++) {
            result = (int) (result + Math.pow(26, i) * (columnTitle.charAt(columnTitle.length() - 1 - i) - 'A' + 1));
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

