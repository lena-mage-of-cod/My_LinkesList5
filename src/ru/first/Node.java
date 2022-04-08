package ru.first;

public class Node {
    String value;
    Node prev;
    Node next;
    int index;

     public Node (String value, Node prev,Node next){
         this.value = value;
         this.prev = prev;
         this.next = next;
     }
     public Node (String value,Node prev, Node next, int index){
         this.value = value;
         this.prev = prev;
         this.next = next;
         this.index = index;
     }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                '}';
    }
}
