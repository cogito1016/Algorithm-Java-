package boj_2209_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Maximum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = 9;
        int max = -1;
        int count = 1;
        int resultCount = 0;

        while(N-->0){
            int input = Integer.parseInt(br.readLine());

            if(input>max){
                max = input;
                resultCount = count;
            }
            count ++;
        }

        bw.write(max+"\n");
        bw.write(resultCount+"");

        br.close();
        bw.close();
    }
}
