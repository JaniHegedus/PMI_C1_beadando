import java.util.ArrayList;

public class Medicines extends Medicine
{
    protected ArrayList<Medicine> medicineList =new ArrayList<>();
    public String createReceipt()
    {
        String result = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < medicineList.size(); i++)
        {
            result+=medicineList.get(i).getName()+" "+medicineList.get(i).getDes();
            builder.append(medicineList.get(i).getName()).append(" ").append(medicineList.get(i).getDes());
            if (i<medicineList.size())
            {
                result+=",\r\n";
                builder.append("\r\n");
            }
        }
        //return result;
        return builder.toString();
    }
}
