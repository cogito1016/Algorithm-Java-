package boj_2209_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GroupWord {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int result = N;

        while(N-->0){
            boolean[] wordChecker = new boolean[26];
            String[] s = br.readLine().split("");
            int sLen = s.length;

            for(int i=0; i<sLen; i++){
                int idx = s[i].charAt(0)-97;

                if(wordChecker[idx] && !(s[i].equals(s[i-1]))){
                    result--;
                    break;
                }

                wordChecker[idx] = true;
            }
        }

        bw.write(result+"");

        br.close();
        bw.close();
    }
}
