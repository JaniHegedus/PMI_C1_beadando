
public class Medicines extends Medicine
{
    public void addMed(String name, String des)
    {
        boolean contains = false;
        for(Med med : medList)
        {
            if(med.equals(name))
            {
                contains=true;
            }
        }
        if(!contains)
        {
            super.medList.add(new Med(name,des));
        }
    }
    public void updateDes(String name, String des)
    {
        for (int i = 0; i < super.medList.size(); i++) {
            if(super.medList.get(i).getName()==name)
            {
                super.medList.get(i).setDes(des);
            }
        }
    }
    public void removeMedicine(String name)
    {
        for (int i = 0; i < super.medList.size(); i++) {
            if(super.medList.get(i).getName() == name)
            {
                super.medList.remove(i);
            }
        }
    }
}
