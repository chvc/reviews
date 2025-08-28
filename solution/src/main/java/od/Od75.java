package od;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-19 20:54:30
 */
public class Od75 {



        public static void main(String[] args) throws Exception {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while((line = read.readLine())!=null){
                String[] strs = line.split(",");
                Integer taskA = Integer.parseInt(strs[0]);
                Integer taskB = Integer.parseInt(strs[1]);
                Integer num = Integer.parseInt(strs[2]);
                HashSet<Integer> set = new HashSet<>();
                for(int i = 1;i<num;i++) {
                    int sum = taskA*i+taskB*(num-i);
                    set.add(sum);
                }
                List<Integer> list=  new ArrayList<Integer>(set);
                System.out.println(list);
            }
        }



}
