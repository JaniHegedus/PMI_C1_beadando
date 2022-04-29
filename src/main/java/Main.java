import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
       Reciept reciept = new Reciept();
       reciept.addMed("Rubofen","Napi egyszer lefekvés előtt");
       reciept.updateDes("Rubofen","Ne használja");
       reciept.removeMedicine("Rubofen");
    }
}
