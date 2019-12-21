package ua.edu.ucu;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.stream.AsIntStream;
import ua.edu.ucu.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IntStreamTest {

    private IntStream intStream;

    @Before
    public void init() {
        int[] intArr = {-1, 0, 1, 2, 3};
        intStream = AsIntStream.of(intArr);
    }

    @Test
    public void testAverage() {
        System.out.println("Average");
        double expResult = 1;
        double result = intStream.average();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testAverageTerminate() {
        System.out.println("Average terminate");
        double expResult = 2.5;
        double result = intStream
                .filter(x -> x > 1) // 2, 3
                .average();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testMin() {
        System.out.println("max");
        double expResult = -1;
        double result = intStream.min();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testMax() {
        System.out.println("min");
        double expResult = 3;
        double result = intStream.max();
        assertEquals(expResult, result, 0.001);
    }


    @Test
    public void testMaxMinTerminate() {
        System.out.println("min, max terminate");
        double expResult = 2;
        double result = intStream
                .filter(x -> x > 1) // 2, 3
                .min();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testSum() {
        System.out.println("Sum");
        double expResult = 5;
        double result = intStream.sum();
        assertEquals(expResult, result, 0.001);
    }

    @Test
    public void testMap() {
        System.out.println("Sum");
        int[] expResult = {-2, -1, 0, 1, 2};
        int[] result = intStream.
                map(x -> x - 1)
                .toArray();
        assertArrayEquals(expResult, result);
    }

}
