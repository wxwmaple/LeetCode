/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 *
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (41.01%)
 * Likes:    82
 * Dislikes: 0
 * Total Accepted:    6.1K
 * Total Submissions: 14.8K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n' +
  '[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * 设计一个支持以下两种操作的数据结构：
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * 
 * search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。
 * 
 * 示例:
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * 
 * 说明:
 * 
 * 你可以假设所有单词都是由小写字母 a-z 组成的。
 * 
 */

// @lc code=start

class TrieNode{
    public TrieNode[] links;
    public boolean isEnd;
    public TrieNode(){
        links = new TrieNode[26];
    }
    public boolean containsKey(char ch) {
        return links[ch-'a']!=null;
    }
    public TrieNode get(char ch) {
        return links[ch-'a'];
    }
    public void put(char ch, TrieNode node) {
        links[ch-'a'] = node;//这个node必须是地址
    }
    public void setEnd() {
        isEnd = true;
    }
    public boolean isEnd() {
        return isEnd;
    }
}

class WordDictionary {
    public TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        int word_len = word.length();
        for(int i=0;i<word_len;i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                node.put(currentChar,new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd(); 
    }

    boolean dfs(TrieNode root, String word, int index) {
        if (index >= word.length()) {
            return root.isEnd;
        }
        char currentChar = word.charAt(index);
        if (currentChar != '.') {
            if (root.containsKey(currentChar)) {
                return dfs(root.get(currentChar), word, index + 1);
            }
            return false;
        }
        for (TrieNode link : root.links) {
            if (null != link && dfs(link, word, index + 1)) {
                return true;
            }
        }
        return false;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root,word,0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

