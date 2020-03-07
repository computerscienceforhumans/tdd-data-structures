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

    public void addToTailEnd(int number) {
        OneWayNode newNode = new OneWayNode(number);

        if( this.head == null ) {
            this.head = newNode;
            return;
        }

        this.head.next = newNode;
    }

    public String toString() {
        StringBuilder listString = new StringBuilder();
        boolean isHead = true;

        for(OneWayNode currentNode = head; currentNode != null; currentNode = currentNode.next()) {
            if (isHead) {
                listString = listString.append("[" + currentNode.value() + "]");
                isHead = false;
            }
            else listString = listString.append("->(" + currentNode.value() + ")");
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
