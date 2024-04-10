package Stack_Apna_College;


import java.util.*;
public class Next_gret {
    
    //Four condition Occur - 
    /*                       (loop start)      (condition)[Break this condition]
     
    1) Next Greater Right -    N-1                cur < st.peek 
      *Ex - 2,1,5,6,4,3 -- here  5 NGR 6 
 
    2) Next Greater Left -      0                 cur < st.peek
      *Ex - 2,1,5,6,4,3 -- here  4 NGL 6  (previ greater element *)

    3) Next Smaller Right -      N-1                cur > st.peek
        *Ex - 2,1,5,6,4,3 -- here 5 NSR 4

    4) Next Smaller Left -      0                   cur>st.peek
        *Ex - 2,1,5,6,4,3 - here  5 NSL 1   (previ smaller element *) 



     */

     //This is Next Greater Right (NGR)
    public static void nextGreat(int arr[],int ans[]){
        Stack<Integer> st = new Stack<>();
        
        int n = arr.length;
        ans[n-1]=-1;
        st.push(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            int t = arr[i];
            int yt =0;
            while(!st.isEmpty()){
                if(t<st.peek()){
                    yt =1 ;
                    break;
                }
                st.pop();
            }

            if(yt==1){
                ans[i]=st.peek();
            }
            else{
                ans[i]=-1;
            }
            st.push(t);
        }
    }

    // nest greater index 
    public static void nextGreatIndex(int arr[],int ans[]){
        Stack<Integer> st = new Stack<>();
        
        int n = arr.length;
        ans[n-1]=-1;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            int t = arr[i];
            int yt =0;
            while(!st.isEmpty()){
                if(t<arr[st.peek()]){
                    yt =1 ;
                    break;
                }
                st.pop();
            }

            if(yt==1){
                ans[i] = st.peek();
            }
            else{
                ans[i]=-1;
            }
            st.push(i);
        }

        for(int v:ans){
            System.out.println(v);
        }
    }

    
    public static void main(String[] args) {
        int arr[] = {6,8,0,1,3};
        int ans[] = new int[arr.length];
        // nextGreat(arr, ans);
        // for(int v :ans){
        //     System.out.println(v);
        // }
        nextGreatIndex(arr, ans);
    }
}
