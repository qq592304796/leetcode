package org.jiangxinjun.l2129;//给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
//
//
// 如果单词的长度为 1 或者 2 ，所有字母变成小写。
// 否则，将单词首字母大写，剩余字母变成小写。
//
//
// 请你返回 大写后 的 title 。
//
//
//
// 示例 1：
//
// 输入：title = "capiTalIze tHe titLe"
//输出："Capitalize The Title"
//解释：
//由于所有单词的长度都至少为 3 ，将每个单词首字母大写，剩余字母变为小写。
//
//
// 示例 2：
//
// 输入：title = "First leTTeR of EACH Word"
//输出："First Letter of Each Word"
//解释：
//单词 "of" 长度为 2 ，所以它保持完全小写。
//其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
//
//
// 示例 3：
//
// 输入：title = "i lOve leetcode"
//输出："i Love Leetcode"
//解释：
//单词 "i" 长度为 1 ，所以它保留小写。
//其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
//
//
//
//
// 提示：
//
//
// 1 <= title.length <= 100
// title 由单个空格隔开的单词组成，且不含有任何前导或后缀空格。
// 每个单词由大写和小写英文字母组成，且都是 非空 的。
//
//
// Related Topics 字符串
// 👍 47 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

class Solution {

    // 暂存每次词组首字母的位置
    int DEFAULT_INDEX = -1;
    int initialsIndex = DEFAULT_INDEX;
    public String capitalizeTitle(String title) {
        StringBuilder sb = new StringBuilder(title);
        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            // 如果是空格，则表示清空首字符信息
            if (c == ' ') {
                // 如果是空格，则表示清空首字符信息，并且首字符位置不为0，将首字符添加到指定位置
                if (initialsIndex != DEFAULT_INDEX) {
                    insert(i-1, sb);
                }
            } else {
                // 如果首字母位置占位符是默认值，并且字符不为空，记录首字符信息
                if (initialsIndex == DEFAULT_INDEX) {
                    initialsIndex = i;
                    if (i == title.length() - 1) {
                        insert(i, sb);
                    }
                    continue;
                }
            }
            if (i == title.length() - 1) {
                insert(i, sb);
            }
            sb.setCharAt(i, Character.toLowerCase(c));
        }
        return sb.toString();
    }

    private void insert(int i, StringBuilder sb) {
        // 判断词组的长度是否超过3
        if (i - initialsIndex >= 2) {
            sb.setCharAt(initialsIndex, Character.toUpperCase(sb.charAt(initialsIndex)));
        } else {
            sb.setCharAt(initialsIndex, Character.toLowerCase(sb.charAt(initialsIndex)));
        }
        // 词组进行分割
        initialsIndex = DEFAULT_INDEX;
    }
}


//leetcode submit region end(Prohibit modification and deletion)
