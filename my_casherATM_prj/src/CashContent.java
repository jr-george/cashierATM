public class CashContent {
    private CashMoney money;
    private int quantity;

    public CashContent (CashMoney cashMoney, int qty)
    {
        this.money=cashMoney;
        this.quantity=qty;
    }

    public int getQuantity ()
    {
        return quantity;
    }

    public float getTotal ()
    {
        return (quantity*money.getValue());
    }
    public CashMoney getMoney ()
    {
        return money;
    }
    public void updateQuantity(int qty){
        this.quantity+=qty;
    }
}
