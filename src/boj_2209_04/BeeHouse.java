package boj_2209_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BeeHouse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int offset = 1;
        int presentFloor = 1;
        int goalFloorNum = 0;
        int maxFloorNum = offset+goalFloorNum;

        while(offset != N){
            offset++;

            if(offset==maxFloorNum+1){
                goalFloorNum+=6;
                maxFloorNum+=goalFloorNum;
                presentFloor++;
            }
        }

        bw.write(presentFloor+"");

        br.close();
        bw.close();
    }
}
