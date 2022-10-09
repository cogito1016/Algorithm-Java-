package Web;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Web_1 {

    public static int[] solution(int[] ball, int[] order) {
        int arrLen = order.length;
        List<Integer> answerList = new ArrayList<>();

        int[] answer = new int[arrLen];

        Deque<Integer> deque = new ArrayDeque<>(); //통
        Map<Integer, Integer> map = new HashMap<>(); //우선순위 Check

        for(int number : ball){
            deque.addFirst(number);
        }

        int idx = 0; //다음 체크할 Order Index
        int mapSize = map.size(); //우선순위 맵에 변동사항이 있으면 While을 실행하여 양 끝점 재 체크

        while(!deque.isEmpty()){
            int number = order[idx];
            int first = deque.getFirst();
            int last = deque.getLast();

            mapSize = map.size();
            Integer firstMapNumber = map.get(first);
            Integer lastMapNumber = map.get(last);

            while( !(firstMapNumber==null && lastMapNumber==null) ){
                if(firstMapNumber!=null && lastMapNumber==null){
                    answerList.add(deque.removeFirst());
                    map.remove(first);
                }else if(firstMapNumber==null && lastMapNumber!=null){
                    answerList.add(deque.removeLast());
                    map.remove(last);
                }else if(firstMapNumber!=null && lastMapNumber!=null){
                    if (firstMapNumber<lastMapNumber){
                        answerList.add(deque.removeFirst());
                        map.remove(first);

                        answerList.add(deque.removeLast());
                        map.remove(last);
                    }else{
                        answerList.add(deque.removeLast());
                        map.remove(last);

                        answerList.add(deque.removeFirst());
                        map.remove(first);
                    }
                }

                firstMapNumber = map.get(first);
                lastMapNumber = map.get(last);
            }


            if(mapSize != map.size()){
                continue;
            }

            if (number == first) {
                answerList.add(deque.removeFirst());
                continue;
            }else if(number == last){
                answerList.add(deque.removeLast());
                continue;
            }

            map.put(number, idx++);
        }

        for(int i=0; i<arrLen; i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
//        int[] ball = {1,2,3,4,5,6};
//        int[] order = {6,2,5,1,4,3};
//        int[] result = solution(ball, order);
//
//        for(int i : result){
//            System.out.println(i);
//        }


       int[]  ball = {11,2,9,13,24};
        int[] order = {9,2,13,24,11};
        int[] result = solution(ball, order);
                for(int i : result){
            System.out.println(i);
        }
    }
}
