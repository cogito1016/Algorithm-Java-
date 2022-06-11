
//TODO 문제 ::정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Stack{
    private int index;//Next target index
    private int[] arr = new int[10000];

    public void push(int value){
        this.arr[index] = value;
        index++;
    }

    public int pop(){
        int result = -1;
        if(index!=0){
            index--;
            result = this.arr[index];
            this.arr[index]=0;
        }
        return result;
    }

    public int size(){
        return index;
    }

    public int empty(){
        return index==0?1:0;
    }

    public int top(){
        return index==0?-1:this.arr[index-1];
    }
}

public class StackImpl {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack stack = new Stack();

        while(n-->0){
            String[] statement = br.readLine().split(" ");
            String instruction = statement[0];

            if(instruction.equals("push")){
                int value = Integer.parseInt(statement[1]);
                stack.push(value);
                continue;
            }

            if(instruction.equals("pop")){
                bw.write(stack.pop()+"");
                bw.newLine();
                continue;
            }

            if(instruction.equals("size")){
                bw.write(stack.size()+"");
                bw.newLine();
                continue;
            }

            if(instruction.equals("empty")){
                bw.write(stack.empty()+"");
                bw.newLine();
                continue;
            }

            if(instruction.equals("top")){
                bw.write(stack.top()+"");
                bw.newLine();
                continue;
            }
        }

        br.close();
        bw.close();
    }
}
