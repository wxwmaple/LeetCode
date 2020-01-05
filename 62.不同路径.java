import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=62 lang=java
 *
 * [62] 不同路径
 *
 * https://leetcode-cn.com/problems/unique-paths/description/
 *
 * algorithms
 * Medium (57.74%)
 * Likes:    383
 * Dislikes: 0
 * Total Accepted:    61.1K
 * Total Submissions: 105.2K
 * Testcase Example:  '3\n2'
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 
 * 问总共有多少条不同的路径？
 * 
 * 
 * 
 * 例如，上图是一个7 x 3 的网格。有多少可能的路径？
 * 
 * 说明：m 和 n 的值均不超过 100。
 * 
 * 示例 1:
 * 
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 
 * 
 * 示例 2:
 * 
 * 输入: m = 7, n = 3
 * 输出: 28
 * 
 */

// @lc code=start
class Solution {
    static Map<String,Integer> map= new HashMap<String, Integer>();
    private static int comb(int m,int n){
            String key= m+","+n;
            if(n==0)
                return 1;
            if (n==1) 
                return m;
            if(n>m/2)
                return comb(m,m-n);
            if(n>1){
                if(!map.containsKey(key))
                    map.put(key, comb(m-1,n-1)+comb(m-1,n));
                return map.get(key);
            }
            return -1;
        }
    public int uniquePaths(int m, int n) {
        return comb(m+n-2,n-1);
    }
}
// @lc code=end

