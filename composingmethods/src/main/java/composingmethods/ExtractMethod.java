package composingmethods;

public class ExtractMethod {

  void printOwing(String name ,double amount) {
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
