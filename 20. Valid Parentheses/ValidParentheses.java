import java.util.Stack;

public class ValidParentheses {
 
    public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        if (s.length()%2 != 0) { 
            return false;
        }
        for (int i = 0; i <s.length() ; i++) {
            Character c = s.charAt(i);
            if (c == 91 || c==123 || c == 40) {
                stk.push(c);
            } else {
                if (stk.isEmpty()) {
                    return false;
                }
                Character stackPeek = stk.pop();
                if (stackPeek != null) {
                    if (c==125 && stackPeek==123) {
                        continue;
                    } else if (c==41 && stackPeek == 40) {
                        continue;
                    } else if (c==93 && stackPeek == 91) {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (stk.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(ValidParentheses.isValid("(){}{{{"));
    }
}
