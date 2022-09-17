package boj_2209_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ThreeDice_Refactor_DP1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[7];

        Arrays.stream(br.readLine().split(" "))
                .forEach((element)-> nums[Integer.parseInt(element)]++);

        int resultThree = 0;
        int resultTwo = 0;
        int resultOne = 0;

        for(int i=1; i<=6; i++){
            int num = nums[i];

            if(num==3){
                resultThree = 10000+i*1000;
                break;
            }else if(num==2){
                resultTwo = 1000 + i*100;
            }else if(num==1 && (resultOne<(i*100))){
                resultOne=i*100;
            }
        }

        if(resultThree!=0){
            bw.write(resultThree+"");
        }else if(resultTwo!=0){
            bw.write(resultTwo+"");
        }else{
            bw.write(resultOne+"");
        }

        bw.close();
        br.close();
    }
}
