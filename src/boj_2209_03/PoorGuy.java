package boj_2209_03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class PoorGuy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while(N-->0){
            String[] s = br.readLine().split(" ");
            int studentNum = Integer.parseInt(s[0]);

            int sum = 0;
            for(int i=1; i<=studentNum; i++){
               sum += Integer.parseInt(s[i]);
            }
            int average = sum/studentNum;

            int upperAvgStudentCount = 0;
            for(int i=1; i<=studentNum; i++){
                int point =  Integer.parseInt(s[i]);

                if(average<point){
                    upperAvgStudentCount++;
                }
            }

            String result =String.format("%.3f",(Double.parseDouble(upperAvgStudentCount+"")/Double.parseDouble(studentNum+"")*100.0));

            bw.write(result+"%\n");
        }

        br.close();
        bw.close();
    }
}
