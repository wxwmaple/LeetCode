/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start

class TrieNode{
    public TrieNode[] links;
    public boolean isEnd;
    public TrieNode(){
        links = new TrieNode[26];
    }
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public TrieNode get(char ch){
        return links[ch-'a'];
    }
    public void put(char ch,TrieNode node){
        links[ch-'a'] = node;

    }
    public void setEnd(){
        isEnd = true;
    }
    public boolean isEnd(){
        return isEnd;
    }
}

class Trie{
    public TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
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



class Solution {
    public String longestCommonPrefix(String[] strs) {
        String pub_str = "";
        Trie trie = new Trie();
        for(String str:strs){
            trie.insert(str);
        }
    }

    for()
}
// @lc code=end

