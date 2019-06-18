package composingmethods;

public class InlineMethod {
  private int _quantity;
  private int _itemPrice;

  public InlineMethod(int quantity, int itemPrice) {
    _quantity = quantity;
    _itemPrice = itemPrice;
  }

  double getPrice() {
    int basePrice = _quantity * _itemPrice;
    double discountFactor;
    if (basePrice > 1000) discountFactor = 0.95;
    else discountFactor = 0.98;
    return basePrice * discountFactor;
  }
}
