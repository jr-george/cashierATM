import CashierModels.*;

import java.util.Scanner;

public class CashierMain {
    public static void main(String[] args) {
        CashierATM cashierATM = new CashierATM();

        String userAction;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\t\tBank ATM\n");
            System.out.println("1. Check Cashier Balance");
            System.out.println("2. Withdraw cash");
            System.out.print("Select an option or press any key to exit: ");
            userAction = sc.nextLine();

            if (userAction.equals("1")) {
                cashierATM.showCurrencyContent();
            }
            else if (userAction.equals("2")) {
                try
                {
                    float amount;
                    System.out.print("\nEnter amount to withdraw: ");
                    amount = sc.nextFloat();
                    cashierATM.cashWithdraw(amount);
                }
                catch (CashierAmountException cae)
                {
                    System.out.println(cae.getMessage());
                }
                catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }

            } else {
                break;
            }
        }

    }
}
