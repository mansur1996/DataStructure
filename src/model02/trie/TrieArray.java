package model02.trie;

public class TrieArray {

    public class Node{
        private char value;
        private boolean isWord;
        private Node[] children;

        public Node(char value) {
            this.value = value;
            this.children = new Node[26];
            this.isWord = false;
        }
    }

    Node root;

    public TrieArray() {
        root = new Node('\0');
    }

    public void insert(String word){
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (current.children[index] == null)
                current.children[index] = new Node(c);

            current = current.children[index];
        }
        current.isWord = true;
    }

    public boolean search(String word){
        Node current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';

            if (current.children[index] == null) return false;
            current = current.children[index];
        }
        return current.isWord;
    }

    public boolean startWith(String prefix){
        Node current = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';

            if (current.children[index] == null) return false;
            current = current.children[index];
        }
        return true;
    }

    public void remove(String word){

    }

    public void print(){
        print(root);
    }

    private void print(Node root){
        if (root != null){
            System.out.println(root.value);
            for(var child : root.children){
                print(child);
            }
        }
    }
}
