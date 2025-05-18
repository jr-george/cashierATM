package CashierModels;

public class CashCurrency {
    private int quantity;
    private CurrencyType currencyType;
    private float value;

    public CashCurrency(int quantity, CurrencyType currencyType, float value) {
        this.quantity = quantity;
        this.currencyType = currencyType;
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }
    public float getValue() {
        return value;
    }
    public CurrencyType getCurrencyType() {
        return currencyType;
    }
    public float getAmount(){
        return quantity*value;
    }
    public void updateQuantity(int quantity) {
        this.quantity += quantity;
    }
}
