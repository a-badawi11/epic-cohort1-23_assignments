/** Assignment #5: Valid parentheses **/

import java.util.*;

public class Assignment5 {

    public static void main(String[] args) {

        String[] testCases = {"(())", "))((", "((((((", ")()"};
        Arrays.asList(testCases).forEach(t -> System.out.println("isValid(\""+t+"\") = " + isValid(t)));

    }

    public static boolean isValid(String data) {
        Stack<Character> stack = new Stack<>();
        for(Character c : data.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            }
            else if (stack.isEmpty() || stack.pop() == ')') {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
