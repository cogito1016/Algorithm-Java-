package boj_2209_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AmbitionPerson {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] map = new int[15][15];

        for(int i=1; i<=14; i++){
            map[0][i] = i ;
        }

        for(int i=1; i<=14; i++){
            for(int j=1; j<=14; j++){
                for(int k=1; k<=j; k++){
                    map[i][j] += map[i-1][k];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(map[k][n]+"");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
