package backjoonStack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class ParenthesisString {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        while(n-->0){
            Stack<Character> stack = new Stack<>();
            String inputLine = br.readLine();

            for(int i =0; i<inputLine.length(); i++){
                char character = inputLine.charAt(i);

                if(stack.empty()){
                    stack.push(character);
                    continue;
                }

                if(character==')' && stack.peek().equals('(')){
                    stack.pop();
                }else{
                    stack.push(character);
                }
            }
            bw.write(stack.isEmpty()?"YES\n":"NO\n");
        }

        br.close();
        bw.close();
    }
}
