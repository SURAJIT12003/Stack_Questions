
import java.util.*;

public class Valid_paren {

    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            //Step 1 - if opening backet then add is stack 
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } 

            //Step 3 - for closing backet 
            else {

                //if stack is empty means any opening backet not present

                if (st.isEmpty()) {
                    return false;
                }

                //Step 4 - if stack peek is opening backet than remove it 

                if ((ch == ')' && st.peek() == '(') ||
                        (ch == '}' && st.peek() == '{') ||
                        (ch == ']' && st.peek() == '[')) {
                    st.pop();
                } 
                //Step 5 - other not valid parenthis 
                else {
                    return false;
                }

            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s="()()))())(()(((()))";
        // System.out.println(isValid(s));
        String str = "Hello, world! This is a test string.";
        System.out.println(s.length());
        StringBuffer result = new StringBuffer();
        for (char c : str.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                result.append(c);
            }
        }

        System.out.println(result);
        
    }
}
