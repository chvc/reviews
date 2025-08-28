package od;

import java.util.*;

public class JungleCommute {
    static class State {
        int x, y;          // 当前位置
        int dir;           // 当前方向（0:上, 1:右, 2:下, 3:左）
        int turns;         // 已用拐弯次数
        int clears;        // 已清除路障数
        
        public State(int x, int y, int dir, int turns, int clears) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.turns = turns;
            this.clears = clears;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();  // 最大拐弯次数
        int c = sc.nextInt();  // 最大清除路障数
        int n = sc.nextInt();  // 地图行数
        int m = sc.nextInt();  // 地图列数
        
        char[][] grid = new char[n][m];
        int startX = -1, startY = -1;
        int endX = -1, endY = -1;
        
        // 读取地图并定位起点和终点
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 'T') {
                    endX = i;
                    endY = j;
                }
            }
        }
        
        // 方向数组：上、右、下、左
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        // 四维状态数组：x, y, 方向, 拐弯次数, 清除路障数
        boolean[][][][][] visited = new boolean[n][m][4][t+1][c+1];
        Queue<State> queue = new LinkedList<>();
        
        // 起点初始化：向四个方向出发
        for (int d = 0; d < 4; d++) {
            visited[startX][startY][d][0][0] = true;
            queue.add(new State(startX, startY, d, 0, 0));
        }
        
        boolean found = false;
        
        while (!queue.isEmpty()) {
            State current = queue.poll();
            
            // 到达终点
            if (current.x == endX && current.y == endY) {
                found = true;
                break;
            }
            
            // 尝试所有可能的方向
            for (int newDir = 0; newDir < 4; newDir++) {
                int nextTurns = current.turns;
                
                // 如果改变方向，增加拐弯次数
                if (newDir != current.dir) {
                    nextTurns++;
                    // 超过拐弯限制则跳过
                    if (nextTurns > t) continue;
                }
                
                int nx = current.x + directions[newDir][0];
                int ny = current.y + directions[newDir][1];
                
                // 检查边界
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                char cell = grid[nx][ny];
                int nextClears = current.clears;
                
                // 处理路障
                if (cell == '*') {
                    // 超过清除路障限制则跳过
                    if (nextClears + 1 > c) continue;
                    nextClears++;
                }
                // 跳过起点（已访问过）
                else if (cell == 'S') {
                    continue;
                }
                
                // 检查是否已访问过该状态
                if (visited[nx][ny][newDir][nextTurns][nextClears]) continue;
                
                // 标记为已访问并加入队列
                visited[nx][ny][newDir][nextTurns][nextClears] = true;
                queue.add(new State(nx, ny, newDir, nextTurns, nextClears));
            }
        }
        
        System.out.println(found ? "YES" : "NO");
    }
}