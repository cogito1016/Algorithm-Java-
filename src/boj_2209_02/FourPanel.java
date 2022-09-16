package boj_2209_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FourPanel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean isPlusX = Integer.parseInt(br.readLine())>0;
        boolean isPlusY = Integer.parseInt(br.readLine())>0;

        String result = "";

        if(isPlusX && isPlusY){
            result = "1";
        }else if (isPlusX && !isPlusY){
            result = "4";
        }else if (!isPlusX && !isPlusY){
            result = "3";
        }else {
            result = "2";
        }

        bw.write(result);

        br.close();
        bw.close();
    }
}
