package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.stream.AsIntStream;
import ua.edu.ucu.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class IntStreamTest {

    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }

    @Test
    public void testStreamOperations() {
        System.out.println("streamOperations");
        int expResult = 42;
        int result = StreamApp.streamOperations(intStream);
        assertEquals(expResult, result);
    }
}
