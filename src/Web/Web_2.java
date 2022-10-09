package Web;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Web_2 {
    enum Rule{BIG,MID,SMALL}
    public static int[] solution(String[] pars) {
        int parsLen = pars.length;
        int[] answer = new int[parsLen];

        Map<Character, Character> table = new HashMap<>();
        table.put(')','(');
        table.put('}','{');
        table.put(']','[');

        for(int sIdx=0; sIdx<parsLen; sIdx++){
            String s = pars[sIdx];

            Stack<Character> stack = new Stack<>();

            int sLen = s.length();

            Rule rule = null;
            Rule prevRule = Rule.BIG;

            for(int i=0; i<sLen; i++){

                char c = s.charAt(i);

                rule = getRule(c);

                if(stack.empty()){
                    stack.push(c);
                    prevRule = rule;
                    continue;
                }

                if( (prevRule.equals(Rule.SMALL) && rule.equals(Rule.MID)) ||
                        (prevRule.equals(Rule.SMALL) && rule.equals(Rule.BIG)) ||
                        (prevRule.equals(Rule.MID) && rule.equals(Rule.BIG)) ){
                    answer[sIdx] = 0;
                    break;
                }

                Character peek = stack.peek();

                if(peek.equals(table.get(c))){
                    stack.pop();
                    if(!stack.isEmpty()){
                        prevRule = getRule(stack.peek());
                    }else{
                        prevRule = Rule.BIG;
                    }
                    continue;
                }

                stack.push(c);
                prevRule = rule;
            }

            if(!stack.empty()){
                answer[sIdx] = 0;
            }else{
                answer[sIdx] = 1;
            }
        }

        return answer;
    }

    public static Rule getRule(Character c){
        Rule rule = null;

        if(c=='(' || c==')'){
            rule = Rule.SMALL;
        }else if(c=='{' || c=='}'){
            rule = Rule.MID;
        }else if(c=='[' || c==']'){
            rule = Rule.BIG;
        }

        return rule;
    }

    public static void main(String[] args) {
        String[] parse = {"([])","{[]()}","[(){{()}}]","({()})"};
        //0 0 1 0
        int[] result = solution(parse);
        for (int i : result){
            System.out.println(i);
        }
    }
}
