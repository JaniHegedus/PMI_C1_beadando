public class Reciept extends Medicines
{

    public void addMed(String name, String des)
    {
        boolean contains = false;
        for(Medicine medicine: medicineList)
        {
            if(medicine.equals(name))
            {
                contains=true;
            }
        }
        if(!contains)
        {
            super.medicineList.add(new Medicine(name,des));
        }
    }
    public void addGoods(Medicine name)
    {
        boolean contains = false;
        for(Medicine medicine:medicineList)
        {
            if(medicine.equals(name))
            {
                contains=true;
            }
        }
        if(!contains)
        {
            super.medicineList.add(name);
        }
    }
    public void updateDes(String name, String des)
    {
        for (int i = 0; i < super.medicineList.size(); i++) {
            if(super.medicineList.get(i).getName()==name)
            {
                super.medicineList.get(i).setDes(des);
            }
        }
    }
    public void removeMedicine(String name)
    {
        for (int i = 0; i < super.medicineList.size(); i++) {
            if(super.medicineList.get(i).getName() == name)
            {
                super.medicineList.remove(i);
            }
        }
    }
}
