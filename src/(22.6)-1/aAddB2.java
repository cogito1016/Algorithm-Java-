import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class aAddB2 {

    //TODO 문제 :: 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
    //예제입력 첫째 줄에 A, 둘째 줄에 B가 주어진다. (0 < A, B < 10)
    //1
    //2
    //예제출력 첫째 줄에 A+B를 출력한다.
    //3
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int result = a + b;

        bw.write(result+"");

        br.close();
        bw.close();
    }
}
