// package TreesDSA;

public class Node {
    int val;
    Node nextNode = null;
    Node prevNode = null;
    Node(){}
    Node(int val){
        this.val = val;
    }
    Node(int val, Node nextNode, Node prevNode){
        this.val = val;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }
}
