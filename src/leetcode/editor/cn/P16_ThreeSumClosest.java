package leetcode.editor.cn;

//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
//
// Related Topics 数组 双指针 排序 👍 1512 👎 0

import java.util.Arrays;

/**
 * 最接近的三数之和
 *
 * @author lccic
 */
public class P16_ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new P16_ThreeSumClosest().new Solution();
        System.out.println(solution.threeSumClosest(new int[]{1, 1, 1, 0}, 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException();
        }

        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {

            if (nums[i] > target / 3) {
                if (Math.abs(target - nums[i] - nums[i + 1] - nums[i + 2]) < Math.abs(target - ans )) {
                    return nums[i] + nums[i + 1] + nums[i + 2];
                } else {
                    return ans;
                }
            }

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {

                int min = nums[i] + nums[l] + nums[l + 1];
                if (min > target) {
                    if (Math.abs(min - target) < Math.abs(target - ans)) {
                        ans = min;
                        break;
                    }
                }

                int max = nums[i] + nums[r] + nums[r - 1];
                if (max < target) {
                    if (Math.abs(target - max) < Math.abs(target - ans)) {
                        ans = max;
                        break;
                    }
                }

                int sum = nums[i] + nums[l] + nums[r];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                 if (sum < target) {
                    l++;
                    while(l != r && nums[l] == nums[l + 1]) l++;
                } else {
                    r--;
                    while(l != r && nums[r] == nums[r + 1]) r--;
                }
            }

            while(i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}