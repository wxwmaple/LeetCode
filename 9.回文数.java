/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        if(x<10)
            return true;
        if(x%10 == 0)
            return false;
        int tempx=x;
        int rev=0;
        while(tempx > 0){
            rev = 10*rev + tempx%10;
            tempx /= 10; 
        }
        return rev==x;
    }
}
// @lc code=end

