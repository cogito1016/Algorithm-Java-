package backjoonStack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BasicStack {

    static boolean stackIsEmpty(int currentIdx){
        return currentIdx-1 < 0 ? true : false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int currentIdx = 0;
        int[] stack = new int[n];

        while(n-->0){
            String[] command = br.readLine().split(" ");
            String request =  command[0];

            if(request.equals("push")){
                int number = Integer.parseInt(command[1]);
                stack[currentIdx] = number;
                currentIdx++;
            }

            if(request.equals("pop")){
                if(stackIsEmpty(currentIdx)){
                    bw.write(-1+"\n");
                }else{
                    currentIdx--;
                    bw.write(stack[currentIdx]+"\n");
                }
            }

            if(request.equals("size")){
                bw.write(currentIdx+"\n");
            }

            if(request.equals("empty")){
                bw.write((currentIdx==0?1:0)+"\n");
            }

            if(request.equals("top")){
                if(stackIsEmpty(currentIdx)){
                    bw.write(-1+"\n");
                }else{
                    bw.write(stack[currentIdx-1]+"\n");
                }
            }
        }

        bw.close();
        br.close();
    }
}
