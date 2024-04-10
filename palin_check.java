package Stack_Apna_College;

import java.util.*;


public class palin_check {
    


    public static boolean pali(LinkedList<Character> ll){
        Stack<Character> s = new Stack<>();
        
        for(int i=0;i<ll.size();i++){
            s.push(ll.get(i));
        }

        int j=0;
        while(!s.isEmpty()){
            if(s.pop()!=ll.get(j)){
                return false;
            }
            j++;
        }
        return true;
    }
    public static void main(String[] args) {
        LinkedList<Character> ll  = new LinkedList<>();
        ll.add('a');
        ll.add('b');
        ll.add('b');
        ll.add('a');
        System.out.println(pali(ll));
      
    }
}
