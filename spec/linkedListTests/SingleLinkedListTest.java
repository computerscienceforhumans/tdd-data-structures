package linkedListTests;

import linkedList.SingleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * nodes should be dependency injected into different list/tree types
 *
 * */

class SingleLinkedListTest {
    SingleLinkedList<Integer> singleLink;

    @Test
    void createFromArray() {
        String[] strings = new String[5];
        SingleLinkedList<String> listFromAray = new SingleLinkedList<>(strings);

        String expected = "[null]->(null)->(null)->(null)->(null)";
        String actual = listFromAray.toString();

        assertEquals(expected, actual);
    }


    @Nested
    class ToStringTest {

        @BeforeEach
        void setUp() {
            singleLink = new SingleLinkedList<>();
        }

        @Test
        void emptyListDisplaysEmptyString() {
            String expected = "";
            String actual = singleLink.toString();

            assertEquals(expected, actual);
        }

        @Test
        void headValueIsSurroundedBySquareBrackets() {
            singleLink.appendNode(128512);

            String expected = "[128512]";
            String actual = singleLink.toString();

            assertEquals(expected, actual);
        }

        @Test
        void futureNodesAreSeparatedByArrows() {
            singleLink.appendNode(406);
            singleLink.appendNode(-283);

            String expected = "[406]->(-283)";
            String actual = singleLink.toString();

            assertEquals(expected, actual);
        }

    }


    @Nested
    class IteratorTests {
        @BeforeEach
        void setUp() {
            singleLink = new SingleLinkedList<>();
        }

        @Nested
        class HasNextTests {

            @Test
            void isFalseInEmptyList() {
                boolean hasNextInEmptyList = singleLink.iterator().hasNext();

                assertFalse(hasNextInEmptyList);
            }

            @Test
            void isFalseAtEndOfList() {
                Iterator<Integer> iter = singleLink.iterator();

                boolean hasNextInEmptyList = iter.hasNext();
                assertFalse(hasNextInEmptyList);

                singleLink.appendNode(37);
                singleLink.appendNode(37);
                singleLink.appendNode(37);
                singleLink.appendNode(37);
                iter.next();
                iter.next();
                iter.next();
                iter.next();
                boolean hasNextAfterIteratingThroughEachElement = iter.hasNext();
                assertFalse(hasNextAfterIteratingThroughEachElement);
            }

            @Test
            void isTrueWhenNextNodeExists() {
                singleLink.appendNode(99872);
                singleLink.appendNode(58);
                boolean hasNextBeforeListEnds = singleLink.iterator().hasNext();

                assertTrue(hasNextBeforeListEnds);
            }
        }

        @Nested
        class NextTests {
            // return this one and go to the next one

            @Test
            void returnsCurrentNodeValue() {
                singleLink.appendNode(-129);
                int nodeValueBeforeIterating = singleLink.iterator().next();

                assertEquals(-129, nodeValueBeforeIterating);
            }

            @Test
            void returnsNextNodeValueTheSecondTime() {
                singleLink.appendNode(12);
                singleLink.appendNode(42);


                int secondNodeValue = 0;
                for(Integer currentValue : singleLink) {
                    System.out.println(currentValue);
//                    secondNodeValue = singleLink.iterator().next()next;
                }
                assertEquals(0, secondNodeValue);
            }
        }
    }

    @Nested
    class AppendNodeTests {
        @BeforeEach
        void setUp() {
            singleLink = new SingleLinkedList<Integer>();
        }

        @Test
        void firstAddedNodeBecomesHead() {
            singleLink.appendNode(137);

            int expected = 137;
            int actual = singleLink.headValue();

            assertEquals(expected, actual);
        }

        @Test
        void secondAddedNodeIsNext() {
            singleLink.appendNode(0);
            singleLink.appendNode(1);

            int expected = 1;
            int actual = singleLink.head().nextNode().value();

            assertEquals(expected, actual);
        }

        @Test
        void furtherNodesAreAddedToEnd() {
            singleLink.appendNode(-47);
            singleLink.appendNode(99999);
            singleLink.appendNode(1111111);

            int expected = 1111111;
            int actual = singleLink.head().nextNode().nextNode().value();

            assertEquals(expected, actual);
        }

        @Test
        void longerListsShouldAppendCorrectly() {
            for(int number = 0; number < 30; number++) {
                singleLink.appendNode(number);
            }

            String expected = "[0]->(1)->(2)->(3)->(4)->(5)->(6)->(7)->(8)->(9)->(10)->(11)->(12)->(13)->(14)->(15)->(16)->(17)->(18)->(19)->(20)->(21)->(22)->(23)->(24)->(25)->(26)->(27)->(28)->(29)";
            String actual = singleLink.toString();

            assertEquals(expected, actual);
        }
    }
}