package boj_2209_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SugarDeliveryService {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0;

        if(N/5!=0){
            count += N/5;
            N = N%5;
        }

        if(N/3!=0){
            count += N/3;
            N = N%3;
        }

        if(N!=0){
            count = -1;
        }

        bw.write(count+"");

        br.close();
        bw.close();
    }
}
