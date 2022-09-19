package boj_2209_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PlusCycle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String Nstr = br.readLine();
        final int N = Integer.parseInt(Nstr);

        int count = 0;
        int temp = N;
        while( (N!=temp) || (count==0)){
            count++;

            int first = temp%10;
            int last = (temp/10+temp%10)%10;

            String s = first+""+last;
            temp = Integer.parseInt(s);
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }
}
