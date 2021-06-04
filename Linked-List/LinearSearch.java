public class LinearSearch {
    Node head;

static class Node {
    int data;
    Node next;

    Node (int data) {
     this.data =data;
     this.next =null;
    }
}

public static LinearSearch insert(LinearSearch list , int data){

    Node new_node = new Node(data);
    new_node.next = null;


    if(list.head == null){
        list.head = new_node;
    } else {
        Node last = list.head;
        while(last.next != null) {
          last = last.next;
        }

        last.next = new_node;
    }

  System.out.println(data +" inserted");
  return list;
}

public static void printList(LinearSearch list ){

System.out.println("List Items are ==>>");

Node currentNode = list.head;

while(currentNode != null) {
  System.out.println(currentNode.data);
  currentNode = currentNode.next;
}

}

public static void linearSearch(LinearSearch list, int key) {

   Node last = list.head;
   while(last.next != null) {
    if(last.data == key){
       System.out.println("Element Found "+key);
       System.exit(0);
    }
    last = last.next;
   }
    System.out.println("Given Element Not Found ");

}   

public static void main(String args[]){

 System.out.println("main triggered");

    LinearSearch list = new LinearSearch();
    insert(list , 98);
    insert(list , 18);
    insert(list , 28);
    insert(list , 88);
    insert(list , 8);
    insert(list , 88);
    insert(list , 88);
    insert(list , 88);


    // list.printList(list);
    linearSearch(list , 8);
    


    

}

}