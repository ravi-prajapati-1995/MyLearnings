package com.ravi.learnings.dsa.tries;

public class _001First {
    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("test");
        obj.insert("test");
        System.out.println(obj);
        boolean param_2 = obj.search("babbb");
        System.out.println("is word exists: "+param_2);
        boolean param_3 = obj.startsWith("app");
        System.out.println("is start with: "+param_3);
    }


}
