package iodemo;

import org.junit.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TrainersWriterExtractMethodTest {

    @Test
    public void write() throws IOException {
        StringWriter writer = new StringWriter();

        new TrainersWriterExtractMethod().write(
                Arrays.asList("Jack Doe", "Jane Doe"),
                writer
        );

        String result = writer.toString();

        assertEquals("Jack Doe;Jane Doe;",
                result);
    }
}