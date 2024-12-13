import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.*;

public class Exercise_1 {

    public Exercise_1() {
        // Constructor
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i * Integer.parseInt(args[0]));
        }
    }

    @Test
    public void testExercise_1() {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        String[] args = {"10"};
        // action
        Exercise_1.main(args);

        // assertion
        String expected = "0\n10\n20\n30\n40\n50\n60\n70\n80\n90";
        try {
            assertEquals(expected, bos.toString().trim().replace("\r", ""));
        } catch (AssertionError e) {
            System.setOut(originalOut);
            System.out.println("Got: \"" + bos.toString().trim() + "\" Expected: \"" + expected.trim() + "\"");
            throw e;
        }

        // undo the binding in System
        System.setOut(originalOut);
    }
}