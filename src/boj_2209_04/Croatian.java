package boj_2209_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Croatian {
    final static String[][] compareWordArr = {
            {"c","="},
            {"c","-"},
            {"d","z","="},
            {"d","-"},
            {"l","j"},
            {"n","j"},
            {"s","="},
            {"z","="}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int compareWordArrLen = compareWordArr.length;
        String[] word = br.readLine().split("");

        int changeWordNum = 0;

        for(int i=0; i<word.length; i++){
            for(int j=0; j<compareWordArrLen; j++){
                String[] c = compareWordArr[j];

                int compareWordLen = c.length;
                int startIdxNum = i;
                int equalsCount = 0;

                for(String alphabet : c){
                    if(startIdxNum==word.length){
                        break;
                    }

                    if(word[startIdxNum].equals(alphabet)) {
                        startIdxNum++;
                        equalsCount++;
                    }else{
                        break;
                    }
                }

                if(compareWordLen==equalsCount){
                    i = i+compareWordLen-1;
                    changeWordNum+=1;
                    break;
                }else if( (compareWordLen!=equalsCount) && (j==compareWordArrLen-1)){
                    changeWordNum+=1;
                }
            }
        }

        bw.write(changeWordNum+"");

        br.close();
        bw.close();
    }
}
