package boj_2210_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class BigNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");

        //int : -21억 ~ +21억
        //long : -2^63 ~ +2^63
        //-9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807
        BigInteger result = new BigInteger(s[0]).add(new BigInteger(s[1]));
        bw.write(result+"");

        br.close();
        bw.close();
    }
}
