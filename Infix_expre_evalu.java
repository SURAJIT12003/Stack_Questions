package Stack_Apna_College;

import java.util.*;

public class Infix_expre_evalu {

    public static int value(int val1, int val2, char ch) {
        if (ch == '-') {
            return val1 - val2;
        } else if (ch == '+') {
            return val1 + val2;
        } else if (ch == '*') {
            return val1 * val2;
        } else {
            return val1 / val2;
        }
    }

    public static void main(String[] args) {
        String str = "1*2+1";
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            //Step -1 - if val come then value stack push else op stack work then push
            if (ch == '-' || ch == '+' || ch == '*' || ch == '/') {
                //if op is empty then push operator
                if (op.isEmpty()) {
                    op.push(ch);
                } 
                else {
                    //Step -3 if char is + or - then two value remove from val stack and op.peek remove and work 
                    if (ch == '-' || ch == '+') {
                        int val2 = val.pop();
                        int val1 = val.pop();
                        int cal = value(val1, val2, op.peek());

                        val.push(cal);
                        op.pop();
                        //work complete then char push 
                        op.push(ch);
                    } 
                    //Step - 4 if char is * or / then if op.peek ()== * or / then work 
                    else if (ch == '*' || ch == '/') {
                        if (op.peek() == '*' || op.peek() == '/') {
                            int val2 = val.pop();
                            int val1 = val.pop();
                            int cal = value(val1, val2, op.peek());

                            val.push(cal);
                            op.pop();
                            //work complete then char push 
                            op.push(ch);
                        }
                        else{
                            //else push no work 
                            op.push(ch);
                        }
                    } 
                }
                System.out.println(op);
            } 
            
            //Every time push value into a stack
            else {
                int t = ch - '0';
                System.out.println(t);
                val.push(t);
            }
        }

        //Remove val stack only one element present and work done**
        while (val.size() != 1) {
            int val2 = val.pop();
            int val1 = val.pop();
            int cal = value(val1, val2, op.pop());
            val.push(cal);
        }

        int ans = val.peek();
        System.out.println(ans);
    }
}
