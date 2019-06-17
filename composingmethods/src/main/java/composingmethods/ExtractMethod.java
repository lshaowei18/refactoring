package composingmethods;

import java.util.Enumeration;
import java.util.Vector;

public class ExtractMethod {
  private String _name;
  private Vector _orders = new Vector();

  public ExtractMethod(String n) {
    _name = n;
  }

  void printOwing() {
    Enumeration e = _orders.elements();
    double outstanding = 0.0;

    //print banner
    System.out.println ("**************************");
    System.out.println ("***** Customer Owes ******");
    System.out.println ("**************************");

    //calculate outstanding
    while(e.hasMoreElements()) {
      Order each = (Order) e.nextElement();
      outstanding += each.getAmount();
    }

    //print details
    System.out.println("name: " + _name);
    System.out.println("amount: " + outstanding);
  }
}

class Order {
  public double getAmount() {
    return 2.0;
  }
}
