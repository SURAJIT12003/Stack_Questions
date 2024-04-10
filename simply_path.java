package Stack_Apna_College;

import java.util.*;

public class simply_path {
    public static void main(String[] args) {
        String ans = "";
        String path = "/home//file/";
        Stack<String> st = new Stack<>();
        for(int i=0;i<path.length();i++){
            char ch = path.charAt(i);
            if(ch=='/'){
                String s="";
                int j =i+1;
                while(j<path.length()  && path.charAt(j)!='/'){
                    s=s+path.charAt(j);
                    j++;
                   // System.out.println(s);
                }
                 if(s.equals(".") || s.equals("")){
                    continue;
                }
                if(s.equals("..")){
                    if(!st.isEmpty()){
                        st.pop();
                    }
                    continue;
                }
                i=j-1;
                st.push(s);
            }
        }


     //   System.out.println(st);
        while(!st.isEmpty()){
            ans="/"+st.pop()+ans;
        }
        if(ans.length()==0){
            ans+="/";
        }

        System.out.println(ans);
    }
}
