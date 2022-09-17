package boj_2209_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ThreeDice_Refactor_DP2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[7];

        Arrays.stream(br.readLine().split(" "))
                .forEach((element)-> nums[Integer.parseInt(element)]++);

        int result = 0;

        for(int i=1; i<=6; i++){
            int num = nums[i];

            if(num==2){
                result = 1000 + i*100;
                break;
            }

            if(num==3){
                result = 10000+i*1000;
                break;
            }

            if(num==1 && (result<(i*100))){
                result=i*100;
            }
        }

        bw.write(result+"");

        bw.close();
        br.close();
    }
}
