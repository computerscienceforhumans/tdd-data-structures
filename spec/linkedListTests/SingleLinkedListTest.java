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
            singleLink.addToTailEnd(128512);

            String expected = "[128512]";
            String actual = singleLink.toString();

            assertEquals(expected, actual);
        }

        @Test
        void futureNodesAreSeparatedByArrows() {
            singleLink.addToTailEnd(406);
            singleLink.addToTailEnd(-283);

            String expected = "[406]->(-283)";
            String actual = singleLink.toString();

            assertEquals(expected, actual);
        }

    }

    @Nested
    class AddNodeToTailEndTests {
        @BeforeEach
        void setUp() {
            singleLink = new SingleLinkedList();
        }

        @Test
        void firstAddedNodeBecomesHead() {
            singleLink.addToTailEnd(137);

            int expected = 137;
            int actual = singleLink.headValue();

            assertEquals(expected, actual);
        }

        @Test
        void secondAddedNodeIsNext() {
            singleLink.addToTailEnd(0);
            singleLink.addToTailEnd(1);

            int expected = 1;
            int actual = singleLink.head().next().value();

            assertEquals(expected, actual);
        }

        @Test
        void furtherNodesAreAddedToEnd() {
            singleLink.addToTailEnd(-47);
            singleLink.addToTailEnd(99999);
            singleLink.addToTailEnd(1111111);

            int expected = 1111111;
            int actual = singleLink.head().next().next().value();

            assertEquals(expected, actual);
        }
    }
}