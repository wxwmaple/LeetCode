import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();//HashMap更快
        int nums_len = nums.length;
        for(int i=0;i<nums_len;i++){
            int res = target - nums[i];
            if(map.containsKey(res)){//查一次
                return new int[]{i,map.get(res)};
            }
            map.put(nums[i],i);//放一个
        }
    throw new IllegalArgumentException("No two sum solution");
    }
}
// @lc code=end

