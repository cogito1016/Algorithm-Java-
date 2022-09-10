package boj_2209_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JjamBbong {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[1]);

        int sum = first + second;
        int sub = first - second;
        int mul = first * second;
        int divTop = first / second;
        int divBottom = first % second;

        bw.write(sum+"\n"+sub+"\n"+mul+"\n"+divTop+"\n"+divBottom);
        bw.close();
    }
}
