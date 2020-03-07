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
        public void emptyListDisplaysEmptyString() {
            String expected = "";
            String actual = singleLink.toString();

            assertEquals(expected, actual);
        }

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
            int actual = singleLink.head;

            assertEquals(expected, actual);
        }
    }
}