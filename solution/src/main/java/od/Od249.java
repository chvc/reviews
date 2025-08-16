package od;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * 〈一句话功能简述〉
 *
 * @author chenghu
 * @since 2025-08-15 23:58:36
 */
public class Od249 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(reader);
        while (in.nextToken()!=StreamTokenizer.TT_EOF){
            String str = in.sval;
            System.out.println(str);
        }
    }


}
