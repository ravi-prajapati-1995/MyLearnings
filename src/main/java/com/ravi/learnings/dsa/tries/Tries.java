package com.ravi.learnings.dsa.tries;

import java.util.Arrays;

class Trie {
    private final Trie[] links;
    private boolean flag;
    Trie() {
        links = new Trie[26];
        flag = false;
    }

     boolean exists(char ch) {
        return links[ch - 'a'] != null;
    }

     void put(char ch, Trie trie) {
        links[ch - 'a'] = trie;
    }

    Trie get(char ch) {
        return links[ch - 'a'];
    }

    public void setFlag() {
        flag = true;
    }


    /*
    * While insert 1st we check if the character exists or not
    * If the node already exist then move to next char
    * If not create new Node and put at that place
    * Move the cursor to next node
    * Repeat this for all chars
    * */
    void insert(String word) {
        Trie root = this;
        final var charArray = word.toCharArray();
        for (final char ch : charArray) {

            if (!root.exists(ch)) {
                root.put(ch, new Trie());
            }

            root = root.get(ch);
        }

        root.setFlag();
    }

    boolean search(String word) {
        Trie root = this;
        for(char ch: word.toCharArray()) {
            if(!root.exists(ch)) {
                return false;
            }

            root = root.get(ch);
        }

        return root.flag;
    }

    boolean startsWith(String prefix) {
        Trie root = this;
        for(char ch: prefix.toCharArray()) {
            if(!root.exists(ch)) {
                return false;
            }

            root = root.get(ch);
        }

        return true;
    }

    @Override
    public String toString() {
        return "Trie{" +
                "tries=" + Arrays.toString(links) +
                ", flag=" + flag +
                '}';
    }
}