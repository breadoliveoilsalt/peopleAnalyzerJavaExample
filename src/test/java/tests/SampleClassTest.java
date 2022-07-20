package tests;

import sample.SampleClass;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleClassTest {

    private SampleClass sampleClass;

    @Before
    public void testInit() {
        sampleClass = new SampleClass();
    }

    @Test
    public void testAddFiveAddsFive() throws IOException {
        sampleClass = new SampleClass();
        assertEquals(7, sampleClass.addFive(2));
    }

}
