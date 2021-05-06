package backjoonBinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class NumberCard_New {
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

        int left = 0 ;
        int right = N-1;
        int mid = 0;
        int goal;
        int midValue;
        int result;

        for(int i=0; i<M; i++){
            left = 0;
            right = N-1;
            goal = mArr[i];
            result = 0;

            while(left<=right){
                mid = (left+right)/2;
                midValue = nArr[mid];

                if(midValue<goal){
                    left = mid+1;
                    continue;
                }

                if(midValue>goal){
                    right = mid-1;
                    continue;
                }

                result = 1;
                break;
            }

            if(result==1){
                int originMid = mid;

                boolean existLeftValue = false;
                boolean existRightValue = false;

                int leftIdx =0;
                left = 0;
                right = originMid-1;
                while(left<=right){
                    mid = (left+right)/2;
                    midValue = nArr[mid];

                    if(midValue<goal){
                        left = mid+1;
                        continue;
                    }

                    if(midValue==goal){
                        leftIdx = mid;
                        existLeftValue=true;
                    }

                    if(midValue>=goal){
                        right = mid-1;
                        continue;
                    }

                    break;
                }


                int rightIdx =0;
                left = originMid+1;
                right = N-1;
                while(left<=right){
                    mid = (left+right)/2;
                    midValue = nArr[mid];

                    if(midValue>goal){
                        right = mid-1;
                        continue;
                    }

                    if(midValue==goal){
                        rightIdx = mid;
                        existRightValue=true;
                    }

                    if(midValue<=goal){
                        left = mid+1;
                        continue;
                    }

                    break;
                }

                if(existLeftValue){
                    result += originMid - leftIdx;
                }
                if(existRightValue){
                    result += rightIdx - originMid;
                }
            }

            bw.write(result+"\n");
        }

        br.close();
        bw.close();
    }
}
