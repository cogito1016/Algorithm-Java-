package boj_2209_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Mul {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //(세 자리 수) × (세 자리 수)
        int A = Integer.parseInt(br.readLine());
        String inputB = br.readLine();
        String[] B = inputB.split("");
        int B_1_Number = Integer.parseInt(B[2]);
        int B_10_Number = Integer.parseInt(B[1]);
        int B_100_Number = Integer.parseInt(B[0]);
        int B_Number = Integer.parseInt(inputB);

        bw.write(A*B_1_Number+"\n");
        bw.write(A*B_10_Number+"\n");
        bw.write(A*B_100_Number+"\n");
        bw.write(A*B_Number+"\n");

        br.close();
        bw.close();
    }
}
