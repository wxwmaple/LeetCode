/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */

// @lc code=start
//import java.util.*;

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i=1;i<s.length();i++){
            int nowNum = getValue(s.charAt(i));
            if(nowNum<=preNum){
                sum += preNum;
            }
            else{//左小右大就做减法
                sum -= preNum;
            }
            preNum = nowNum;//最后一位数不要遗漏
        }
        sum += preNum;
        return sum;
    }
    
    public int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}


// @lc code=end

