package backjoonBfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int x;
    int y;
    Node(int y, int x){
        this.x=x;
        this.y=y;
    }
}

public class ChessKnightMoving {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseNum = Integer.parseInt(br.readLine());

        int[][] direction = {{-1,-2}, {-2,-1}, {-1,2}, {-2,1}, {1,-2}, {2,-1}, {2,1}, {1,2}};

        while(testCaseNum-->0){
            Queue<Node> queue = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[N][N];

            String[] kniteLoc = br.readLine().split(" ");
            int startY = Integer.parseInt(kniteLoc[0]);
            int startX = Integer.parseInt(kniteLoc[1]);

            String[] goalLoc = br.readLine().split(" ");
            int goalY = Integer.parseInt(goalLoc[0]);
            int goalX = Integer.parseInt(goalLoc[1]);

            queue.offer(new Node(startY,startX));
            visited[startY][startX] = true;

            int moveCnt = -1;
            boolean isDone = false;

            while(!queue.isEmpty()){
                if(isDone){
                    break;
                }

                int queueSize = queue.size();
                moveCnt++;
                for(int i=0;i<queueSize;i++){
                    Node presentNode = queue.poll();

                    if(presentNode.y==goalY && presentNode.x==goalX){
                        isDone=true;
                        break;
                    }

                    for(int j=0; j<8; j++){
                        int y = presentNode.y + direction[j][0];
                        int x = presentNode.x + direction[j][1];

                        if(x>=N || y>=N || x<0 || y<0){
                            continue;
                        }
                        if(visited[y][x]){
                            continue;
                        }

                        visited[y][x] = true;
                        queue.offer(new Node(y,x));
                    }
                }
            }

            bw.write(moveCnt+"\n");
        }

        br.close();
        bw.close();
    }
}
