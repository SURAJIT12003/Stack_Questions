package Stack_Apna_College;

import java.net.SocketTimeoutException;
import java.util.*;


class Node {

    int data;
    Node next;
  
    Node(int data) {
        this.data = data;
        this.next = null;
    }

}

public class Stack_basic {
    
    //Stack using ArrayList
    static class stackArrayList{
        static ArrayList<Integer> as = new ArrayList<>();

        //Push Operation 
        public static void push(int data){
            as.add(data);
        }

        //pop Operation 
        public static int  pop(){
            if(as.size()==0){
                System.out.println("Stack Underflow");
                return -1;
            }

            int t = as.get(as.size()-1);
            as.remove(as.size()-1);
            return t ;
        }

        //Top element 
        public static int peek(){
            if(as.size()==0){
                System.out.println("Stack Underflow");
                return -1;
            }
            int t = as.get(as.size()-1);
            return t ;
        }

        //Check Stack is Empty 
        public static boolean isEmpty(){
            return as.size()==0;
        }

        //Stack Traversal   
        public static void printStack(){

            // //Buttom to top
            // for(int i=0;i<as.size();i++){
            //     System.out.print(as.get(i)+" ");
            // }
            // System.out.println();
            //Top to Buttom 
           while(!as.isEmpty()){
              System.out.print(as.remove(as.size()-1)+" ");
           }
           System.out.println();
        }
    }


    //Stack Using Linked List ***(Important)
    static class stackLL{
        static Node head = null;

        //push element 
        public static void pushll (int data){
            if (head == null) {
                head = new Node(data);
               
            } else {
                Node newNode = new Node(data);
                newNode.next = head;
                head = newNode;
            }
        }

        //pop element 
        public static int popll(){
            if(head==null){
                System.out.println("Stack Underflow ");
                return -1;
            }
            int t = head.data;
            head = head.next;
            return t;
        }

        //peek element 
        public static int peekll(){
            if(head==null){
                System.out.println("Stack Underflow ");
                return -1;
            }
            int t = head.data;
            return t;
        }

        //check stack is empty or not 
        public static boolean isEmpty(){
            return head==null;
        }
        //print stack 
        public static void printll(){
            while(head!=null){
                System.out.print(head.data+" ");
                head = head .next;
            }
        }

    }

    public static void main(String[] args) {
       stackLL st = new stackLL();
       st.pushll(1);
       st.pushll(2);
       st.pushll(3);
       st.pushll(4);
       st.pushll(5);
       st.pushll(6); System.out.println(st.isEmpty());
       System.out.println(st.popll());
       st.printll();
      
    }
}
