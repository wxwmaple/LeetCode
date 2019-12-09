/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
        char[] array_kh = s.toCharArray();//转化成字符数组
        if(array_kh.length==0)//空数组视为有效
            return true;
        if(array_kh.length%2!=0)//奇数显然无效
            return false;
        for(char kh : array_kh){
            if(kh=='('||kh =='['||kh=='{')
                st.push(kh);//左括号进栈
            else{//右括号
                if(st.empty())//栈里没有可匹配的左括号，无效！这句话不能省略，因为空栈pop会有bug
                    return false;
                if(st.pop()!=map.get(kh))//栈里没有足够的左括号，无效！
					return false;
            }
        }
        if(!st.empty())//若栈内还有左括号，无效！
            return false;
        return true;//其余情况，有效！
    }
}
// @lc code=end

