package boj_2209_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DdoRaE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];

        double max = -1;
        double result = 0.0;

        String[] s = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(s[i]);

            if(max<arr[i]){
                max=arr[i];
            }
        }

        for(int i=0; i<N; i++){
            result += (arr[i]/max)*100;
        }

        bw.write(result/N+"");

        br.close();
        bw.close();
    }
}
