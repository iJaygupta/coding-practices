import java.util.*;

public class RemoveDuplicates {

    Node head;

   static class Node {
        int data;
        Node next;

        Node (int data) {
           this.data= data;
           this.next=null;
        }
    }

    public static void insert (RemoveDuplicates list , int data) {
        Node new_node = new Node (data);
        if(list.head ==null) {
            list.head = new_node;
        } else {
            Node last = list.head;
            while(last.next != null) {
                last = last.next;
            }
            last.next=new_node;
        }
    }

    public static void removeDuplicates(RemoveDuplicates list) {
        int index =0;
        HashMap map = new HashMap();
        Node currentNode = list.head;

        while(currentNode != null) {
           map.put(index++, currentNode.data);
           currentNode = currentNode.next;
        }

        System.out.println(map);
    }


    public static void printList (RemoveDuplicates list) {
       Node currentNode = list.head;

       while(currentNode != null) {
           System.out.println("Value : "+currentNode.data);
           currentNode = currentNode.next;
       }
    }


    public static void main(String args[]){
        RemoveDuplicates list = new RemoveDuplicates();
        insert(list, 3);
        insert(list ,4);
        insert(list ,7);
        insert(list ,9);
        insert(list ,1);

        System.out.println("Removing Duplicates from List");

        printList(list);
        removeDuplicates(list);
    }

}