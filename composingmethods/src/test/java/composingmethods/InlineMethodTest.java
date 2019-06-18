package composingmethods;

import org.junit.Test;
import static org.junit.Assert.*;

public class InlineMethodTest {
  private static final double DELTA = 1e-15;

  @Test
  public void testPriceLessThan1k() {
    InlineMethod im = new InlineMethod(2, 100);
    assertEquals(196, im.getPrice(), DELTA);
  }

  @Test
  public void testPriceMoreThan1k() {
    InlineMethod im = new InlineMethod(5, 2000);
    assertEquals(9500, im.getPrice(), DELTA);
  }
}
