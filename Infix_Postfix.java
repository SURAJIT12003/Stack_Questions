import java.util.*;

public class Infix_Postfix {

    /*
     * 
     * This is important problem --- Algorithm
     * infix = a + c
     * postfix = ac+ (operator will go at last)
      
     * operand = 1 2 3 ...
     * operator = * , / , - , + , ^ ...
     * operator precidency = (high to low) [ ^, (*,/) , (+,-) , ()]
      
     * 1) traverse left to right
      
     * 2) if(operand) - print
      
     * 3) if ( '(' ) [opening backet] - push into stack
      
     * 4) if( ')' ) [closing backet] - pop and print unitl stack top is [opening
      backet] ['(']
     
     * 5) if(operator) - pop and print until operator with less precidence found
      after push current operator
     
     * 6) At last traverse stack and print all remain characters
     
     */

    static HashMap<Character, Integer> precedence = new HashMap<>();

    public static String postFix(String s) {

        String ans = "";
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {

                while (!st.isEmpty()) {
                    if (st.peek() == '(') {
                        st.pop();
                        break;
                    }
                    ans = ans + st.peek();

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
                    ans = ans + c;
                    st.pop();
                }
                st.push(ch);

            } else {
                ans = ans + ch;
            }
        }

        while (!st.isEmpty()) {
            ans = ans + st.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        precedence.put('-', 5);
        precedence.put('+', 5);
        precedence.put('*', 10);
        precedence.put('/', 10);
        precedence.put('^', 20);
        precedence.put('(', 2);
        precedence.put(')', 2);

        System.out.println(postFix("(a-b/c) * (d/k - l)"));
    }
}
