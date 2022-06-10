import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class aAddB5 {

    //TODO 문제 ::두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
    //예제입력
    //입력은 여러 개의 테스트 케이스로 이루어져 있다.
    //각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
    //입력의 마지막에는 0 두 개가 들어온다.
    //1 1
    //2 3
    //3 4
    //9 8
    //5 2
    //0 0
    //예제출력
    //각 테스트 케이스마다 A+B를 출력한다.
    //2
    //5
    //7
    //17
    //7
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;

        while((input = br.readLine()) != null){
            String[] nums = input.split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);

            if(a==0 && b==0){
                break;
            }

            int result = a + b;
            bw.write(result+"");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
