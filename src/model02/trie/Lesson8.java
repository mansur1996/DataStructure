package model02.trie;

public class Lesson8 {

    public static void main(String[] args) {
        TrieArray trie = new TrieArray();

        trie.insert("cat");
        trie.insert("car");

        System.out.println(trie.search("cat"));
    }
}
