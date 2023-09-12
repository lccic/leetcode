package leetcode.editor.cn;

//给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != 
//k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请 
//
// 你返回所有和为 0 且不重复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
//解释：
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
//不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
//注意，输出的顺序和三元组的顺序并不重要。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,1]
//输出：[]
//解释：唯一可能的三元组和不为 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,0,0]
//输出：[[0,0,0]]
//解释：唯一可能的三元组和为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 双指针 排序 👍 6348 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 * @author lccic
 */
public class P15_ThreeSum{
    public static void main(String[] args) {
        Solution solution = new P15_ThreeSum().new Solution();
        
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            lists.addAll(twoSum(nums, i + 1, -nums[i], nums[i]));
        }

        return lists;
    }

    private List<List<Integer>> twoSum(int[] nums, int l, int target, int source) {

        List<List<Integer>> lists = new ArrayList<>();
        int r = nums.length - 1;
        int startIndex = l;

        while (l < r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else if (nums[l] + nums[r] < target) {
                l++;
            } else {
                if (l != startIndex && nums[l] == nums[l - 1]) {
                    l++;
                    continue;
                }
                List<Integer> list = new ArrayList<>();
                list.add(source);
                list.add(nums[l]);
                list.add(nums[r]);
                lists.add(list);
                l++;
            }
        }

        return lists;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}