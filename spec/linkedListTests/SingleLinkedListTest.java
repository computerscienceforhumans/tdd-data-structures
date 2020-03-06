package linkedListTests;

import linkedList.SingleLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void emptyListDisplaysEmptyString() {
        SingleLinkedList singleLink = new SingleLinkedList();

        String expected = "";
        String actual = singleLink.toString();

        assertEquals(expected, actual);
    }
}