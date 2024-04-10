

import java.util.*;


public class Duplicate_Paren {

    //Duplicate pranthesis -- time  - 0(n) ... Question link - https://www.codingninjas.com/codestudio/problems/duplicate-parenthesis_2663296?leftPanelTab=0
    public static boolean dupParen(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == ')') {

                //if st peek is contains closing that mean this is duplicate in closing or opening between no opartor ,oparend not present;***
                if (st.peek() == '(') {
                    return true;
                }

                //if not preset that mean any character presnt (oparend,oprator)**
                while (!st.isEmpty()) {
                    if (st.peek() == '(') {
                        st.pop();
                        break;
                    }
                    st.pop();
                }
            } 
            else {
                st.push(ch);
            }
        }

        if (st.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
       
        System.out.println(dupParen("(b+c-d+(c))"));
    }
}
