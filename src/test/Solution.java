package test;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'prison' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. INTEGER_ARRAY h
     *  4. INTEGER_ARRAY v
     */
    static class Node{
        int x,y;
        Node(int y,int x){
            this.x=x;
            this.y=y;
        }//cons end
    }//Node class end

    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
    // Write your code here
        long result = 0;

        boolean[][] visited = new boolean[m+1][n+1];
        int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};

        Queue<Node> outerQueue = new LinkedList<Node>();
        Queue<Node> innerQueue = new LinkedList<Node>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                outerQueue.offer(new Node(i,j)); 
            }//for end
        }//for end

        while(!outerQueue.isEmpty()){
            Node outerNode = outerQueue.poll();
            if(visited[outerNode.y][outerNode.x])
                continue;
            visited[outerNode.y][outerNode.x]=true;

            int tempResult = 1;
            innerQueue.offer(outerNode);
            while(!innerQueue.isEmpty()){
                Node innerNode = innerQueue.poll();
                for(int i=0;i<4;i++){
                    int thisX = innerNode.x+direct[i][1];
                    int thisY = innerNode.y+direct[i][0];
                    if(thisY>=m+1 || thisY<0 || thisX>=n+1 || thisX<0)
                        continue;
                    if(visited[thisY][thisX])
                        continue;
                    if( (v.contains(thisX)&&thisY==innerNode.y ) || (h.contains(thisY)&&thisX==innerNode.x )){
                        innerQueue.offer(new Node(thisY,thisX));
                        visited[thisY][thisX]=true;
                        tempResult++;
                    }
                }//for end
            }//while end
            if(tempResult>result)
                result=tempResult;
        }//while end

        return result;
    }//prison() end

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        int hCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> h = IntStream.range(0, hCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int vCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> v = IntStream.range(0, vCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.prison(n, m, h, v);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
