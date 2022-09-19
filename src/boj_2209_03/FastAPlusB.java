package boj_2209_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FastAPlusB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            String[] s = br.readLine().split(" ");
            bw.write(Integer.parseInt(s[0])+Integer.parseInt(s[1])+"");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
