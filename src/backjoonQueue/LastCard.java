package backjoonQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

public class LastCard {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for(int i=1 ;i<=n;i++){
            deque.addFirst(i);
        }

        while(deque.size()!=1){
            deque.removeLast();
            deque.addFirst(deque.removeLast());
        }

        bw.write(deque.getFirst()+"\n");

        bw.close();
        br.close();
    }
}
