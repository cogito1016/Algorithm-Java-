package boj_2209_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ResultValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 10;
        int[] dp = new int[1000];
        int count = 0;

        while(N-->0) {
            int input = Integer.parseInt(br.readLine())%42;
            if(dp[input]==0){
                count++;
            }
            dp[input]++;
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }
}
