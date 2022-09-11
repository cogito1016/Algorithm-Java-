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

/**
 * 1.
 * 1-1. chessRule을 Map으로 리팩토링
 * 1-1-1. Key: 폰,킹,퀸 ...
 * 1-1-2. Value: 필요개수
 * 1-2. 사용자 입력을 Stream화
 * 1-2-1. map을 사용하여 처리.. 하려면 사용자 입력 순서에도 Key값이 있어야하잖아?
 * Failed
 * 사용자의 입력값 중 처음이 '킹'임을 알아야 Map을 사용할 수 있다.
 * 그럼 사용자 입력을 List<Map<String,Integer>>로 만든 후 Stream()처리를 해야하는 것일까?
 * 그렇다면 정말 구려질 것.
 */