//package misc;
//
//import java.util.*;
//
//public class LispCalculator {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextLine()) {
//            String expr = scanner.nextLine().trim();
//            try {
//                int result = evaluate(expr);
//                System.out.println(result);
//            } catch (Exception e) {
//                System.out.println("error");
//            }
//        }
//        scanner.close();
//    }
//
//    public static int evaluate(String expr) throws Exception {
//        // 移除所有空格以简化处理
//        String compactExpr = expr.replaceAll("\\s+", "");
//        Stack<Object> stack = new Stack<>();
//        StringBuilder currentToken = new StringBuilder();
//
//        for (int i = 0; i < compactExpr.length(); i++) {
//            char c = compactExpr.charAt(i);
//
//            if (c == '(') {
//                // 开始新表达式
//                stack.push(c);
//                currentToken.setLength(0); // 重置token
//            } else if (c == ')') {
//                // 处理当前token（如果有）
//                if (currentToken.length() > 0) {
//                    pushToken(stack, currentToken.toString());
//                    currentToken.setLength(0);
//                }
//
//                // 计算表达式
//                calculateExpression(stack);
//            } else if (isOperatorChar(c) || c == '-') {
//                // 操作符或负号
//                currentToken.append(c);
//            } else if (Character.isDigit(c)) {
//                // 数字
//                currentToken.append(c);
//            } else {
//                throw new Exception("Invalid character: " + c);
//            }
//        }
//
//        // 处理表达式末尾可能存在的token
//        if (currentToken.length() > 0) {
//            pushToken(stack, currentToken.toString());
//        }
//
//        if (stack.size() != 1 || !(stack.peek() instanceof Integer)) {
//            throw new Exception("Invalid expression");
//        }
//
//        return (int) stack.pop();
//    }
//
//    private static void pushToken(Stack<Object> stack, String token) {
//        if (token.equals("add") || token.equals("sub") ||
//            token.equals("mul") || token.equals("div")) {
//            stack.push(token); // 操作符
//        } else {
//            try {
//                int num = Integer.parseInt(token);
//                stack.push(num); // 数字
//            } catch (NumberFormatException e) {
//                stack.push(token); // 可能是部分操作符
//            }
//        }
//    }
//
//    private static void calculateExpression(Stack<Object> stack) throws Exception {
//        // 收集操作数和操作符
//        Stack<Object> temp = new Stack<>();
//        while (!stack.isEmpty() && stack.peek() != '(') {
//            temp.push(stack.pop());
//        }
//
//        if (stack.isEmpty()) {
//            throw new Exception("Mismatched parentheses");
//        }
//        stack.pop(); // 移除 '('
//
//        // 表达式必须有操作符和两个操作数
//        if (temp.size() < 3) {
//            throw new Exception("Incomplete expression");
//        }
//
//        // 提取操作符和操作数
//        Object opObj = temp.pop();
//        if (!(opObj instanceof String)) {
//            throw new Exception("Operator expected");
//        }
//        String op = (String) opObj;
//
//        Object p2Obj = temp.pop();
//        Object p1Obj = temp.pop();
//
//        if (!(p1Obj instanceof Integer) || !(p2Obj instanceof Integer)) {
//            throw new Exception("Operands must be integers");
//        }
//
//        int p1 = (int) p1Obj;
//        int p2 = (int) p2Obj;
//        int result;
//
//        // 执行计算
//        switch (op) {
//            case "add":
//                result = p1 + p2;
//                break;
//            case "sub":
//                result = p1 - p2;
//                break;
//            case "mul":
//                result = p1 * p2;
//                break;
//            case "div":
//                if (p2 == 0) {
//                    throw new ArithmeticException("Division by zero");
//                }
//                // 向下取整除法
//                result = (int) Math.floor((double) p1 / p2);
//                break;
//            default:
//                throw new Exception("Invalid operator: " + op);
//        }
//
//        // 将结果压回栈中
//        stack.push(result);
//    }
//
//    private static boolean isOperatorChar(char c) {
//        return c == 'a' || c == 'd' || c == 's' || c == 'u' || c == 'm' || c == 'l';
//    }
//}