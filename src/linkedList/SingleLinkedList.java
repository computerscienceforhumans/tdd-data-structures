package linkedList;

public class SingleLinkedList {

    private OneWayNode head;

    public int headValue() {
        return head.value();
    }

    public void add(int number) {
        head = new OneWayNode(number);
    }

    public String toString() {
        return "";
    }

    public class OneWayNode {
        private int value;

        public OneWayNode(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }
}
