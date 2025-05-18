package CashierModels;

public class CashierATM {
    private CashCurrency[] cashCurrency;

    public CashierATM() {
        //Constructor for CashierATM Class sets initial array of currency
        cashCurrency = new CashCurrency[11];
        cashCurrency[0]=new CashCurrency(2,CurrencyType.BILL,1000);
        cashCurrency[1]=new CashCurrency(5,CurrencyType.BILL,500);
        cashCurrency[2]=new CashCurrency(10,CurrencyType.BILL,200);
        cashCurrency[3]=new CashCurrency(20,CurrencyType.BILL,100);
        cashCurrency[4]=new CashCurrency(30,CurrencyType.BILL,50);
        cashCurrency[5]=new CashCurrency(40,CurrencyType.BILL,20);
        cashCurrency[6]=new CashCurrency(50,CurrencyType.COIN,10);
        cashCurrency[7]=new CashCurrency(100,CurrencyType.COIN,5);
        cashCurrency[8]=new CashCurrency(200,CurrencyType.COIN,2);
        cashCurrency[9]=new CashCurrency(300,CurrencyType.COIN,1);
        cashCurrency[10]=new CashCurrency(100,CurrencyType.COIN,0.5f);
    }

    public float getBalance() {
        float balance = 0;
        for (int i = 0; i < cashCurrency.length; i++) {
            balance+=cashCurrency[i].getAmount();
        }
        return balance;
    }
    public void showCurrencyContent (){
        //This method shows currency array in table format
        //at the bottom shows cashier balance.
        System.out.printf("%s%20s%20s%20s\n","Currency","Type","Quantity","Amount" );
        for(CashCurrency cash : cashCurrency)
        {
            System.out.printf("%,.2f%20s%20d%,20.2f\n", cash.getValue(), cash.getCurrencyType(),cash.getQuantity(), cash.getAmount());
        }
        System.out.printf("Current ATM Balance: $%,.2f\n", getBalance());
    }

    public void cashWithdraw(float amount) throws CashierAmountException {
        if (amount>getBalance()) {
            throw new CashierAmountException("There is no such currency");
        }
        //Declare a variable to store division result
        int qtyCurrency=0;
        int index=0;
        //Declare a variable to store temporal amount. tmpAmount will be reduced to zero
        float tmpAmount=amount;
        while (index<cashCurrency.length) {
            if (tmpAmount==0) {
                break;
            }
            if (cashCurrency[index].getQuantity()>0) {
                int qtyCurrencyQuit= (int)tmpAmount/(int)cashCurrency[index].getValue();
                qtyCurrencyQuit=qtyCurrencyQuit>cashCurrency[index].getQuantity()?cashCurrency[index].getQuantity():qtyCurrencyQuit;

                tmpAmount-=qtyCurrencyQuit*cashCurrency[index].getValue();

                cashCurrency[index].updateQuantity(-qtyCurrencyQuit);
                if (qtyCurrencyQuit>0) {
                    System.out.printf("\nDispatching %d %s of %.2f\n", qtyCurrencyQuit, cashCurrency[index].getCurrencyType(),  cashCurrency[index].getValue());
                }

            }
           index++;
        }

    }
}
