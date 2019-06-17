package solution;

import java.util.Vector;
import java.util.Enumeration;

public class Movie {
  public static final int REGULAR = 0;
  public static final int NEW_RELEASE = 1;
  public static final int CHILDRENS = 2;

  private String _title;
  private Price _price;

  public Movie(String title, int priceCode) {
    _title = title;
    setPriceCode(priceCode);
  }

  public int getPriceCode() {
    return _price.getPriceCode();
  }

  public void setPriceCode(int code) {
     switch (code) {
       case Movie.REGULAR:
         _price = new RegularPrice();
         break;
       case Movie.CHILDRENS:
         _price = new ChildrensPrice();
         break;
       case Movie.NEW_RELEASE:
         _price = new NewReleasePrice();
         break;
       default:
         throw new IllegalArgumentException("Incorrect Price Code");
     }
  }

  public String getTitle() {
    return _title;
  }

  public double getCharge(int daysRented) {
    return _price.getCharge(daysRented);
  }

  public int getFrequentRenterPoints(int daysRented) {
    return _price.getFrequentRenterPoints(daysRented);
  }
}

abstract class Price {
  abstract int getPriceCode();
  abstract double getCharge(int daysRented);
  int getFrequentRenterPoints(int daysRented) {
    return 1;
  }
}

class ChildrensPrice extends Price {
  int getPriceCode() {
    return Movie.CHILDRENS;
  }

  double getCharge(int daysRented) {
    double result = 1.5;
    if (daysRented > 3) {
      result += (daysRented - 3) * 1.5;
    }
    return result;
  }
}

class NewReleasePrice extends Price {
  int getPriceCode() {
    return Movie.NEW_RELEASE;
  }

  double getCharge(int daysRented) {
    return daysRented * 3;
  }

  @Override
  int getFrequentRenterPoints(int daysRented) {
    if ( daysRented > 1) return 2;
    return 1;
  }
}

class RegularPrice extends Price {
  int getPriceCode() {
    return Movie.REGULAR;
  }

  double getCharge(int daysRented) {
    double result = 2;
    if (daysRented > 2) {
      result += (daysRented -2) * 1.5;
    }
    return result;
  }
}

class Rental {
  private Movie _movie;
  private int _daysRented;

  public Rental(Movie movie, int daysRented) {
    _movie = movie;
    _daysRented = daysRented;
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }

  public int getFrequentRenterPoints() {
    return _movie.getFrequentRenterPoints(_daysRented);
  }

  public double getCharge() {
    return _movie.getCharge(_daysRented);
  }
}

class Customer {
  private String _name;
  private Vector _rentals = new Vector();

  public Customer(String name) {
    _name = name;
  }

  public void addRental(Rental arg) {
    _rentals.addElement(arg);
  }

  public String getName() {
    return _name;
  }

  public String statement() {
    Enumeration rentals = _rentals.elements();
    String result = "Rental Record for " + getName() + "\n";

    while(rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();

      //show figures for this rental
      result += each.getMovie().getTitle() + " ";
      result += String.valueOf(each.getCharge()) + "\n";
    }

    //add footer lines
    result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
    result += "You earned " + String.valueOf(getTotalFrequentRenterPoints());
    result += " frequent renter points";

    return result;
  }

  private double amountFor(Rental aRental) {
    return aRental.getCharge();
  }

  private double getTotalCharge() {
    double result = 0;
    Enumeration rentals = _rentals.elements();
    while(rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getCharge();
    }
    return result;
  }

  private int getTotalFrequentRenterPoints() {
    int result = 0;
    Enumeration rentals = _rentals.elements();
    while(rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      result += each.getFrequentRenterPoints();
    }
    return result;
  }

  public String htmlStatement() {
    Enumeration rentals = _rentals.elements();
    String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
    while (rentals.hasMoreElements()) {
      Rental each = (Rental) rentals.nextElement();
      //show figures for each rental
      result += each.getMovie().getTitle()+": ";
      result += String.valueOf(each.getCharge()) + "<BR>\n";
    }
    //add footer lines
    result += "<P>You owe <EM>" + String.valueOf(getTotalCharge());
    result += "On this rental you earned <EM>" ;
    result += String.valueOf(getTotalFrequentRenterPoints());
    result += "</EM> frequent renter points<P>";
    return result;
  }
}
