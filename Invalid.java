import java.util.ArrayList;
import java.util.Stack;

public class Invalid {

    public static boolean check(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // Step 1 - if opening backet then add is stack
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }

            // Step 3 - for closing backet
            else {

                // if stack is empty means any opening backet not present

                if (st.isEmpty()) {
                    return false;
                }

                // Step 4 - if stack peek is opening backet than remove it

                if ((ch == ')' && st.peek() == '(') ||
                        (ch == '}' && st.peek() == '{') ||
                        (ch == ']' && st.peek() == '[')) {
                    st.pop();
                }
                // Step 5 - other not valid parenthis
                else {
                    return false;
                }

            }
        }

        return st.isEmpty();
    }

    public static void rec(String s, StringBuffer str, int i, ArrayList<String> ans) {
        if (i == s.length()) {
            if (check(str.toString())) {
                ans.add(str.toString());
            }
       
            return;
        }

        // take

        str.append(s.charAt(i));
        rec(s, str, i + 1, ans);

        str.deleteCharAt(str.length()-1);

        rec(s, str, i + 1, ans);
    }

    public static ArrayList<String> removeInvalidParentheses(String s) {
        ArrayList<String> ans = new ArrayList<>();
        StringBuffer st = new StringBuffer();
        rec(s, st, 0, ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "()())()";
        ArrayList<String> ans = removeInvalidParentheses(s);
        System.out.println(ans);
    }
}
