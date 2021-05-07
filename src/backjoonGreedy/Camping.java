package backjoonGreedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Camping {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] inputs;
        int L = -1;
        int P = -1;
        int V = -1;
        int caseCnt = 0;
        int result = 0;

        inputs = br.readLine().split(" ");
        L = Integer.parseInt(inputs[0]);
        P = Integer.parseInt(inputs[1]);
        V = Integer.parseInt(inputs[2]);

        while(L!=0 && P!=0 && V!=0){
            caseCnt++;

            result = (V/P)*L;
            result += (V%P)>L ? L : V%P;

            bw.write("Case "+caseCnt+": "+result+"\n");

            inputs = br.readLine().split(" ");
            L = Integer.parseInt(inputs[0]);
            P = Integer.parseInt(inputs[1]);
            V = Integer.parseInt(inputs[2]);
        }

        br.close();
        bw.close();
    }
}
