package boj_2209_04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FindBoonsuXD {

    enum Direction{TOP, BOTTOM};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int top = 0;
        int bottom = 1;
        Direction topBottomSwitch = Direction.TOP;

        while(N-->0){
            if(topBottomSwitch==Direction.TOP){
                if(bottom==1){
                    top++;
                    topBottomSwitch = Direction.BOTTOM;
                }else{
                    top++;
                    bottom--;
                }
            }else if(topBottomSwitch==Direction.BOTTOM){
                if(top==1){
                    bottom++;
                    topBottomSwitch = Direction.TOP;
                }else{
                    bottom++;
                    top--;
                }
            }
        }

        bw.write(top+"/"+bottom);

        br.close();
        bw.close();
    }
}
