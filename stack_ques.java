package Stack_Apna_College;

import java.util.*;

public class stack_ques {

    // Push at bottom new element
    public static void pushBot(Stack<Integer> st, int data) {
        if (st.isEmpty()) {
            st.add(data);
            return;
        }
        int t = st.pop();
        pushBot(st, data);
        st.push(t);
    }

    // Reverse String Using Stack
    public static String revString(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            st.push(str.charAt(i));
        }

        String ans = "";
        while(!st.isEmpty()){
            ans = ans +st.pop();
        }

        return ans;
    }

    //Reverse a stack -- Time - 0(n) ,space - 0(1)
    public static void revStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int t = st.pop();
        revStack(st);
        pushBot(st, t);
    }
    // Print element -- Top -> Bottom
    public static void print(Stack<Integer> st) {
        while (!st.isEmpty()) {
            System.out.println(st.pop() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
       Stack<Integer> s = new Stack<>();
       s.push(1);
       s.push(2);
       s.push(3);
       s.push(4);
       s.push(5);
       //revStack(s);
       print(s);
    }
}
