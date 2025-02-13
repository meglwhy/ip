package task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * JUnit tests for the Deadline class.
 */
public class DeadlineTest {

    @Test
    public void testDeadlineToString() {
        // Create a Deadline with the expected input format.
        // For example, if your production code expects a date string in "yyyy-MM-dd HHmm" format:
        Deadline deadline = new Deadline("hw", "2025-03-02 1900");

        // Call toString() and capture its output.
        String output = deadline.toString();

        // For your sample output, we expect the string to contain the following substring.
        // (Adjust the expected substring exactly to match your production output.)
        String expectedSubstring = "(by: Mar 02 2025, 7:00 pm)";

        // Assert that the output contains the expected formatted date.
        assertTrue(output.contains(expectedSubstring),
                "Deadline toString() should contain the formatted deadline date: " + expectedSubstring);
    }

    @Test
    public void testDeadlineToFileString() {
        Deadline deadline = new Deadline("hw", "2025-03-02 1900");
        // Assuming toFileString() returns the date in the input format:
        String expected = "D | 0 | hw | 2025-03-02 1900";
        assertEquals(expected, deadline.toFileString(),
                "Deadline toFileString() output does not match expected string.");
    }
}
