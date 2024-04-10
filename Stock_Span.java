package Stack_Apna_College;

import java.util.*;

public class Stock_Span {

    public static void StockSpan(int stock[], int ans[]) {

        Stack<Integer> index = new Stack<>();
        int n = stock.length;
        index.push(0);
        ans[0] = 1;
        for (int i = 1; i < n; i++) {

            int t = stock[i];

            int yt = 0;
            // Step 1 = check prev greter element index
            while (!index.isEmpty()) {
                if (stock[index.peek()] > t) { //access element using stack 
                    yt = 1;
                    break;
                }

                index.pop();
            }

            // Step 2 - is found then calculate diff
            if (yt == 1) {
                int k = i - index.peek();
                ans[i] = k;
            } else {
                // if not found then add 1 with current index
                int k = i + 1;
                ans[i] = k;
            }
            
            //Step 3 - Every time add index in stack 
            index.push(i);
        }

    }

    public static void main(String[] args) {
            int stack[] = {100 ,80 ,60, 70 ,60, 75 ,85,100};
            int ans [] = new int [stack.length];
            StockSpan(stack, ans);
            for(int v:ans){
                System.out.println(v);
            }
    }
}
