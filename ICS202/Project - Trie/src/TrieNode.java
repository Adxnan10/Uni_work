public class TrieNode {
    protected char letter;
    protected boolean isEnd;
    protected TrieNode[] children = new TrieNode[26];
    public TrieNode() {
        this(' ', false);
    }
    public TrieNode(char letter) {
        this(letter, false);
    }
    public TrieNode(char letter, boolean isEnd) {
        this.letter = letter;
        this.isEnd = isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }
    public boolean getEnd() {
        return isEnd;
    }

    @Override
    public String toString() {
        return letter + " ";
    }
}