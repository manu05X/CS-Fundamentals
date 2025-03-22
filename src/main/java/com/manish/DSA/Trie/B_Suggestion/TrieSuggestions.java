package com.manish.DSA.Trie.B_Suggestion;

import java.util.*;

class TrieNode {
    Map<Character, TrieNode> children;
    List<String> searchWords;

    TrieNode() {
        children = new HashMap<>();
        searchWords = new ArrayList<>();
    }
}

class Trie {
    TrieNode root;

    Trie() {
        this.root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
            if (node.searchWords.size() < 3) {
                node.searchWords.add(word);
            }
        }
    }

    List<List<String>> search(String word) {
        List<List<String>> result = new ArrayList<>();
        TrieNode node = this.root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                for (int i = result.size(); i < word.length(); i++) {
                    result.add(new ArrayList<>());
                }
                return result;
            }
            node = node.children.get(c);
            result.add(node.searchWords);
        }
        return result;
    }
}

public class TrieSuggestions {
    public static List<List<String>> suggestedProducts(List<String> products, String searchWord) {
        Collections.sort(products);
        Trie trie = new Trie();
        for (String product : products) {
            trie.insert(product);
        }
        return trie.search(searchWord);
    }

    public static void main(String[] args) {
        List<String> products = Arrays.asList("bat", "bag", "bassinet", "bread", "cable", "table", "tree", "tarp");
        List<String> searchWords = Arrays.asList("ba", "in", "ca", "t");

        for (int i = 0; i < searchWords.size(); i++) {
            System.out.println((i + 1) + ".\tProducts: " + products);
            System.out.println("\tSearch keyword: '" + searchWords.get(i) + "'");
            List<List<String>> result = suggestedProducts(products, searchWords.get(i));
            System.out.println("\tSuggested Products: " + result);
            System.out.println("-".repeat(100));
        }
    }
}

