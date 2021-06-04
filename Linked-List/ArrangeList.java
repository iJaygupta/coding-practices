class ArrangeList {

    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void arrangeList(ArrangeList list, int data) {

        int i = 0, j=9;
        Node currentNode = list.head;
        Node array[] = new Node[10];

        while (currentNode != null) {
            array[i++] = currentNode;
            currentNode = currentNode.next;
        }
        // currentNode = list.head;
        // System.out.println(array.get(9));

        for (i = 0; i < array.length; i++) {

            // currentNode.next = array[j--];
            System.out.println(array[i].data);

        }



    }

    public static void insert(ArrangeList list, int data) {
        Node new_node = new Node(data);

        if (list.head == null) {
            list.head = new_node;
        } else {

            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = new_node;

        }
    }

    public static void printList(ArrangeList list) {

        System.out.println("Printing List");
        Node currentNode = list.head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void main(String args[]) {
        ArrangeList list = new ArrangeList();

        insert(list, 3);
        insert(list, 2);
        insert(list, 9);
        insert(list, 4);
        insert(list, 9);
        insert(list, 7);
        insert(list, 8);
        insert(list, 1);
        insert(list, 2);
        insert(list, 0);

        printList(list);
        arrangeList(list, 2);
        // printList(list);

    }

}