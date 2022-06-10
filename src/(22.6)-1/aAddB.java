import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class aAddB {

    //TODO 문제 :: 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.
    //예제입력
    //1 2
    //예제출력
    //3

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int result = a + b;

        bw.write(result+"");

        br.close();
        bw.close();
    }
}
