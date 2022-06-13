import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class ReversingWord {

    //TODO 문제 ::문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오. 단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.
    //예제입력
    //첫째 줄에 테스트 케이스의 개수 T가 주어진다.
    // 각 테스트 케이스는 한 줄로 이루어져 있으며, 문장이 하나 주어진다.
    // 단어의 길이는 최대 20, 문장의 길이는 최대 1000이다. 단어와 단어 사이에는 공백이 하나 있다.
    //2
    //I am happy today
    //We want to win the first prize
    //예제출력
    //각 테스트 케이스에 대해서, 입력으로 주어진 문장의 단어를 모두 뒤집어 출력한다.
    //I ma yppah yadot
    //eW tnaw ot niw eht tsrif ezirp
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        while(t-->0){ //N
            String[] sentences = br.readLine().split(" ");

            for(String word : sentences){ //단어의개수 50
                int wordLength = word.length();

                for(int i=0; i<wordLength; i++){//단어의길이 20
                    char c = word.charAt(i);
                    stack.push(c);
                }//fo end

                while(!stack.empty()){//단어의길이 20
                    bw.write(stack.pop());
                }//while end
                bw.write(" ");
            }//for end
            bw.newLine();
        }//while end

        br.close();
        bw.close();
    }
}
