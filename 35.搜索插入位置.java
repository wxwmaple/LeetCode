/*
 * @lc app=leetcode.cn id=35 lang=java
 *
 * [35] 搜索插入位置
 */

// @lc code=start
class Solution {
    public int searchInsert(int[] nums, int target) {
        int pre=0;
        int end=nums.length-1;
        if(target<nums[pre])//提高速度
            return 0;
        if(target>nums[end])//提高速度
            return nums.length;
        while(pre<=end){//pre=end的时候也要走一次循环，检查最后一个数
            int mid = (end-pre)/2+pre;//不写(end+pre)/2，防止溢出
            if(nums[mid]<target){
                pre=mid+1;
            }
            else if(nums[mid]>target){
                end=mid-1;
            }
            else{
                return mid;
            }
        }
        return pre;//走出while循环的pre=end，随便return哪个都可以
    }
}
// @lc code=end

