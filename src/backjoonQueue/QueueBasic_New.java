package backjoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QueueBasic_New {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] queue = new int[n];
        int front = 0;
        int back = 0;

        while(n-->0){
            String[] statement = br.readLine().split(" ");
            String order = statement[0];
        }

        br.close();
        bw.close();
    }
}
