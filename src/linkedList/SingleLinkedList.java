package linkedList;

public class SingleLinkedList {

    // TODO ideas
    // constructor that takes a list of numbers
    // make list generic

    private OneWayNode head;

    public OneWayNode head() {
        return this.head;
    }

    public int headValue() {
        return head.value();
    }

    public void appendNumber(int number) {
        OneWayNode newNode = new OneWayNode(number);
        if (head == null) {
            head = newNode;
            return;
        }

        OneWayNode currentNode = finalNode();
        currentNode.next = newNode;
    }

    private OneWayNode finalNode() {
        OneWayNode currentNode = head;


        while(currentNode.next() != null) {
            currentNode = currentNode.next();
        }
        return currentNode;
    }

    public String toString() {
        StringBuilder listString = new StringBuilder();
        boolean isHead = true;

        for(OneWayNode currentNode = head; currentNode != null; currentNode = currentNode.next()) {
            if (isHead) {
                listString.append("[").append(currentNode.value()).append("]");
                isHead = false;
            }
            else listString.append("->(").append(currentNode.value()).append(")");
        }

        return listString.toString();
    }

    public class OneWayNode {
        private int value;
        private OneWayNode next;

        OneWayNode(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }

        public OneWayNode next() {
            return this.next;
        }
    }
}
