import java.util.ArrayList;

public class Med
{
    private String name;
    private String des;

    public Med() {
    }

    public Med(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {this.des = des;}
}
class Medicine extends Med
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
            if (i< medList.size()-1)
            {
                result+=",\r\n";
                builder.append("\r\n");
            }
        }
        //return result;
        return builder.toString();
    }
}
class Medicines extends Medicine
{
    public void addMed(String name, String des)
    {
        super.medList.add(new Med(name,des));
    }
    public boolean contains(String name)
    {
        boolean contains = false;
        for(Med med : medList)
        {
            if(med.getName().equals(name))
            {
                contains=true;
            }
        }
        return contains;
    }
    public void updateDes(String name, String des)
    {
        for (int i = 0; i < super.medList.size(); i++) {
            if(super.medList.get(i).getName().equals(name))
            {
                super.medList.get(i).setDes(des);
            }
        }
    }
    public void removeMedicine(String name)
    {
        for (int i = 0; i < super.medList.size(); i++) {
            if(super.medList.get(i).getName().equals(name))
            {
                super.medList.remove(i);
            }
        }
    }
}
