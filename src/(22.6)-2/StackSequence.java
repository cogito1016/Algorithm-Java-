import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class StackSequence {

    //TODO 문제 ::1부터 n까지의 수를 스택에 넣었다가 뽑아 늘어놓음으로써, 하나의 수열을 만들 수 있다. 이때, 스택에 push하는 순서는 반드시 오름차순을 지키도록 한다고 하자.
    // 임의의 수열이 주어졌을 때 스택을 이용해 그 수열을 만들 수 있는지 없는지,
    // 있다면 어떤 순서로 push와 pop 연산을 수행해야 하는지를 알아낼 수 있다.
    // 이를 계산하는 프로그램을 작성하라.
    //예제입력
    //첫 줄에 n (1 ≤ n ≤ 100,000)이 주어진다. 둘째 줄부터 n개의 줄에는 수열을 이루는 1이상 n이하의 정수가 하나씩 순서대로 주어진다. 물론 같은 정수가 두 번 나오는 일은 없다.
    //예제출력
    //입력된 수열을 만들기 위해 필요한 연산을 한 줄에 한 개씩 출력한다. push연산은 +로, pop 연산은 -로 표현하도록 한다. 불가능한 경우 NO를 출력한다.

    //핵심 push순서는 오름차순
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder st = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] sequence = new int[n];
        int sequenceIdx = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<n; i++){
            sequence[i] = Integer.parseInt(br.readLine());
        }//N


        for(int i=1; i<=n; i++){
            stack.push(i);
            st.append("+\n");

            while(!stack.empty()){
                if(stack.peek()==sequence[sequenceIdx]){
                    stack.pop();
                    st.append("-\n");
                    sequenceIdx++;
                }else{
                    break;
                }
            }
        }//N

        if(sequenceIdx!=n){
            st.delete(0,st.length());
            st.append("NO");
        }

        bw.write(st.toString());

        br.close();
        bw.close();
    }
}
