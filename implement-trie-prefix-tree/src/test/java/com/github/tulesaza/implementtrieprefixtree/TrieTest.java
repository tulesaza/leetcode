package com.github.tulesaza.implementtrieprefixtree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TrieTest {

    @Test
    void insertAndSearch() {
        var prefixTree = new Trie();
        prefixTree.insert("azamat");
        prefixTree.insert("azamatt");
        assertTrue(prefixTree.search("azamat"));
        assertFalse(prefixTree.search("azamata"));
        assertTrue(prefixTree.search("azamatt"));
        assertFalse(prefixTree.search("aazamat"));
    }

    @Test
    void insertAndStartsWith() {
        var prefixTree = new Trie();
        prefixTree.insert("azamat");
        prefixTree.insert("anna");
        prefixTree.insert("zaman");
        assertFalse(prefixTree.startsWith("azm"));
        assertTrue(prefixTree.startsWith("a"));
        assertTrue(prefixTree.startsWith("az"));
        assertTrue(prefixTree.startsWith("ann"));
        assertTrue(prefixTree.startsWith("zama"));
        assertFalse(prefixTree.startsWith("zamn"));
    }
}