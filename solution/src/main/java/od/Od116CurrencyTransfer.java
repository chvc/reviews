package od;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * P00008—货币单位换算
 * //todo 需要再看看
 * @author chenghu
 * @since 2025-09-05 03:44:54
 */
public class Od116CurrencyTransfer {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        // n行
        List<Currency> currencies = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            currencies.add(parseCurrency(s));
        }
        BigDecimal res = cal(currencies);
        // 计算结果
        System.out.println(res.intValue());
    }

    public static Currency parseCurrency(String str) {
        char[] s = str.toCharArray();
        int cur = 0;
        StringBuilder sb = new StringBuilder();
        int y = 0;
        int f = 0;
        String yc = "";
        String fc = "";
        for (int i = 0; i < s.length; i++) {
            char c = s[i];
            if (Character.isDigit(c)) {
                // 结算
                if (sb.length() > 0) {
                    // 如果已经有货币单位了
                    if (sb.toString().equals("CNY")) {
                        yc = "CNY";
                        y = cur;
                    }
                    if (sb.toString().equals("HKD")) {
                        yc = "HKD";
                        y = cur;
                    }
                    if (sb.toString().equals("JPY")) {
                        yc = "JPY";
                        y = cur;
                    }
                    if (sb.toString().equals("EUR")) {
                        yc = "EUR";
                        y = cur;
                    }
                    if (sb.toString().equals("GBP")) {
                        yc = "GBP";
                        y = cur;
                    }
                    if (sb.toString().equals("fen")) {
                        fc = "fen";
                        f = cur;
                    }
                    if (sb.toString().equals("cents")) {
                        fc = "cents";
                        f = cur;
                    }
                    if (sb.toString().equals("sen")) {
                        fc = "sen";
                        f = cur;
                    }
                    if (sb.toString().equals("eurocents")) {
                        fc = "eurocents";
                        f = cur;
                    }
                    if (sb.toString().equals("pence")) {
                        fc = "pence";
                        f = cur;
                    }
                    cur = 0;
                    cur = cur * 10 + (c - '0');
                    sb.setLength(0);
                } else {
                    cur = cur * 10 + (c - '0');
                }
            } else {
                // 货币单位
                // 如果分是0的话
                sb.append(c);
            }
        }
        if (cur != 0 && sb.length() > 0) {
            if (sb.toString().equals("CNY")) {
                yc = "CNY";
                y = cur;
            }
            if (sb.toString().equals("HKD")) {
                yc = "HKD";
                y = cur;
            }
            if (sb.toString().equals("JPY")) {
                yc = "JPY";
                y = cur;
            }
            if (sb.toString().equals("EUR")) {
                yc = "EUR";
                y = cur;
            }
            if (sb.toString().equals("GBP")) {
                yc = "GBP";
                y = cur;
            }
            if (sb.toString().equals("fen")) {
                fc = "fen";
                f = cur;
            }
            if (sb.toString().equals("cents")) {
                fc = "cents";
                f = cur;
            }
            if (sb.toString().equals("sen")) {
                fc = "sen";
                f = cur;
            }
            if (sb.toString().equals("eurocents")) {
                fc = "eurocents";
                f = cur;
            }
            if (sb.toString().equals("pence")) {
                fc = "pence";
                f = cur;
            }
        }
        Currency currency = new Currency(y, f, yc, fc);
        if (currency.yc.equals("CNY") || currency.fc.equals("fen")) {
            currency.cate = 0;
        }
        if (currency.yc.equals("HKD") || currency.fc.equals("cents")) {
            currency.cate = 1;
        }
        if (currency.yc.equals("JPY") || currency.fc.equals("sen")) {
            currency.cate = 2;
        }
        if (currency.yc.equals("EUR") || currency.fc.equals("eurocents")) {
            currency.cate = 3;
        }
        if (currency.yc.equals("GBP") || currency.fc.equals("pence")) {
            currency.cate = 4;
        }
        return currency;
    }

    public static BigDecimal cal(List<Currency> currencies) {
        BigDecimal ans = new BigDecimal(0);
        for (int i = 0; i < currencies.size(); i++) {
            Currency cur = currencies.get(i);
            ans = ans.add(cur.cal());
        }
        return ans;
    }

    public static double rate(String str, int num) {
        if (str.equals("CNY")) {
            return num * 100;
        } else if (str.equals("fen")) {
            return num;
        } else if (str.equals("HKD")) {
            return (double) (num * 100 * 100) / 123;
        } else if (str.equals("cents")) {
            return (double) (num * 100) / 123;
        } else if (str.equals("JPY")) {
            return (double) (num * 100 * 100) / 1825;
        } else if (str.equals("sen")) {
            return (double) (num * 100) / 1825;
        } else if (str.equals("EUR")) {
            return (double) (num * 100 * 100) / 14;
        } else if (str.equals("eurocents")) {
            return (double) (num * 100) / 14;
        } else if (str.equals("GBP")) {
            return (double) (num * 100 * 100) / 12;
        } else {
            return (double) (num * 100) / 12;
        }
    }

    static class Currency {
        int y;
        int f;
        String yc;
        String fc;
        int cate;

        public Currency(int y, int f, String yc, String fc) {
            this.y = y;
            this.f = f;
            this.yc = yc;
            this.fc = fc;
        }

        public BigDecimal cal() {
            BigDecimal ans = new BigDecimal(0);
            if (this.cate == 0) {
                ans = ans.add(new BigDecimal(this.y * 100));
                ans = ans.add(new BigDecimal(this.f));
            }
            if (this.cate == 1) {
                ans = ans.add(new BigDecimal(this.y * 10000).divide(new BigDecimal(123), 2, RoundingMode.HALF_UP));
                ans = ans.add(new BigDecimal(this.f * 100).divide(new BigDecimal(123), 2, RoundingMode.HALF_UP));
            }
            if (this.cate == 2) {
                ans = ans.add(new BigDecimal(this.y * 10000).divide(new BigDecimal(1825), 2, RoundingMode.HALF_UP));
                ans = ans.add(new BigDecimal(this.f * 100).divide(new BigDecimal(1825), 2, RoundingMode.HALF_UP));
            }
            if (this.cate == 3) {
                ans = ans.add(new BigDecimal(this.y * 10000).divide(new BigDecimal(14), 2, RoundingMode.HALF_UP));
                ans = ans.add(new BigDecimal(this.f * 100).divide(new BigDecimal(14), 2, RoundingMode.HALF_UP));
            }
            if (this.cate == 4) {
                ans = ans.add(new BigDecimal(this.y * 10000).divide(new BigDecimal(12), 2, RoundingMode.HALF_UP));
                ans = ans.add(new BigDecimal(this.f * 100).divide(new BigDecimal(12), 2, RoundingMode.HALF_UP));
            }
            return ans;
        }
    }

    // 主币种对应的汇率（换算成 100 fen 的 CNY）
    static Map<String, Double> rate = new HashMap<>();
    // 单位映射到主币种
    static Map<String, String> unitMap = new HashMap<>();

    static {
        rate.put("CNY", 100.0);   // 1元 = 100fen
        rate.put("HKD", 10000.0 / 123);
        rate.put("JPY", 10000.0 / 1825);
        rate.put("EUR", 10000.0 / 14);
        rate.put("GBP", 10000.0 / 12);

        unitMap.put("CNY", "CNY");
        unitMap.put("fen", "CNY");

        unitMap.put("HKD", "HKD");
        unitMap.put("cents", "HKD");

        unitMap.put("JPY", "JPY");
        unitMap.put("sen", "JPY");

        unitMap.put("EUR", "EUR");
        unitMap.put("eurocents", "EUR");

        unitMap.put("GBP", "GBP");
        unitMap.put("pence", "GBP");
    }

    // 处理比较好
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double total = 0.0;

        Pattern p = Pattern.compile("(\\d+)([a-zA-Z]+)");

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            Matcher m = p.matcher(line);

            while (m.find()) {
                int num = Integer.parseInt(m.group(1));
                String unit = m.group(2);
                String currency = unitMap.get(unit);

                if (unit.equals("fen")) {
                    total += num; // fen 直接就是人民币分
                } else if (unit.equals("cents") || unit.equals("sen")
                        || unit.equals("eurocents") || unit.equals("pence")) {
                    // 外币的分，比例是 num/100 * 主币种汇率
                    total += num * rate.get(currency) / 100;
                } else {
                    // 外币的元，比例是 num * 主币种汇率
                    total += num * rate.get(currency);
                }
            }
        }
        System.out.println((int)Math.floor(total));
    }


}
