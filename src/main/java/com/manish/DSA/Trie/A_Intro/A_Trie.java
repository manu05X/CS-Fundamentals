package com.manish.DSA.Trie.A_Intro;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TrieNode{
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode(){
        this.children = new HashMap<>();
        this.isWord = false;
    }
}

class Trie{
    private TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insertWord(String word){
        TrieNode newNode = this.root;
        for(Character c : word.toCharArray()){
            if(!newNode.children.containsKey(c)){
                newNode.children.put(c, new TrieNode());
            }
            newNode = newNode.children.get(c);
        }
        newNode.isWord = true;
    }

    // Search for a word in the Trie
    public boolean searchWord(String word){
        TrieNode currNode = this.root;
        for(Character c : word.toCharArray()){
            if(!currNode.children.containsKey(c)){
                return false;
            }
            currNode = currNode.children.get(c);
        }
        return currNode.isWord;
    }

    // Search for a prefix word in the Trie
    public boolean searchPrefixWord(String word){
        TrieNode currNode = this.root;
        for(Character c : word.toCharArray()){
            if(!currNode.children.containsKey(c)){
                return false;
            }
            currNode = currNode.children.get(c);
        }
        return true;
    }
}


public class A_Trie {
    public static void main(String[] args) {
        List<String> keys = Arrays.asList("the", "a", "there", "answer");
        Trie trie = new Trie();
        int num = 1;

        // Inserting keys
        for (String key : keys) {
            System.out.println(num + ".\tInserting key: '" + key + "'");
            trie.insertWord(key);
            num++;
            System.out.println("-".repeat(100));
        }

        List<String> searchKeys = Arrays.asList("a", "answer", "xyz", "an");

        // Searching keys
        for (String search : searchKeys) {
            System.out.println(num + ".\tSearching key: '" + search + "'");
            boolean res = trie.searchWord(search);
            System.out.println("\tKey found? " + res);
            num++;
            System.out.println("-".repeat(100));
        }

        List<String> searchPrefixes = Arrays.asList("b", "an");

        // Searching prefixes
        for (String prefix : searchPrefixes) {
            System.out.println(num + ".\tSearching prefix: '" + prefix + "'");
            boolean res = trie.searchPrefixWord(prefix);
            System.out.println("\tPrefix found? " + res);
            num++;
            System.out.println("-".repeat(100));
        }

    }
}

/*
javac -d . A_Trie.java
java com.manish.DSA.Trie.A_Intro.A_Trie
1
* */
