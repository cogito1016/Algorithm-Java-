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




public class Solution2 {
	static class Result {

	    /*
	     * Complete the 'closestStraightCity' function below.
	     *
	     * The function is expected to return a STRING_ARRAY.
	     * The function accepts following parameters:
	     *  1. STRING_ARRAY c
	     *  2. INTEGER_ARRAY x
	     *  3. INTEGER_ARRAY y
	     *  4. STRING_ARRAY q
	     */

	    public static List<String> closestStraightCity(List<String> c, List<Integer> x, List<Integer> y, List<String> q) {
	    // Write your code here
	        List<String> result = new ArrayList<String>();

	        //X좌표로 맵을 함.  Map< X좌표, Map< Y좌표, 도시이름 >
	        Map<Integer, Map<Integer,String>> map = new ConcurrentHashMap<Integer,Map<Integer,String>>();

	        //만약 맵의 X좌표키 내의 맵의 Y좌표키가 이미있으면 도시이름중 알파벳이 더 빠른걸로 교체, 아니면 그대로
	        //그렇다면  X좌표로 접근하는 맵에는, 각 Y좌표키-도시이름으로 매핑이 되어있을 것
	        for(int i=0;i<c.size();i++){
	            int xLoc = x.get(i);
	            int yLoc = y.get(i);
	            if(map.containsKey(xLoc)){
	                if(map.get(xLoc).containsKey(yLoc)){
	                    if(map.get(xLoc).get(yLoc).compareTo(c.get(i))>0)
	                        map.get(xLoc).put(yLoc,c.get(i));
	                }else{
	                    map.get(xLoc).put(yLoc,c.get(i));
	                }//if~else end
	            }else{
	                map.put(xLoc,new ConcurrentHashMap<Integer,String>());
	                map.get(xLoc).put(yLoc,c.get(i));
	            }//if~else end
	        }//for end

	        //City 노드 (y좌표, x좌표, 도시이름)을 통해 제일 가까운 도시들을 맵에 접근하여 얻어오면 될 듯.
	        for(int i=0;i<c.size();i++){
	            String name = c.get(i);
	            int xLoc = x.get(i);
	            int yLoc = y.get(i);

	            int sub = 1000000000;
	            Iterator iterator = map.get(xLoc).keySet().iterator();
	            while(iterator.hasNext()){
	                int targetKey = (int)iterator.next();
	                int tempSub = Math.abs(targetKey-yLoc);
	                if((tempSub != 0) && (tempSub<sub))
	                    sub=tempSub;
	            }//while end
	            result.add(map.get(xLoc).get(sub));
	        }//for end
	        return result;
	    }//closestStraightCity() end

	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int cCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> c = IntStream.range(0, cCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int xCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> x = IntStream.range(0, xCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int yCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> y = IntStream.range(0, yCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int qCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> q = IntStream.range(0, qCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.closestStraightCity(c, x, y, q);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
