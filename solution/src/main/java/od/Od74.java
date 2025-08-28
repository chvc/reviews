package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-19 22:45:56
 */
public class Od74 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {
            // 1/N 2/Y
            String[] split = line.split(" ");
            boolean[] child = new boolean[split.length];
            for (int i = 0; i < split.length; i++) {
                child[i] = split[i].charAt(2) == 'Y';
            }
        }
    }

}
