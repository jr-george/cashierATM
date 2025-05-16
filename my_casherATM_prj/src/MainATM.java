import java.util.Scanner;

public class MainATM {


    public static void main (String s[])
    {
        //Se crea la instancia de CashierATM
        CashierATM cashierATM = new CashierATM();
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("Cashier ATM");
            System.out.println("1.- Check cashier balance");
            System.out.println("2.- Cash withdrawal");
            System.out.print("\nSelect an option or press any key to exit: ");
            String option;
            option=sc.nextLine();

            if (option.equals("1"))
            {
                cashierATM.showMoneyContent();
            } else if (option.equals("2")) {
                System.out.print("Amount to withdraw: ");
                float myAmount;
                myAmount=sc.nextFloat();
                cashierATM.withDrawMoney(myAmount);
            } else {
                break;
            }

        }
    }
}
