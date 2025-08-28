package misc;

import java.util.*;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);

        String exp = "(add (sub (mul 1 -5) (add 8 9)) 5)";
        String[] input = exp.split(" ");


        String[] ops = new String[]{"add", "sub", "mul", "div"};
        Set<String> opSet = Arrays.stream(ops).collect(Collectors.toSet());
        Stack<String> stack = new Stack<>();
        for (String s : input) {
            if (!s.contains(")")) {
                stack.push(s);
                continue;
            }

            while (s.contains(")")) {
                String temp = s.substring(s.indexOf(")") + 1);
                int num2 = Integer.parseInt(s.substring(0, s.indexOf(")")));
                int num1 = Integer.parseInt(stack.pop());
                String op = stack.pop().substring(1, 4);
                String result = cal(op, num1, num2);
                if (result.equals("error")) return;
                s = result + temp;
                if (temp.isEmpty()) {
                    stack.push(result);
                }
            }
        }
        System.out.println(stack.pop());
    }

    private static String cal(String s, int num1, int num2) {
        String result = "error";
        switch (s) {
            case "add":
                result = String.valueOf(num1 + num2);
                break;
            case "sub":
                result = String.valueOf(num1 - num2);
                break;
            case "mul":
                result = String.valueOf(num1 * num2);
                break;
            case "div":
                if (num2 == 0) {
                    System.out.println("error");
                    return "error";
                }
                result = String.valueOf(num1 / num2);
                break;
            default:
                break;
        }
        return result;
    }
}