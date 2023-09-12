package leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 2910 👎 0

/**
 * 最长公共前缀
 *
 * @author lccic
 */
public class P14_LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new P14_LongestCommonPrefix().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        String firstStr = strs[0];
        int minLen = Integer.MAX_VALUE;

        for (String str : strs) {
            int i = 0;
            while (i < firstStr.length() && i < str.length()) {
                if (firstStr.charAt(i) != str.charAt(i)) {
                    break;
                }
                i++;
            }
            minLen = Math.min(minLen, i);
            if (minLen == 0) {
                return "";
            }
        }

        return firstStr.substring(0, minLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}