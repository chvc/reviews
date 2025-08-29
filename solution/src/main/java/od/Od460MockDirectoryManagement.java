package od;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * P00319—模拟目录管理
 *
 * @author chenghu
 * @since 2025-08-23 21:06:54
 */
public class Od460MockDirectoryManagement {

    public static int MAXN = 1000;


    static class Dir {

        Dir() {
            this.cur = new Node("/");
            cur.sb = new StringBuilder("/");
        }

        Node cur;

        class Node {

            String path;

            Map<String, Node> children;

            StringBuilder sb;

            Node parent;

            Node(String path) {
                this.path = path;
                children = new HashMap<>();
            }

            Node(Node parent, String path) {
                this.path = path;
                this.parent = parent;
                children = new HashMap<>();
                this.sb = new StringBuilder(parent.sb.toString()).append(path).append("/");
            }


        }

        public void pwd() {
            System.out.println(cur.sb.toString());
        }

        public void cd(String path) {
            Map<String, Node> children = cur.children;
            if (path.equals("..")) {
                cur = cur.parent == null ? cur : cur.parent;
            } else {
                if (children.containsKey(path)) {
                    cur = children.get(path);
                }
            }
        }

        public void mkdir(String path) {
            // 从 cur 创建 Node
            Map<String, Node> children = cur.children;
            // 不含 当前key 就创建
            if (!children.containsKey(path)) {
                Node node = new Node(cur, path);
                children.put(path, node);
            }
        }

    }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Dir dir = new Dir();
        while (scanner.hasNextLine()) {
            String[] operation = scanner.nextLine().split(" ");
            String op = operation[0];
            if (op.equals("mkdir")) {
                dir.mkdir(operation[1]);
            } else if (op.equals("cd")) {
                dir.cd(operation[1]);
            } else {
                // 输出命令
                dir.pwd();
            }
        }
    }
}
