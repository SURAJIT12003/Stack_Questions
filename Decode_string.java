package Stack_Apna_College;

import java.util.*;

public class Decode_string {

    public static String decode(String str) {
        // Step 1 = create integer stck and string stack
        Stack<Integer> st = new Stack<>();

        Stack<String> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ']') {
                int count = st.pop();
                StringBuffer d = new StringBuffer();
                while (!s.isEmpty()) {
                    if (s.peek().equals("[")) {
                        s.pop();
                        break;
                    }

                    d.insert(0, s.peek());
                    s.pop();

                }
                int j = 0;
                String g = d.toString();
                while (j + 1 != count) {
                    d.append(g);
                    j++;
                }

                s.push(d.toString());
                System.out.println(s);
                continue;

            }
            if (ch >= '0' && ch <= '9') {
                st.push(ch - '0');
                // System.out.println(st.peek());
            } else {
                s.push(Character.toString(ch));
            }

        }
        StringBuffer ans = new StringBuffer();
        while (!s.isEmpty()) {
            ans.insert(0, s.pop());
        }

        return ans.toString();
    }

    public static void main(String[] args) {

        System.out.println(decode("3[a2[c]]"));
    }
}
