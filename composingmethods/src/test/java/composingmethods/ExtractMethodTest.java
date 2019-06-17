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

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
  }

  @Test
  public void out() {
    ExtractMethod em = new ExtractMethod("Shao Wei");
    em.printOwing();

    String expected = "**************************%n";
    expected += "***** Customer Owes ******%n";
    expected += "**************************%n";
    expected += "name: " + "Shao Wei";
    expected += "amount: " + String.valueOf(0);

    assertEquals("expected", outContent.toString());
  }
}
