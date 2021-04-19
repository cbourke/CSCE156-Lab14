package unl.cse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTests {

    Stack<String> testStack;

    /**
     * Setup a {@link Stack} object for use in each test method
     */
    @BeforeEach
    public void stackSetup() {
        testStack = new Stack<>();
    }

    /**
     * Test that the implementation of {@link Stack}'s methods function correctly
     */
    @Test
    public void stackTest() {
        // isEmpty - returning true
        assertTrue(testStack.isEmpty(), "Stacks should start empty");
        assertEquals(0, testStack.size(), String.format("size() returned %d for a stack with %d elements", testStack.size(), 0));


        // Push
        testStack.push("Test");
        assertEquals(1, testStack.size(), String.format("size() returned %d for a stack with %d elements", testStack.size(), 1));

        testStack.push("CSCE");
        assertEquals(2, testStack.size(), String.format("size() returned %d for a stack with %d elements", testStack.size(), 2));

        testStack.push("156");
        assertEquals(3, testStack.size(), String.format("size() returned %d for a stack with %d elements", testStack.size(), 3));

        testStack.push("156");
        assertEquals(4, testStack.size(), String.format("size() returned %d for a stack with %d elements", testStack.size(), 4));

        // isEmpty - returning false
        assertFalse(testStack.isEmpty(), "Stack with 4 items is not be empty");

        // Pop
        assertEquals("156", testStack.pop(), "Stack returned out of order");
        assertEquals("156", testStack.pop(), "Stack returned out of order");
        assertEquals("CSCE", testStack.pop(), "Stack returned out of order");
        assertEquals("Test", testStack.pop(), "Stack returned out of order");

        try {
            // Attempt to pop from an empty stack
            // This permits returning null or throwing an exception
            assertNull(testStack.pop(), "Stack return should be null or throw an exception");
        } catch (Exception ignored) {}

        // isEmpty - returning true
        assertTrue(testStack.isEmpty(), "Stack should now be empty");
    }
}
