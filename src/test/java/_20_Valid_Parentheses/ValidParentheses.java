package _20_Valid_Parentheses;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class ValidParentheses {

    @Test
    public void test(){
        assertEquals(true, isValid("()[]{}"));
        assertEquals(false, isValid("(}"));
        assertEquals(true, isValid("{[]}"));
        assertEquals(false, isValid("{[}]"));
        assertEquals(false, isValid("(("));
        assertEquals(false, isValid("("));
        assertEquals(false, isValid("]"));
        assertEquals(false, isValid("){"));
    }

    Map<Character, Character> linkMap = new HashMap<Character, Character>() {{
        put('{', '}');
        put('(', ')');
        put('[', ']');
    }};

    public boolean isValid(String s){
        if(s.length() < 2)
            return false;

        char[] chars = s.toCharArray();
        Stack<Character> charStack = new Stack<>();
        for(char c : chars){
            if(linkMap.containsKey(c)){
                charStack.push(c);
            } else {
                Character popChar = charStack.empty() ? null : charStack.pop();
                if(popChar == null || !linkMap.get(popChar).equals(c)){
                    return false;
                }
            }
        }
        return charStack.empty();
    }

    /**
     * Intuition
     * The problem requires us to determine if the given string of brackets is valid or not.
     * We can use a stack data structure to keep track of opening brackets encountered and check
     * if they match with the corresponding closing brackets.
     *
     * Approach
     * Here is the step-by-step approach of the algorithm:
     *
     * Initialize an empty stack.
     *
     * Traverse the input string character by character.
     *
     * If the current character is an opening bracket (i.e., '(', '{', '['), push it onto the stack.
     *
     * If the current character is a closing bracket (i.e., ')', '}', ']'),
     * check if the stack is empty. If it is empty, return false, because the closing bracket does not have a corresponding opening bracket.
     * Otherwise, pop the top element from the stack and check if it matches the current closing bracket.
     * If it does not match, return false, because the brackets are not valid.
     *
     * After traversing the entire input string, if the stack is empty, return true,
     * because all opening brackets have been matched with their corresponding closing brackets.
     * Otherwise, return false, because some opening brackets have not been matched with their corresponding closing brackets.
     *
     * Complexity
     * Time complexity:
     * The time complexity of the solution is O(n)O(n)O(n), where n is the length of the input string.
     * This is because we traverse the string once and perform constant time operations for each character.
     *
     * Space complexity:
     * The space complexity of the solution is O(n)O(n)O(n), where n is the length of the input string.
     * This is because the worst-case scenario is when all opening brackets are present in the string and the stack will have to store them all.
     *
     */

    // from solutions
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>(); // create an empty stack
        for (char c : s.toCharArray()) { // loop through each character in the string
            if (c == '(') // if the character is an opening parenthesis
                stack.push(')'); // push the corresponding closing parenthesis onto the stack
            else if (c == '{') // if the character is an opening brace
                stack.push('}'); // push the corresponding closing brace onto the stack
            else if (c == '[') // if the character is an opening bracket
                stack.push(']'); // push the corresponding closing bracket onto the stack
            else if (stack.isEmpty() || stack.pop() != c) // if the character is a closing bracket
                // if the stack is empty (i.e., there is no matching opening bracket) or the top of the stack
                // does not match the closing bracket, the string is not valid, so return false
                return false;
        }
        // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
        // so the string is valid, otherwise, there are unmatched opening brackets, so return false
        return stack.isEmpty();
    }
}
