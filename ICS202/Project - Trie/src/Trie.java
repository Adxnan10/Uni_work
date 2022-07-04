//import java.util.ArrayList;

import java.util.ArrayList;

public class Trie {
    /*
        * (a) contains(String s) [return type boolean] = true if the word ‘s’ is contained in the trie.
        * (b) isPrefix(String p) [return type boolean] = true if ‘p’ is a prefix of any word in the trie.
        * (c) insert(String s) [return type void] = inserts the word ‘s’ in the trie.
        * (d) delete(String s) [return type void] = deletes ‘s’ from the trie.
        * (e) isEmpty() [return type boolean]
        * (f) clear() [return type void]
        * (g) constructors, accessors, mutators = as needed
        * (h) allWordsPrefix(String p) [return type String[]] = this method returns all words whose prefix is ‘p’.
        * (i) size() [return type int] = returns the number of nodes in the trie.

    */
    private TrieNode root = new TrieNode();

    /* Methods to get General info about the trie */
    public boolean isEmpty() {
        return isEmpty(root);
    }
    protected  boolean isEmpty(TrieNode node) {
        ArrayList<String> WordsInTree = new ArrayList<>();
        getAllWords(node, "", WordsInTree);
        if (WordsInTree.size() > 0)
            return false;
        else
            return true;
    }
    public int size() {
        int trieSize = size(root);
        return trieSize == 0? trieSize: trieSize - 1; // -1 because root will be counted as well, when it should not.
    }
    protected int size(TrieNode node) {
        int count = 1;
        int j = 0;
        boolean leaf = false;
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                int counter = size(node.children[i]);
                if (counter !=0 ) {
                    count += counter;
                }
            } else {
                j++; // This is just to check if node is a leaf or not (node has 26 null children => Leaf)
            }
        }
        if (j == 26)
            leaf = true;
        // Base Cases
        if (!leaf)
            return count == 1 && !node.getEnd()? 0: count; // if the node is not a leaf but is a word ending.
        return node.getEnd()? 1: 0; // this when a leaf node is reached and it is not a word ending, so do not count it.
    }
    public boolean contains(String s) {
        TrieNode temp = root;
        for (int i = 0, n = s.length(); i < n; i++) {
            char letter = s.charAt(i);
            if (!(letter >= 65 && letter <= 90)) return false;
            int pos = letter - 'A'; // getting the child's correct position
            if (temp.children[pos] == null)
                return false;
            temp = temp.children[pos];
            if (i == n - 1)
                return temp.getEnd();
        }
        return false;
    }
    /* Insertion and deletion methods */
    public void insert(String s) {
        if (!s.matches("[A-Z]*")) {
            System.out.println("All letters should be in uppercase A-Z. " + s + " was not inserted.");
            return;
        }
        TrieNode temp = root;
        int  n = s.length();
        for (int i = 0; i < n; i++) {
            char letter = s.charAt(i);
            int pos = letter - 'A'; // getting the child's right position
            if (temp.children[pos] == null)
                temp.children[pos] = new TrieNode(letter);
            temp = temp.children[pos];
            if (i == n - 1)
                temp.setEnd(true);
        }
        System.out.println(s + " was inserted successfully. ");
    }
    public void delete(String s) {
        if (!s.matches("[A-Z]*")) {
            System.out.println("All letters should be in uppercase A-Z. " + s + " was not deleted.");
            return;
        }
        TrieNode temp = root;
        int  n = s.length();
        for (int i = 0; i < n; i++) {
            int pos = s.charAt(i) - 'A'; // getting the child's right position
            if (temp.children[pos] == null) {
                System.out.println(s + " is not in the trie.");
                return;
            }
            temp = temp.children[pos];
            if (i == n - 1) {
                System.out.println("The word " + s + " was deleted.");
                temp.setEnd(false);
                return;
            }
        }
        System.out.println("The word " + s + " is not in the trie to be deleted!");
    }
    public void clear() {
        root.children = new TrieNode[26];
    }

    /* prefix related methods */
    public boolean isPrefix(String s) {
        TrieNode temp = root;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char letter = s.charAt(i);
            if(!(letter >= 65 && letter <= 90))
                return false; // invalid letter
            int pos = letter - 'A'; // getting the child's right position
            if (temp.children[pos] == null)
                return false;
            temp = temp.children[pos];
        }
        ArrayList<String> listOfWords = new ArrayList<String>();
        getAnyWord(temp, listOfWords);
        return listOfWords.size() == 0? false: true;
    }

    private void getAnyWord(TrieNode node, ArrayList<String> listOfWords) {
        if (node.getEnd()) {
            listOfWords.add("");
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                getAnyWord(node.children[i], listOfWords);
            }
        }
    }

    public String[] allWordsPrefix(String p) {
        ArrayList<String> listOfWords = new ArrayList<>();
        TrieNode temp = root;
        int n = p.length();
        for (int i = 0; i < n; i++) {
            int pos = p.charAt(i) - 'A'; // getting the child's right position
            if (temp.children[pos] == null) {
                System.out.println("There aren't any words that starts with " + p);
                return null; // There are no words with this prefix, return null
            }
            temp = temp.children[pos];
        }
        // prefix is there, and temp now refer to the last letter in the prefix
        // from here, look for all the nodes under this node, and add all words to the list.
        getAllWords(temp, p.substring(0, p.length() - 1), listOfWords);

        if(listOfWords.size() == 0) {
            System.out.println("There aren't any words that starts with " + p);
            return null; // There are no words with this prefix, return null
        }
        String[] ArrayOfWords = new String[listOfWords.size()];
        ArrayOfWords = listOfWords.toArray(ArrayOfWords);
        return ArrayOfWords;
    }
    public void getAllWords(TrieNode node, String word, ArrayList<String> listOfWords) {
        word += node.letter;
        if (node.getEnd())
            listOfWords.add(word);
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                getAllWords(node.children[i], word, listOfWords);
            }
        }
    }
}
