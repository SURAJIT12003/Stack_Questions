package Stack_Apna_College;

import java.util.*;

public class Histogram_area {

    //Time  - 0(n)
    public static int maxArea(int arr[],int n){

        int ans =0;
        int nsl[] = new int[n];
        int nsr[] = new int [n];

        //Next Smaller Right for every element ****

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        for(int i=n-1;i>=0;i--){
            int cur = arr[i];
            while( st.peek()!=-1 && arr[st.peek()] >= cur){
                st.pop();
            }
    
            nsr[i]= st.peek();
            st.push(i);
        }
        
        //Next Smaller Left
        
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        for(int i=0;i<n;i++){
            int cur = arr[i];
            while( s.peek()!=-1 && arr[s.peek()] >= cur){
                s.pop();
            }
    
            nsl[i]= s.peek();
            s.push(i);
        }

        for(int v:nsr){
            System.out.print(v+" ");
        }

        for(int v:nsl){
            System.out.print(v+" ");
        }

        //Calculate area
        for(int i=0;i<n;i++){
            int  l = arr[i];
            if (nsr[i]==-1){
                nsr[i] =n ;
            }
            int b= nsr[i] - nsl[i] -1 ;
            int newarr = l*b;
            ans = Math.max(ans,newarr); 
        }

        return ans ;
    }


    public static void main(String[] args) {
        int arr[]= {6,2,5,4,5,1,6};
        System.out.println(maxArea(arr, arr.length));
      
    }
}
