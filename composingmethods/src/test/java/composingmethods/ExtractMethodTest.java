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
  public void PrintOwingWhenNoOrders() {
    String name = "Shao Wei";
    double amt = 0;
    ExtractMethod em = new ExtractMethod(name);
    em.printOwing();
    String expected = getExpected(name, amt);
    assertEquals(expected, outContent.toString());
  }

  private String getExpected(String name, double amt) {
    String expected = "**************************\n";
    expected += "***** Customer Owes ******\n";
    expected += "**************************\n";
    expected += "name: " + name + "\n";
    expected += "amount: " + amt + "\n";

    return expected;
  }
}
