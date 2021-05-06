package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class FindNumber_New {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] nArr = new int[N];
        String[] nElements = br.readLine().split(" ");
        for(int i=0; i<N;i++){
            nArr[i] = Integer.parseInt(nElements[i]);
        }

        int M = Integer.parseInt(br.readLine());
        int[] mArr = new int[M];
        String[] mElements = br.readLine().split(" ");
        for(int i=0; i<M;i++){
            mArr[i] = Integer.parseInt(mElements[i]);
        }

        Arrays.sort(nArr);

        for(int i=0; i<M; i++){
            int goalNum = mArr[i];

            int left = 0;
            int right = N-1;
            int mid ;
            int result = 0;

            while(left<=right){
                mid = (left+right)/2;

                if(nArr[mid]>goalNum){
                    right = mid-1;
                    continue;
                }

                if(nArr[mid]<goalNum){
                    left = mid+1;
                    continue;
                }

                result = 1;
                break;
            }

            bw.write(result+"\n");
        }

        br.close();
        bw.close();
    }
}
