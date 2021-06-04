 class DeletionExample {

  Node head;

  static class Node {
      int data ;
      Node next;

      Node (int data) {
          this.data=data;
          this.next= null;
      }
  } 

  public static void deleteNode(DeletionExample list , int key) {

    Node currentNode = list.head;
    Node previousNode = list.head;
   

    while(currentNode != null) {
       if(currentNode.data != key) {
         previousNode =currentNode;
         currentNode = currentNode.next;
       } else {
         if(currentNode == list.head) {
           list.head = currentNode.next;
         }
         
         previousNode.next = currentNode.next;
         
         System.out.println(key + " Deleted from List");
         printList(list);
         System.exit(0);
       }
    }
      System.out.println(key + " Not Found in List");
  }

  public static void insert(DeletionExample list , int data) {
    Node new_node = new Node(data);

    if(list.head == null) {
      list.head = new_node;
    } else {

        Node last = list.head;
        while(last.next != null){
          last = last.next;
        }

        last.next = new_node;

    }

  }

  public static void printList(DeletionExample list){

    Node currentNode = list.head;
    while(currentNode != null) {
      System.out.println(currentNode.data);
      currentNode = currentNode.next;
    }
  }


  public static void main(String args[]) {
    DeletionExample list = new DeletionExample();

    insert(list , 3);
    insert(list , 2);
    insert(list , 9);
    insert(list , 4);
    printList(list);
    deleteNode(list , 2);


  }

}