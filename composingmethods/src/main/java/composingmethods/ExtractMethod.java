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

    printBanner();
    double outstanding = getOutstanding();
    printDetails(outstanding);
  }

  void printBanner() {
    //print banner
    System.out.print("**************************\n");
    System.out.print("***** Customer Owes ******\n");
    System.out.print("**************************\n");
  }

  void printDetails(double outstanding) {
    System.out.print("name: " + _name + "\n");
    System.out.print("amount: " + String.valueOf(outstanding) +"\n");
  }

  double getOutstanding() {
    Enumeration e = _orders.elements();
    double outstanding = 0.0;

    //calculate outstanding
    while(e.hasMoreElements()) {
      Order each = (Order) e.nextElement();
      outstanding += each.getAmount();
    }
    return outstanding;
  }
}

class Order {
  public double getAmount() {
    return 2.0;
  }
}
