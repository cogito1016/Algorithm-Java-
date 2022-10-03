package boj_2209_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ACMHotel {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int YY=0, XX=0;

            String[] s = br.readLine().split(" ");
            int H = Integer.parseInt(s[0]);
            int W = Integer.parseInt(s[1]);
            int N = Integer.parseInt(s[2]);

            int top = N/H;
            int bottom = N%H;

            if(bottom == 0){
                XX=top;
                YY=H;
            }else{
                XX=top+1;
                YY=bottom;
            }

            int result = Integer.parseInt(YY+formatNumber(XX));

            bw.write(result+"");
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    public static String formatNumber(int N){
        String s = N+"";
        if(s.length()==2){
            return s;
        }else{
            return "0"+s;
        }
    }
}
