package boj_2209_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CheerUpSlugRefactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        double A = Double.parseDouble(s[0]);
        double B = Double.parseDouble(s[1]);
        double V = Double.parseDouble(s[2]);

        double day = Math.ceil((V-A)/(A-B))+1;

        bw.write((int) day+"");

        br.close();
        bw.close();
    }
}
