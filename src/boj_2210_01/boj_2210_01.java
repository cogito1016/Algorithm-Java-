package boj_2210_01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_2210_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int result = -1;

        int fiveBottom = 0;
        int thirdTop = 0;
        int thirdBottom = 0;
        int temp = N;
        int fiveTopOffset = N/5;

        while (fiveTopOffset!=-1) {

            fiveBottom = temp - (5*fiveTopOffset);

            if(fiveBottom==0){
                result = fiveTopOffset;
                break;
            }

            temp = fiveBottom;

            thirdTop = temp/3;
            thirdBottom = temp%3;

            if(thirdBottom==0){
                result = fiveTopOffset+thirdTop;
                break;
            }

            fiveTopOffset--;
            temp = N;
        }

        bw.write(result+"");

        br.close();
        bw.close();
    }
}
