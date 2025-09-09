package testing;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadLocalRandom;

@BenchmarkMode(Mode.AverageTime)          // 测试平均耗时
@OutputTimeUnit(TimeUnit.MILLISECONDS)    // 结果单位：毫秒
@State(Scope.Thread)                      // 每个线程一份状态
public class TopoSortBenchmarkJMH {

    private List<String[]> edges;

    @Param({"1000", "5000", "10000", "20000"}) // 参数化节点规模
    private int n;

    @Setup(Level.Invocation)
    public void setup() {
        int m = n * 3; // 边数设为节点数的3倍
        edges = randomDAG(n, m);
    }

    // ========= 基准测试方法 =========
    @Benchmark
    public List<String> testLayerSort() {
        return topoSortLayerSort(edges);
    }

    @Benchmark
    public List<String> testPQ() {
        return topoSortPQ(edges);
    }

    // ========= 算法实现 =========
    public static List<String> topoSortLayerSort(List<String[]> edges) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indeg = new HashMap<>();
        Set<String> nodes = new HashSet<>();

        for (String[] e : edges) {
            String a = e[0], b = e[1];
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            indeg.put(a, indeg.getOrDefault(a, 0) + 1);
            indeg.putIfAbsent(b, 0);
            nodes.add(a);
            nodes.add(b);
        }

        Queue<String> q = new ArrayDeque<>();
        for (String n : nodes) {
            if (indeg.getOrDefault(n, 0) == 0) q.add(n);
        }

        List<String> result = new ArrayList<>();
        while (!q.isEmpty()) {
            List<String> tmp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) tmp.add(q.poll());
            tmp.sort(String::compareTo);
            result.addAll(tmp);
            for (String u : tmp) {
                for (String v : graph.getOrDefault(u, Collections.emptyList())) {
                    indeg.put(v, indeg.get(v) - 1);
                    if (indeg.get(v) == 0) q.add(v);
                }
            }
        }
        return result;
    }

    public static List<String> topoSortPQ(List<String[]> edges) {
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> indeg = new HashMap<>();
        Set<String> nodes = new HashSet<>();

        for (String[] e : edges) {
            String a = e[0], b = e[1];
            graph.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
            indeg.put(a, indeg.getOrDefault(a, 0) + 1);
            indeg.putIfAbsent(b, 0);
            nodes.add(a);
            nodes.add(b);
        }

        PriorityQueue<String> pq = new PriorityQueue<>();
        for (String n : nodes) {
            if (indeg.getOrDefault(n, 0) == 0) pq.add(n);
        }

        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            String u = pq.poll();
            result.add(u);
            for (String v : graph.getOrDefault(u, Collections.emptyList())) {
                indeg.put(v, indeg.get(v) - 1);
                if (indeg.get(v) == 0) pq.add(v);
            }
        }
        return result;
    }

    // ========= 随机 DAG 生成 =========
    private static List<String[]> randomDAG(int n, int m) {
        List<String> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) nodes.add("T" + i);
        Set<String[]> edges = new HashSet<>();
        ThreadLocalRandom rand = ThreadLocalRandom.current();

        while (edges.size() < m) {
            int a = rand.nextInt(n);
            int b = rand.nextInt(n);
            if (a <= b) continue; // 保证无环
            edges.add(new String[]{nodes.get(a), nodes.get(b)});
        }
        return new ArrayList<>(edges);
    }

    public static void main(String[] args) throws Exception {
        Options opt = new OptionsBuilder()
                // 指定运行的基准类，正则匹配
                .include("TopoSortBenchmarkJMH")
                // 设置 fork 数（启动多少个 JVM 测量）
                .forks(2)
                // 预热次数
                .warmupIterations(5)
                // 测量次数
                .measurementIterations(10)
                // 每次测量的单位
                .timeUnit(java.util.concurrent.TimeUnit.MILLISECONDS)
                // 每次测量模式，这里是平均耗时
                .mode(org.openjdk.jmh.annotations.Mode.AverageTime)
                .build();

        new Runner(opt).run();
    }
}
