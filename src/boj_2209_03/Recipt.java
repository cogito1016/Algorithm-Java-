package boj_2209_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Recipt {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i=0; i<N; i++){
            String[] s = br.readLine().split(" ");
            sum += (Integer.parseInt(s[0])*Integer.parseInt(s[1]));
        }

        if(sum==X){
            bw.write("Yes");
        }else{
            bw.write("No");
        }

        br.close();
        bw.close();
    }
}
