package od;


import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * P00322—免单统计
 *
 * @author chenghu
 * @since 2025-08-29 00:50:01
 */
public class Od92FreeOrderStatistics {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        List<String> times = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String time = scanner.nextLine();
            times.add(time);
        }
        Map<Long, List<String>> listMap = times.stream().collect(Collectors.groupingBy(t -> key(t),
                Collectors.collectingAndThen(Collectors.toList(), list -> {
                            list.sort((o1, o2) -> {
                                String ss1 = o1.split("\\.")[1];
                                String ss2 = o2.split("\\.")[1];
                                return ss1.compareTo(ss2);
                            });
                            return list;
                        }
                )));
        int sum = 0;
        for (Map.Entry<Long, List<String>> entry : listMap.entrySet()) {
            List<String> value = entry.getValue();
            int res = 1;
            for (int i = 1; i < value.size(); i++) {
                if (value.get(i).compareTo(value.get(i - 1)) == 0) {
                    res++;
                } else {
                    break;
                }
            }
            sum += res;
        }
        System.out.println(sum);

    }

    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 2019-01-01 00:00:00.001
    public static long key(String time) {
        String[] split = time.split("\\.");
        String t = split[0];
        LocalDateTime dateTime = LocalDateTime.parse(t, formatter);
        Instant instant = dateTime.toInstant(ZoneOffset.UTC);
        long epochMilli = instant.toEpochMilli();
        return epochMilli;
    }


    /**
     * 更好的实现 直接排序
     */
    /**
     * import java.util.ArrayList;
     * import java.util.Collections;
     * import java.util.List;
     * import java.util.Scanner;
     *
     * class Main {
     *     public static void main(String[] args) {
     *         Scanner in = new Scanner(System.in);
     *         int n = in.nextInt();
     *         in.nextLine();
     *         List<String> list = new ArrayList<>();
     *         while (n > 0) {
     *             list.add(in.nextLine());
     *             n--;
     *         }
     *
     *         int result = 0;
     *         String second = "";
     *         String millSecond = "";
     *         Collections.sort(list);
     *         for (String s : list) {
     *             String[] part = s.split("\\.");
     *             if (part[0].equals(second)) {
     *                 if (part[1].equals(millSecond)) {
     *                     result++;
     *                 }
     *             } else {
     *                 second = part[0];
     *                 millSecond = part[1];
     *                 result++;
     *             }
     *         }
     *         System.out.println(result);
     *     }
     * }
     */


}
