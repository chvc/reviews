package tree;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025/8/9
 */
public class Lc211 {

    static class WordDictionary {

        Node root;


        class Node {

            Node[] next;

            boolean isEnd;

            Node() {
                this.next = new Node[26];
            }
        }

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {

            char[] wordCharArray = word.toCharArray();
            Node cur = root;
            for (Character c : wordCharArray) {
                int index = c - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new Node();
                }
                cur = cur.next[index];
            }
            cur.isEnd = true;
        }

        public boolean search(String word) {

            char[] wordCharArray = word.toCharArray();
            Node cur = root;
            return dfs(wordCharArray, cur, 0);
        }

        public boolean dfs(char[] wordCharArray, Node cur, int i) {
            if (i == wordCharArray.length) {
                return cur.isEnd;
            }
            char c = wordCharArray[i];
            // 如果是通配符
            Node[] next = cur.next;
            if (c == '.') {
                for (int j = 0; j < next.length; j++) {
                    if (next[j] == null) {
                        continue;
                    }
                    Node temp = cur;
                    cur = cur.next[j];
                    boolean find = dfs(wordCharArray, cur, i + 1);
                    if (find) {
                        return find;
                    } else {
                        cur = temp;
                    }
                }
            } else {
                if (next[c - 'a'] == null) {
                    return false;
                } else {
                    Node temp = cur;
                    cur = cur.next[c - 'a'];
                    boolean find = dfs(wordCharArray, cur, i + 1);
                    if (find) {
                        return find;
                    } else {
                        cur = temp;
                    }
                }
            }
            // 如果全部都没有的话
            return false;
        }
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ab"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("..d"));
        System.out.println(wordDictionary.search("..b"));
        System.out.println(wordDictionary.search("b.."));
        System.out.println(wordDictionary.search("..."));
        System.out.println(wordDictionary.search("...."));
        System.out.println(wordDictionary.search("abcd"));

    }
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */


}
