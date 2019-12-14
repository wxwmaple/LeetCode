/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 *
 * https://leetcode-cn.com/problems/valid-anagram/description/
 *
 * algorithms
 * Easy (57.26%)
 * Likes:    134
 * Dislikes: 0
 * Total Accepted:    61.3K
 * Total Submissions: 107K
 * Testcase Example:  '"anagram"\n"nagaram"'
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 
 * 示例 1:
 * 
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 
 * 
 * 示例 2:
 * 
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * 
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * 
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        //转化为CharArray的好处是可以使用sort函数
        char[] char_s = s.toCharArray();
        char[] char_t = t.toCharArray();
        Arrays.sort(char_s);
        Arrays.sort(char_t);

        if(Arrays.equals(char_s,char_t))
            return true;
        return false;
    }
}
// @lc code=end

