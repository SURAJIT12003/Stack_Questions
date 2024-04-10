package Stack_Apna_College;

import java.util.*;

public class Stack_using_Queue {
    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    //Approach 1 --***

    //add -0(1)

    // public static void add(int data){
    //     q1.add(data);
    // }

    //remove - 0(n)

    // public static int remov(){
    //     if(q1.isEmpty()){
    //         return -1;
    //     }
    //     while(q1.size()!=1){
    //         q2.add(q1.remove());
    //     }

    //     int t = q1.remove();
    //     while(!q2.isEmpty()){
    //         q1.add(q2.remove());
    //     }
    //     return t;
    // }

    //Approach -2 ***

    //add - 0(n)

    public static void add(int data){
        if(q1.isEmpty()){
            q1.add(data);
            return;
        }
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        q1.add(data);
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
    }

    //Remove  - 0(1)

    public static int remov(){
        if(q1.isEmpty()){
            return -1;
        }
        int t = q1.remove();
        return t;
    }
    public static void main(String[] args) {
        add(1);
        add(2);
        add(3);
        add(4);
        System.out.println(remov());
        add(5);
        System.out.println(remov());
        add(6);
        System.out.println(remov());
    }
}
