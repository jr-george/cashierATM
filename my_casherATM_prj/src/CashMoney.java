public class CashMoney {
    private float value; //La denominacion
    private char type; //Determina si es moneda M o Billete B
    //Cantidad

    public CashMoney (float valueMoney, char typeMoney) {
        this.value=valueMoney;
        this.type=typeMoney;
    }

    public float getValue ()
    {
        return value;
    }
    public char getType ()
    {
        return type;
    }
}
