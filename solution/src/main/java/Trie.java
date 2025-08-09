/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/8
 */
public class Trie {

    Node root;

    class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            children = new Node[26];
        }
    }

    public Trie() {
        root = new Node();

    }

    public void insert(String word) {
        char[] charArray = word.toCharArray();
        Node cur = root;
        for (int i = 0; i < charArray.length; i++) {
            Node node = cur.children[charArray[i] - 'a'];
            if (node == null) {
                Node newNode = new Node();
                cur.children[charArray[i] - 'a'] = newNode;
                cur = newNode;
            } else {
                cur = node;
            }
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        Node cur = root;
        for (int i = 0; i < charArray.length; i++) {
            Node node = cur.children[charArray[i] - 'a'];
            if (node == null) {
                return false;
            } else {
                cur = node;
            }
        }
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        Node cur = root;
        for (int i = 0; i < charArray.length; i++) {
            Node node = cur.children[charArray[i] - 'a'];
            if (node == null) {
                return false;
            } else {
                cur = node;
            }
        }
        return cur != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        trie.insert("abd");
        System.out.println(trie.search("abe"));
        System.out.println(trie.startsWith("ab"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

