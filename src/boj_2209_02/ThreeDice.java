package boj_2209_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ThreeDice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> dices = Arrays.stream(br.readLine().split(" "))
                .map((element)->Integer.parseInt(element))
                .collect(Collectors.toList());

        int size = dices.size();
        int maxCount = 0;
        int targetNum = 0;
        int maxNum = 0;

        for(int i=0; i<size; i++){
            int count = 0;
            int compareNum = dices.get(i);

            for(int j=0; j<size; j++){
                if(compareNum == dices.get(j)){
                    count++;
                }
            }

            if(count>maxCount){
                maxCount = count;
                targetNum = compareNum;
            }

            if(compareNum > maxNum){
                maxNum = compareNum;
            }
        }


        int result = 0;
        if(maxCount==3){
            result = 10000 + targetNum*1000;
        }else if(maxCount==2){
            result = 1000 + targetNum*100;
        }else{
            result = maxNum*100;
        }

        bw.write(result+"");

        br.close();
        bw.close();
    }
}
