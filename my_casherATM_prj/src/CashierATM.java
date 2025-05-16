public class CashierATM {
    private float balance;

    private CashContent[] moneyContent;

    public CashierATM()
    {
        balance=12550f;

        moneyContent = new CashContent[11];

        moneyContent[0] = new CashContent(new CashMoney(1000,'B'),2);
        moneyContent[1] = new CashContent(new CashMoney(500,'B'),5);
        moneyContent[2] = new CashContent(new CashMoney(200,'B'),10);
        moneyContent[3] = new CashContent(new CashMoney(100,'B'),20);
        moneyContent[4] = new CashContent(new CashMoney(50,'B'),30);
        moneyContent[5] = new CashContent(new CashMoney(20,'B'),40);
        moneyContent[6] = new CashContent(new CashMoney(10,'M'),50);
        moneyContent[7] = new CashContent(new CashMoney(5,'M'),100);
        moneyContent[8] = new CashContent(new CashMoney(2,'M'),200);
        moneyContent[9] = new CashContent(new CashMoney(1,'M'),300);
        moneyContent[10] = new CashContent(new CashMoney(0.5f,'M'),100);
    }
    public float getTotalMoneyAmount ()
    {
        float totalAmount=0;
        for (CashContent money : moneyContent)
            totalAmount+=money.getTotal();
        return totalAmount;
    }
    public float getBalance(){
        return balance;
    }

    public void showMoneyContent()
    {
        System.out.println("Type\t\tMoney\t\tQuantity\t\tAmount");
        for (CashContent money : moneyContent)
        {
            System.out.printf("%c\t\t%.2f\t\t%d\t\t%.2f\n", money.getMoney().getType(), money.getMoney().getValue(), money.getQuantity(), money.getTotal());
        }
    }

    public void withDrawMoney(float amount)
    {
        if (amount>balance)
        {
            return;
        }

        //Recorre el arreglo de billetes y monedas, si la cantidad de dinero existe retira el efectivo disponible
        int indexMoney=0;
        float tmpAmount=amount;
        while (indexMoney<moneyContent.length)
        {
            if (tmpAmount==0)
                break;
            if (moneyContent[indexMoney].getQuantity()>0)
            {
                int qtyMoneyDiscount;
                qtyMoneyDiscount=(int)tmpAmount / (int)moneyContent[indexMoney].getMoney().getValue();
                if (qtyMoneyDiscount<=moneyContent[indexMoney].getQuantity()) {
                    System.out.printf("%d of %.2f\n", qtyMoneyDiscount, moneyContent[indexMoney].getMoney().getValue());
                    moneyContent[indexMoney].updateQuantity(-qtyMoneyDiscount);
                }
                else {
                    System.out.printf("%d of %.2f\n", qtyMoneyDiscount, moneyContent[indexMoney].getMoney().getValue());
                    qtyMoneyDiscount = moneyContent[indexMoney].getQuantity();
                    moneyContent[indexMoney].updateQuantity(-qtyMoneyDiscount);
                }

                tmpAmount=tmpAmount-(qtyMoneyDiscount*moneyContent[indexMoney].getMoney().getValue());

            }

            indexMoney++;

        }
        balance=balance-amount;
    }
}
