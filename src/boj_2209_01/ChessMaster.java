package boj_2209_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 체스는 총 16개의 피스를 사용하며, 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개로 구성되어 있다.
public class ChessMaster {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] chessRule = {1,1,2,2,2,8};
        int chessHorseNumber = chessRule.length;

        // 킹, 퀸, 룩, 비숍, 나이트, 폰의 개수
        String[] inputArr = br.readLine().split(" ");


        for(int i=0; i<chessHorseNumber; i++){
            bw.write(chessRule[i] - Integer.parseInt( inputArr[i]) +" ");
        }

        br.close();
        bw.close();
    }
}
