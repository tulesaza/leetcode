package com.github.tulesaza.implementtrieprefixtree;


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class Trie {

    private final Trie[] alphabet = new Trie[26];
    private boolean terminator;

    public Trie() {
    }


    public void insert(String word) {
        Trie currentNode = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (currentNode.alphabet[index] == null) {
                currentNode.alphabet[index] = new Trie();
            }
            currentNode = currentNode.alphabet[index];
        }
        currentNode.terminator = true;

    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.terminator;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie current = this;
        for (char c : prefix.toCharArray()) {
            int inx = c - 'a';
            if (current.alphabet[inx] == null) {
                return null;
            }
            current = current.alphabet[inx];
        }
        return current;
    }
}


