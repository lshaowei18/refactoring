package solution;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

public class MovieTest {
  @Test
  public void testRegularMovieLessThan2Days() {
    Movie movie = new Movie("Instant Family", 0); // Regular
    Rental rental = new Rental(movie, 1);
    Customer customer = new Customer("Jcole");
    customer.addRental(rental);
    String statement = customer.statement();
    System.out.println(statement);
    assertThat(statement, containsString(movie.getTitle() + " 2.0"));
  }
}
