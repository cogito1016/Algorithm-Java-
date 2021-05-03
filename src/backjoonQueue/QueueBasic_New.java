package backjoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class QueueBasic_New {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int stateCnt= n;
        int front = 0;
        int totalCnt = 0;
        int back = 0;
        int[] queue = new int[n];

        while(stateCnt-->0){
            String[] statement = br.readLine().split(" ");
            String order = statement[0];

            if(order.equals("push")){
                if(totalCnt==n){
                    bw.write(-1+"\n");
                }else{
                    int parameter = Integer.parseInt(statement[1]);
                    queue[back%n] = parameter;
                    back++;
                    totalCnt++;
                }
                continue;
            }

            if(order.equals("pop")){
                if(totalCnt==0){
                    bw.write(-1+"\n");
                }else{
                    bw.write(queue[front%n]+"\n");
                    front++;
                    totalCnt--;
                }
                continue;
            }

            if(order.equals("size")){
                bw.write(totalCnt+"\n");
                continue;
            }

            if(order.equals("empty")){
                bw.write((totalCnt==0?1:0)+"\n");
                continue;
            }

            if(order.equals("front")){
                if(totalCnt==0){
                    bw.write(-1+"\n");
                }else{
                    bw.write(queue[front%n]+"\n");
                }
                continue;
            }

            if(order.equals("back")){
                if(totalCnt==0){
                    bw.write(-1+"\n");
                }else{
                    bw.write(queue[back-1%n]+"\n");
                }
                continue;
            }
        }

        bw.close();
        br.close();
    }
}
