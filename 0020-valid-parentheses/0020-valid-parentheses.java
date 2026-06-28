import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        // Fix 1: Stack ka type Character kiya
        Stack<Character> stack = new Stack<>(); 
        
        // Fix 2: Loop ko index 0 se shuru kiya
        for(int i = 0 ; i < s.length() ; i++) {
            char bracket = s.charAt(i); 

            // Fix 3: Switch block ko loop ke andar laya
            switch(bracket) {
                case '{':
                case '[':
                case '(':
                    stack.push(bracket);
                    break;

                // Fix 4: Closing brackets ke cases sahi kiye aur pop() lagaya
                case ')':
                    if(stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break; // Break lagana zaroori hai

                case ']':
                    if(stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;

                case '}':
                    if(stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
            } // Switch ka end
        } // Loop ka end

        return stack.isEmpty();
    }
}
