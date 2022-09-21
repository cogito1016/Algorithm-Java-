package boj_2209_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OX {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            String[] s = br.readLine().split("");
            int sLen = s.length;
            int count = 0;
            int sum = 0;

            for(int i=0; i<sLen; i++){
                String c = s[i];
                if(c.equals("O")){
                    count++;
                    sum += count;
                }else{
                    count = 0;
                }
            }

            bw.write(sum+"\n");
        }


        br.close();
        bw.close();
    }
}
