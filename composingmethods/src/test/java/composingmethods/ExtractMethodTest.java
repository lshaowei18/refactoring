package composingmethods;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class ExtractMethodTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private String expected;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.out.println(expected);
    System.out.println(outContent.toString());
  }

  @Test
  public void out() {
    ExtractMethod em = new ExtractMethod("Shao Wei");
    em.printOwing();

    expected = "**************************\n";
    expected += "***** Customer Owes ******\n";
    expected += "**************************\n";
    expected += "name: " + "Shao Wei\n";
    expected += "amount: " + String.valueOf(0.0) + "\n";

    assertEquals("expected", outContent.toString());
  }
}
