package boj_2209_04;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class SelfNumber {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] selfNumberArr = new int[10001];

        for(int i=1; i<=10000; i++){
            String fullNumber = (i+"");
            String[] splitedNumber = fullNumber.split("");
            int result = Integer.parseInt(fullNumber);

            for(int j=0; j<splitedNumber.length; j++){
                result += Integer.parseInt(splitedNumber[j]);
            }

            if(result>10000){
                continue;
            }

            selfNumberArr[result]++;
        }

        for(int i=1; i<=10000; i++){
            if(selfNumberArr[i]==0){
                bw.write(i+"");
                bw.newLine();
            }
        }

        bw.close();
    }
}
