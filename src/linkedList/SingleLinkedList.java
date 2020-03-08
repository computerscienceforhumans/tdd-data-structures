package linkedList;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SingleLinkedList<T> implements Iterable<T> {

    private OneWayNode<T> head;

    public SingleLinkedList(){}

    public SingleLinkedList(T[] startingElements) {
        for(T element : startingElements) {
            this.appendNode(element);
        }
    }

    class SingleLinkedListIterator implements Iterator<T>{
        OneWayNode<T> currentNode;

        SingleLinkedListIterator(SingleLinkedList<T> singleLinkedList) {
            currentNode = singleLinkedList.head();
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {

        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SingleLinkedListIterator(this);
    }

    @Override
    public void forEach(Consumer<? super T> action) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    public OneWayNode<T> head() {
        return this.head;
    }

    public T headValue() {
        return head.value();
    }

    public void appendNode(T value) {
        OneWayNode<T> newNode = new OneWayNode<>(value);
        if (head == null) {
            head = newNode;
            return;
        }

        OneWayNode<T> currentNode = finalNode();
        currentNode.next = newNode;
    }

    private OneWayNode<T> finalNode() {
        OneWayNode<T> currentNode = head;


        while(currentNode.next() != null) {
            currentNode = currentNode.next();
        }
        return currentNode;
    }

    public String toString() {
        StringBuilder listString = new StringBuilder();
        boolean isHead = true;

        for(OneWayNode<T> currentNode = head; currentNode != null; currentNode = currentNode.next()) {
            if (isHead) {
                listString.append("[").append(currentNode.value()).append("]");
                isHead = false;
            }
            else listString.append("->(").append(currentNode.value()).append(")");
        }

        return listString.toString();
    }

    public class OneWayNode<T> {
        private T value;
        private OneWayNode<T> next;

        OneWayNode(T value) {
            this.value = value;
        }

        public T value() {
            return this.value;
        }

        public OneWayNode<T> next() {
            return this.next;
        }
    }
}
