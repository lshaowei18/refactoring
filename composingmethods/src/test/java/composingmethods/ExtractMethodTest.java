package composingmethods;

import org.junit.Test;
import static org.junit.Assert.*;

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
    ExtractMethod em = new ExtractMethod();
    em.printOwing();

    String expected = "**************************%n";
    expected += "***** Customer Owes ******%n";
    expected += "**************************%n";
    expected += "name: " + "Shao Wei";
    expected += "amount: " + String.valueOf(0);

    assertEquals("expected", outContent.toString());
  }
}
