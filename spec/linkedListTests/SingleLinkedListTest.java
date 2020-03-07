package linkedListTests;

import linkedList.SingleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {
    SingleLinkedList<Integer> singleLink;



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
    class AppendNodeTests {
        @BeforeEach
        void setUp() {
            singleLink = new SingleLinkedList<>();
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
            int actual = singleLink.head().next().value();

            assertEquals(expected, actual);
        }

        @Test
        void furtherNodesAreAddedToEnd() {
            singleLink.appendNode(-47);
            singleLink.appendNode(99999);
            singleLink.appendNode(1111111);

            int expected = 1111111;
            int actual = singleLink.head().next().next().value();

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