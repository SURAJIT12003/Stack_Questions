import java.util.HashMap;
import java.util.Stack;

public class Infix_Prefix {
    
    /*
     * this is same rule as (Infix to postfix )
     ** here extra change first input string reverse and after after reversing
     * opening backet to closing backet [vice - versa]
     * when return answer then reverse and return answer
     * 
     */

    static HashMap<Character, Integer> precedence = new HashMap<>();

    public static String Prefix(String s) {

        StringBuffer newString = new StringBuffer();
        newString.append(s);
        newString.reverse();        //reverse input string 
        for (int i = 0; i < newString.length(); i++) {
            if (newString.charAt(i) == '(') {
                newString.setCharAt(i, ')');    // change '(' to ')' AND ')' to '('
            } else if (newString.charAt(i) == ')') {
                newString.setCharAt(i, '(');
            }
        }
     
       StringBuffer ans = new StringBuffer();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < newString.length(); i++) {
            char ch = newString.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {

                while (!st.isEmpty()) {
                    if (st.peek() == '(') {
                        st.pop();
                        break;
                    }
                    ans.append(st.peek());

                    st.pop();
                }
            } else if (ch == '^' || ch == '*' || ch == '-' || ch == '+' || ch == '/') {
                int op = precedence.get(ch);
                while (!st.isEmpty()) {
                    char c = st.peek();
                    int p = precedence.get(c);
                    if (op > p) {
                        break;
                    }
                    ans.append(c);
                    st.pop();
                }
                st.push(ch);

            } else {
                ans.append(ch);
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        
        ans.reverse(); // answer string reverse and return 
        
        return ans.toString();
    }

    public static void main(String[] args) {

        precedence.put('-', 5);
        precedence.put('+', 5);
        precedence.put('*', 10);
        precedence.put('/', 10);
        precedence.put('^', 20);
        precedence.put('(', 2);
        precedence.put(')', 2);

        String s = "(a-b/c) * (d/k - l)";

        System.out.println(Prefix(s));

    }
}
