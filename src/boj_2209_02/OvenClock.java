package boj_2209_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OvenClock {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] time = br.readLine().split(" ");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        int resultHour = 0, resultMinute = 0;

        int cookTime = Integer.parseInt(br.readLine());

        resultHour = (hour + (minute+cookTime)/60)%24;
        resultMinute = (minute+cookTime)%60;

        bw.write(resultHour+" "+resultMinute);

        br.close();
        bw.close();
    }
}
