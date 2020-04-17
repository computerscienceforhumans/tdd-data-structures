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
        currentNode.nextNode = newNode;
    }

    private OneWayNode<T> finalNode() {
        OneWayNode<T> currentNode = head;


        while(currentNode.nextNode() != null) {
            currentNode = currentNode.nextNode();
        }
        return currentNode;
    }

    public String toString() {
        StringBuilder listString = new StringBuilder();
        boolean isHead = true;

        for(T currentNode : this) {
            if (isHead) {
                listString.append("[").append(currentNode).append("]");
                isHead = false;
            }
            else listString.append("->(").append(currentNode).append(")");
        }

        return listString.toString();
    }

    public class OneWayNode<T> {
        private T value;
        private OneWayNode<T> nextNode;

        OneWayNode(T value) {
            this.value = value;
        }

        public T value() {
            return this.value;
        }

        public OneWayNode<T> nextNode() {
            return this.nextNode;
        }
    }

    class SingleLinkedListIterator implements Iterator<T>{
        OneWayNode<T> currentNode;

        SingleLinkedListIterator(SingleLinkedList<T> singleLinkedList) {
            currentNode = singleLinkedList.head();
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            if(!hasNext()) return null;
            T value = currentNode.value();
            currentNode = currentNode.nextNode();
            return value;
        }

        @Override
        public void remove() {

        }
    }
}
