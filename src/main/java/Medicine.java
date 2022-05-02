import java.util.ArrayList;

public class Medicine extends Med
{
    protected ArrayList<Med> medList =new ArrayList<>();
    public String ListMedicines()
    {
        String result = "";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < medList.size(); i++)
        {
            result+= medList.get(i).getName()+" "+ medList.get(i).getDes();
            builder.append(medList.get(i).getName()).append(" ").append(medList.get(i).getDes());
            if (i< medList.size())
            {
                result+=",\r\n";
                builder.append("\r\n");
            }
        }
        //return result;
        return builder.toString();
    }
}
