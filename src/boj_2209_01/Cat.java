package boj_2209_01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Cat {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("\\    /\\\n" +
                " )  ( ')\n" +
                "(  /  )\n" +
                " \\(__)|");
        bw.close();
    }
}
