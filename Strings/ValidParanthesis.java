package Strings;

import java.util.Stack;

public class ValidParanthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }else{
                char top = stack.pop();
                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        
    }
}
