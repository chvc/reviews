

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                // 如果是右括号 比较 是不是匹配的
                Character pop = stack.pop();
                if (c == ']' && pop != '[') {
                    return false;
                }
                if (c == '}' && pop != '{') {
                    return false;
                }
                if (c == ')' && pop != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public int climbStairs(int n) {
        // 爬楼梯
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 2;
        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n - 1];
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);

        int n = 0;
        try {
            st.nextToken();
            n = (int) st.nval;
//            n = scanner.nextInt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        while (t > 0) {
//
//            int n = scanner.nextInt();
//            int k = scanner.nextInt();
//            String result = findChar(n, k);
//            if (result.equals("R")) {
//                System.out.println("red");
//            } else {
//                System.out.println("blue");
//            }
//            t--;
//        }
//        minCnt(t);
//        int m = scanner.nextInt();
        st.nextToken();
        int m = (int) st.nval;
        System.out.println(find(n, m));
//        int[] arr = {1, 1, 1, 2, 2, 3};
////        solution.moveZeroes(arr);
////        System.out.println(Integer.toBinaryString(39));
////        solution.removeDuplicates(arr);
//        int[] coins = {4, 2, 1};
////        System.out.println(solution.minCount(coins));
////        System.out.println(solution.cnk3(3,2));
//        solution.generate(5);
//        System.out.println(solution.fac(3));
//        System.out.println(39<<1);
//        System.out.println(Integer.toBinaryString(39<<1));
    }


    public int guessNumber(int n) {
        int guessNum = n / 2;
        int max = n;
        int min = 1;
        while (true) {
            int num = guess(guessNum);
            if (num == 0) {
                return guessNum;
            }
            if (num == -1) {
                guessNum = (min + guessNum) / 2;
                max = guessNum;
            }
            if (num == 1) {
                guessNum = (max + guessNum) / 2;
                min = guessNum;
            }
        }
    }

    private int guess(int n) {
        int pick = 2;
        if (pick < n) {
            return -1;
        }
        if (pick > n) {
            return 1;
        }
        return 0;
    }


    public String addBinary(String a, String b) {
        // 将 二进制 转换成 10进制 再求和 再转回二进制
        BigInteger num1 = new BigInteger(a, 2);
        BigInteger num2 = new BigInteger(b, 2);

        // 求和
        BigInteger sum = num1.add(num2);

        // 直接返回的是二进制字符串，不需要额外转换
        return sum.toString(2);
    }


    private int bin2oct(String s) {
        char[] charArray = s.toCharArray();
        int i = 0;
        Double pow = 0d;
        for (int j = charArray.length - 1; j >= 0; j--) {
            if (charArray[j] == '1') {
                pow += Math.pow(2, i);
            }
            i++;
        }
        return pow.intValue();
    }

    private String oct2bin(int num) {
        StringBuilder sb = new StringBuilder("0");
        int x;
        while (num != 0) {
            x = num % 2;
            num = num / 2;
            sb.append(x);
        }
        return sb.reverse().toString();
    }


    public boolean isGood(int[] nums) {
        //  针对这个数组
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (max < num) {
                max = num;
            }
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            Integer cnt = entry.getValue();
            if (num != max && cnt > 1) {
                return false;
            }
            if (num == max && cnt != 2) {
                return false;
            }
        }
        return true;
    }

    public int sumCounts(List<Integer> nums) {
        // 子数组
        int size = nums.size();
        Integer sum = 0;
        for (int i = 0; i < size; i++) {
            Integer part = part(nums, i + 1);
            sum += part;
        }
        return ((Double) (sum % (Math.pow(10, 9) + 7))).intValue();
    }

    private Integer part(List<Integer> nums, int length) {
        Integer sum = 0;
        for (int i = 0; i < nums.size() && i + length <= nums.size(); i++) {
            List<Integer> integers = nums.subList(i, i + length);
            // 元素的个数
            HashSet<Integer> set = new HashSet<Integer>(integers);
            int size = set.size();
            sum += size * size;
        }
        return sum;
    }


    public int maxProfit(int[] prices) {
        // 定义一个数组来表示 前n个元素之间的差
        // 0  -6
        int[] arr = new int[prices.length];
        arr[0] = 0;
        for (int i = 0; i < prices.length && i + 1 < prices.length; i++) {
            arr[i + 1] = arr[i] + (prices[i + 1] - prices[i]);
        }
        // 拿到了 数组 前n 个元素的差
        return 0;
    }

    public void moveZeroes(int[] nums) {
        int zeroPlace = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                zeroPlace++;
                // 交换元素与0的值
                swap(nums, i, zeroPlace);
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int addDigits(int num) {
        int a = num / 10;
        int b = num % 10;
        while (a + b < 10) {
            num = a + b;
            a = num / 10;
            b = num % 10;
        }
        return a + b;
    }

    public int removeDuplicates(int[] nums) {
        int val = -10000000;
        int place = 0;
        for (int i = 0; i < nums.length; i++) {
            if (place % 2 == 0) {
                if (nums[i] != val) {
                    nums[place] = nums[i];
                    val = nums[place];
                    place++;
                }
            } else {
                if (nums[i] == val) {
                    val++;
                    place++;
                }
            }

        }
        return place;
    }

    public boolean equalFrequency(String word) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int min = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int value = map.get(c) + 1;
                if (value > max) {
                    max = value;
                }
                map.put(c, value);
            }
        }
        int freq = 1;
        boolean isAllSame = true;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            Integer fre = entry.getValue();
            if (fre - freq > 1) {
                return false;
            }
            if (fre != freq) {
                isAllSame = false;
            }
        }
        System.out.println("====");
        return false;
    }

    public boolean isAnagram(String s, String t) {
        // 如果长度不一样 一定不是
        if (s.length() != t.length()) {
            return false;
        }
        //
        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
        for (Character c : s.toCharArray()) {
            if (sMap.containsKey(c)) {
                Integer count = sMap.get(c);
                sMap.put(c, ++count);
            } else {
                sMap.put(c, 1);
            }
        }

        for (Character c : t.toCharArray()) {
            if (tMap.containsKey(c)) {
                Integer count = tMap.get(c);
                tMap.put(c, ++count);
            } else {
                tMap.put(c, 1);
            }
        }
        // 判断元素的个数是不是一样的
        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            Character c = entry.getKey();
            Integer num = entry.getValue();
            Integer tCount = tMap.get(c);
            if (tCount == null || tCount != num) {
                return false;
            }
        }
        return true;
    }

    public int minCount(int[] coins) {
        int cnt = 0;

        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            while (coin > 0) {
                coin = coin - 2;
                cnt++;
            }
        }
        return cnt;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            int k = 0;
            while (k <= i) {
                list.add(cnk3(i, k));
                k++;
            }
            lists.add(list);
        }
        return lists;
    }

    public int cnk(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }
        return (fac(n).divide(fac(k)).divide(fac(n - k))).intValue();
    }

    public BigInteger fac(int n) {
        if (n == 0) {
            return new BigInteger("1");
        }
        BigInteger res = new BigInteger("1");
        BigInteger k = new BigInteger("1");
        while (k.intValue() <= n) {
            res = res.multiply(k);
            k = k.add(BigInteger.ONE);
        }
        return res;
    }

    public int cnk2(int n, int k) {
        if (k == 0 || n == k) {
            return 1;
        }
        return cnk2(n - 1, k - 1) + cnk2(n - 1, k);
    }

    public int cnk3(int n, int k) {
        if (n <= 1) {
            return 1;
        }
        // 可以降维处理
        // C00 ===> 0
        // C10 C11 ==> 1
        // C20 C21 C22 ===> 2 3
        // C30 C31 C32 C33 ===> 4 5
        int[][] res = new int[n + 1][n + 1];
        res[0][0] = 1;
        res[1][0] = 1;
        res[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    res[i][j] = 1;
                    continue;
                }
                res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
            }
        }
        return res[n][k];
    }

    public static String findChar(int n, long k) {
        if (n == 1) {
            return "R";
        }
        if (n == 2 && k == 0) {
            return "B";
        }
        if (n == 2 && k == 1) {
            return "R";
        }
        long count = (long) Math.pow(2, n - 2);
        if (k >= count) {
            return findChar(n - 1, k - count);
        } else {
            return reverse(findChar(n - 1, k));
        }
    }

    public static String reverse(String str) {
        if (str.equals("R")) {
            return "B";
        } else {
            return "R";
        }
    }

    public static void minCnt(int i) {
        // 最小的次数
        int[] dp = new int[i];
        dp[0] = 1;
        dp[1] = 0;
        int pow = 0;
        for (int j = 1; j < i; j = j * 2) {
            dp[j] = pow;
            pow++;
        }
        // 再算距离

        System.out.println(Arrays.toString(dp));
    }

    public static int find(int n, int m) {
        if (n <= 2 || n > 7) {
            return -1;
        }
        if (m < 0) {
            return -1;
        }
        int min = (int) Math.pow(10, n - 1);
        int max = (int) Math.pow(10, n);
        List<Integer> list = new ArrayList<>();
        for (int i = min; i < max; i++) {
            int sum = 0;
            int j = i;
            while (j != 0) {
                int x = j % 10;
                sum = sum + (int) Math.pow(x, n);
                j = j / 10;
            }
            if (sum == i) {
                list.add(i);
            }
        }
        if (m < list.size()) {
            return list.get(m);
        } else {
            return list.get(list.size() - 1) * m;
        }

    }

}

