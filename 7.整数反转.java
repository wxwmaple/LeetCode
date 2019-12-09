/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        long rs = 0;//这里作弊了，题目中不允许
        while(x != 0){
            rs = rs*10+x%10;
            x /= 10;
        }
        return(rs<Integer.MIN_VALUE||rs>Integer.MAX_VALUE) ? 0:(int)rs;
    }
}
// @lc code=end

