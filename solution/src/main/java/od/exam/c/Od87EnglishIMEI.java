package od.exam.c;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * P00031—英文输入法
 *
 * @author chenghu
 * @since 2025/8/8
 * @todo 可能有问题
 */
public class Od87EnglishIMEI {
    // todo 可能有问题
    // fixme 可能有问题

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String prefix = sc.nextLine();
        // 处理 input
        input = input.replace(",", " ");
        input = input.replace(".", " ");
        String[] words = input.split(" ");
        List<String> result = search(words, prefix);
        if (result.isEmpty()) {
            System.out.println(prefix);
        } else {
            String join = String.join(" ", result);
            System.out.println(join);
        }

        sc.close();
    }

    public static List<String> search(String[] words, String prefix) {
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words) {
            if (word.contains("'")) {
                String[] split = word.split("'");
                for (int i = 0; i < split.length; i++) {
                    trie.insert(split[i]);
                }
            } else {
                trie.insert(word);
            }
        }
        List<String> wordsByPrefix = trie.findWordsByPrefix(prefix);
        // 搜索前缀
        List<String> collect = wordsByPrefix.stream().sorted(String::compareTo).collect(Collectors.toList());
        return collect;
    }

    public static boolean isSubString(String word, String prefix) {
        if (prefix.length() > word.length()) {
            return false;
        }
        int index = 0;
        while (index < prefix.length()) {
            if (word.charAt(index) != prefix.charAt(index)) {
                return false;
            }
            index++;
        }
        return true;
    }

    static class Trie {

        static class Node {
            Node[] next = new Node[26];
            boolean isEnd;
        }

        Node root;

        Trie() {
            root = new Node();
        }

        void insert(String word) {
            char[] charArray = word.toCharArray();
            Node cur = root;
            for (int i = 0; i < charArray.length; i++) {
                int index = charArray[i] - 'a';
                if (cur.next[index] == null) {
                    Node node = new Node();
                    cur.next[index] = node;
                    cur = node;
                } else {
                    cur = cur.next[index];
                }
            }
            cur.isEnd = true;
        }

        // 查找所有以给定前缀开头的单词
        public List<String> findWordsByPrefix(String prefix) {
            List<String> result = new ArrayList<>();
            Node node = root;

            // 遍历前缀字符
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (node.next[index] == null) {
                    return result; // 前缀不存在
                }
                node = node.next[index];
            }

            // 收集所有以该前缀开头的单词
            collectWords(node, new StringBuilder(prefix), result);
            return result;
        }

        // 递归收集单词
        public void collectWords(Node node, StringBuilder current, List<String> result) {
            if (node.isEnd) {
                result.add(current.toString());
            }

            for (char c = 'a'; c <= 'z'; c++) {
                int index = c - 'a';
                if (node.next[index] != null) {
                    current.append(c); // 添加当前字符
                    collectWords(node.next[index], current, result);
                    current.deleteCharAt(current.length() - 1); // 回溯
                }
            }
        }

        List<String> prefix(String word) {
            //  根据前缀搜索单词
            // apple app
            char[] charArray = word.toCharArray();
            Node cur = root;
            for (int i = 0; i < charArray.length; i++) {
                int index = charArray[i] - 'a';
                if (cur.next[index] == null) {
                    return new ArrayList<>();
                } else {
                    cur = cur.next[index];
                }
            }
            if (cur == null) {
                return new ArrayList<>();
            } else {
                // cur is not null 找出下一个isEnd为true的 加入到结果中去
                List<String> res = new ArrayList<>();
                Node[] next = cur.next;
                StringBuilder sb = new StringBuilder(word);
                while (cur != null) {
                    for (int i = 0; i < next.length; i++) {
                        if (next[i] != null) {
                            char c = (char) ('a' + i);
                            sb.append(c);
                            if (next[i].isEnd) {
                                res.add(sb.toString());
                            } else {
                                cur = next[i];
                            }
                        }
                    }
                }

                return res;
            }
        }
    }

}
