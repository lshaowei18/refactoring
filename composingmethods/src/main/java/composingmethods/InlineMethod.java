package composingmethods;

public class InlineMethod {
  private int _quantity;
  private int _itemPrice;

  public InlineMethod(int quantity, int itemPrice) {
    _quantity = quantity;
    _itemPrice = itemPrice;
  }

  double getPrice() {
    return basePrice() * discountFactor(basePrice());
  }

  private int basePrice() {
    return _quantity * _itemPrice;
  }

  private double discountFactor(int basePrice) {
    if (basePrice > 1000) return 0.95;
    return 0.98;
  }
}
