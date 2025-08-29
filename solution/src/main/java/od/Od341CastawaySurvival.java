package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * P00021—荒岛求生
 *
 * @author chenghu
 * @since 2025-08-20 01:17:46
 */
public class Od341CastawaySurvival {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = reader.readLine()) != null) {

            Stack<Integer> stack = new Stack<>();
            List<Integer> nums = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            int count = 0;
            for (int i = 0; i < nums.size(); i++) {
                Integer num = nums.get(i);
                if (num > 0) {
                    stack.push(num);
                } else {
                    if (stack.isEmpty()) {
                        count++;
                    } else {
                        while (!stack.isEmpty() && Math.abs(stack.peek()) <= Math.abs(num)) {

                            num = Math.abs(Math.abs(num) - Math.abs(stack.peek()));
                            stack.pop();
                        }
                        if (stack.isEmpty() && num > 0) {
                            count++;
                        } else {
                            if (!stack.isEmpty()) {
                                Integer pop = stack.pop();
                                stack.push(pop - Math.abs(num));
                            }
                        }
                    }
                }
            }
            if (!stack.isEmpty()) {
                count += stack.size();
            }
            System.out.println(count);
        }

    }
}
