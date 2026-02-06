// package TreesDSA;

public class TreeTraversal {
    Node head = null;

    Node createNode(int val){
        return new Node(val);
    }

    Node addNode(int val){
        if (head == null) {
            head = createNode(val);
        }else{
            Node tempNode = head;
            while (tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
            }
            tempNode.nextNode = createNode(val);
        }
        return new Node(val);
    }
    public static void main(String[] args) {
        TreeTraversal traversal = new TreeTraversal();
        traversal.addNode(25);
    }
}
