package linkedListTests;

import linkedList.SingleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {
    SingleLinkedList singleLink;



    @Nested
    class ToStringTest {

        @BeforeEach
        void setUp() {
            singleLink = new SingleLinkedList();
        }

        @Test
        void emptyListDisplaysEmptyString() {
            String expected = "";
            String actual = singleLink.toString();

            assertEquals(expected, actual);
        }

        @Test
        void headValueIsSurroundedBySquareBrackets() {
            singleLink.add(128512);

            String expected = "[128512]";
            String actual = singleLink.toString();

            assertEquals(expected, actual);
        }

//        @Test
//        void futureNodesAreSeparatedByArrows() {
//            singleLink.add(406);
//            singleLink.add(-283);
//
//            String expected = "[406]->-283";
//            String actual = singleLink.toString();
//
//            assertEquals(expected, actual);
//        }

    }

    @Nested
    class AddNodeTests {
        @BeforeEach
        void setUp() {
            singleLink = new SingleLinkedList();
        }

        @Test
        void firstAddedNodeBecomesHead() {
            singleLink.add(137);

            int expected = 137;
            int actual = singleLink.headValue();

            assertEquals(expected, actual);
        }

        @Test
        void secondAddedNodeIsNext() {
            singleLink.add(0);
            singleLink.add(1);

            int expected = 1;
            int actual = singleLink.head().next().value();

            assertEquals(expected, actual);
        }
    }
}