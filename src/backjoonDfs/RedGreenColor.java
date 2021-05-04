package backjoonDfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

class Node{
    int x;
    int y;
    Node(int y,int x){
        this.x=x;
        this.y=y;

    }
}

public class RedGreenColor {
    static int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};

    public static boolean runDfsAndGetIsDifferentArea(char[][] map, boolean[][] visited,int i, int j, char prevAreaColor){
        boolean isDifferentArea = false;

        int N = map[0].length;
        Stack<Node> stack = new Stack<>();
        stack.push(new Node(i,j));
        visited[i][j]=true;

        while(!stack.isEmpty()){
            Node presentNode = stack.pop();
            char currentColor = map[presentNode.y][presentNode.x];
            if(currentColor!=prevAreaColor){
                isDifferentArea = true;
                prevAreaColor=currentColor;
            }

            for(int k=0; k<4; k++){
                int x = direction[k][1] + presentNode.x;
                int y = direction[k][0] + presentNode.y;

                if(x>=N || y>=N || x<0 || y<0){
                    continue;
                }
                if(visited[y][x]){
                    continue;
                }
                if(map[y][x]!=currentColor){
                    continue;
                }
                visited[y][x]=true;
                stack.push(new Node(y,x));
            }
        }
        return isDifferentArea;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        char[][] redGreenMap = new char[N][N];
        boolean[][] visited = new boolean[N][N];

        int areaCnt = 0;
        int redGreenCnt = 0;

        final char IS_NOT_COLOR = '~';
        char prevAreaColor = IS_NOT_COLOR;

        for(int i=0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<N; j++){
                char c = s.charAt(j);
                map[i][j] = c;

                if(c=='G'){
                    c='R';
                }
                redGreenMap[i][j]=c;
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]){
                    continue;
                }

                if(runDfsAndGetIsDifferentArea(map, visited, i, j, prevAreaColor)){
                    areaCnt++;
                }

                prevAreaColor=IS_NOT_COLOR;
            }
        }

        for(int i=0; i<N; i++){
            Arrays.fill(visited[i],false);
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(visited[i][j]){
                    continue;
                }

                if(runDfsAndGetIsDifferentArea(redGreenMap, visited, i, j, prevAreaColor)){
                    redGreenCnt++;
                }

                prevAreaColor=IS_NOT_COLOR;
            }
        }

        bw.write(areaCnt+" ");
        bw.write(redGreenCnt+"\n");

        br.close();
        bw.close();
    }
}
