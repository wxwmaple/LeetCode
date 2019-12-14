/*
 * @lc app=leetcode.cn id=349 lang=java
 *
 * [349] 两个数组的交集
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays/description/
 *
 * algorithms
 * Easy (67.25%)
 * Likes:    145
 * Dislikes: 0
 * Total Accepted:    42.9K
 * Total Submissions: 63.9K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 示例 1:
 * 
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 
 * 
 * 示例 2:
 * 
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 
 * 说明:
 * 
 * 
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        //集合1、2用来过滤两个数组自身，集合ans用来求交集
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        Set<Integer> setans = new HashSet<Integer>();
        int len_1 = nums1.length;
        int len_2 = nums2.length;
        
        for(int i=0;i<len_1;i++){
            set1.add(nums1[i]);
        }
        for(int i=0;i<len_2;i++){
            set2.add(nums2[i]);
        }
        
        //求交集如下所示
        //求并集直接addAll两次即可
        setans.addAll(set1);
        setans.retainAll(set2);
        
        //集合不能直接转数组，只能用iterator读取
        int[] res = new int[setans.size()];
        Iterator iterator = setans.iterator();
        int k = 0;
        while (iterator.hasNext()) {
            res[k] = (int) iterator.next();
            k++;
        }

        return res;
    }
}
// @lc code=end

