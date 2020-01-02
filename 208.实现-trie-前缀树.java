/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 *
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/description/
 *
 * algorithms
 * Medium (62.99%)
 * Likes:    172
 * Dislikes: 0
 * Total Accepted:    19.7K
 * Total Submissions: 31.1K
 * Testcase Example:  '["Trie","insert","search","search","startsWith","insert","search"]\n' +
  '[[],["apple"],["apple"],["app"],["app"],["app"],["app"]]'
 *
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 
 * 示例:
 * 
 * Trie trie = new Trie();
 * 
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");   
 * trie.search("app");     // 返回 true
 * 
 * 说明:
 * 
 * 
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * 
 * 
 */

// @lc code=start
class TrieNode {
    //每一个node有26个子节点，一个末位判断符
    public TrieNode[] links;
    public boolean isEnd;

    public TrieNode() {
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

class Trie {
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
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
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        int word_len = word.length();
        for(int i=0;i<word_len;i++){
            char currentChar = word.charAt(i);
            if(!node.containsKey(currentChar)){
                return false;
            }
            else{
                node = node.get(currentChar);
            }
        }
        return node.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int prefix_len = prefix.length();
        for(int i=0;i<prefix_len;i++){
            char currentChar = prefix.charAt(i);
            if(!node.containsKey(currentChar)){
                return false;
            }
            else{
                node = node.get(currentChar);
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

