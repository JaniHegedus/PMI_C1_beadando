import javax.swing.*;
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
    public String[][] createStringArray()
    {
        String newArray[][] = new String[medList.size()][];
        for(Med med : medList)
        {
            String[] innerArray = new String[2];
            innerArray[0]=med.getName();
            innerArray[1]=med.getDes();
            newArray[medList.indexOf(med)]=innerArray;
        }
        return newArray;
    }
    public String[] createNameArray()
    {
        String newArray[] = new String[medList.size()];
        for(Med med : medList)
        {
            newArray[medList.indexOf(med)]=med.getName();
        }
        return newArray;
    }
    public void generateMed(Medicines medicines,JFrame frame)
    {
        String test[][] = new String[2][];
        String[] names = {"Rubifen","Strepsils","Aspirin","Alprazolam","Abilify","Ambien","Azithromycin","Bupropion","Actos","Amitriptyline"};
        String[] descriptions =
                {
                "Lozenges for Adults and Children Over Six contains two antiseptic ingredients for use in throat medications.",
                "Used to treat a behavioural disorder called Attention Deficit Hyperactivity Disorder (ADHD).",
                "Its also called acetylsalicylic acid, derivative of salicylic acid that is a mild nonnarcotic analgesic (pain reliever) useful in the relief of headache and muscle and joint aches.",
                "It is used to treat anxiety and panic disorders. It belongs to a class of medications called benzodiazepines which act on the brain and nerves (central nervous system) to produce a calming effect. It works by enhancing the effects of a certain natural chemical in the body (GABA)",
                "Aripiprazole is used to treat certain mental/mood disorders (such as bipolar disorder, schizophrenia, Tourette's syndrome, and irritability associated with autistic disorder). It may also be used in combination with other medication to treat depression. Aripiprazole is known as an antipsychotic drug (atypical type). It works by helping to restore the balance of certain natural chemicals in the brain (neurotransmitters).This medication can decrease hallucinations and improve your concentration. It helps you to think more clearly and positively about yourself, feel less nervous, and take a more active part in everyday life. Aripiprazole can treat severe mood swings and decrease how often mood swings occur.",
                "Zolpidem is used for a short time to treat a certain sleep problem (insomnia) in adults. If you have trouble falling asleep, it helps you fall asleep faster, so you can get a better night's rest. Zolpidem belongs to a class of drugs called sedative-hypnotics. It acts on your brain to produce a calming effect.",
                "Azithromycin is used to treat a wide variety of bacterial infections. It is a macrolide-type antibiotic. It works by stopping the growth of bacteria.This medication will not work for viral infections (such as common cold, flu). Unnecessary use or misuse of any antibiotic can lead to its decreased effectiveness.",
                "This medication is used to treat depression. It can improve your mood and feelings of well-being. It may work by restoring the balance of certain natural substances (dopamine, norepinephrine) in the brain.",
                "Pioglitazone is a diabetes drug (thiazolidinedione-type, also called glitazones) used along with a proper diet and exercise program to control high blood sugar in patients with type 2 diabetes. It works by helping to restore your body's proper response to insulin, thereby lowering your blood sugar.Controlling high blood sugar helps prevent kidney damage, blindness, nerve problems, loss of limbs, and sexual function problems. Proper control of diabetes may also lessen your risk of a heart attack or stroke.Pioglitazone is used either alone or in combination with other diabetes medications (such as metformin or a sulfonylurea such as glyburide).Talk to your doctor about the risks and benefits of pioglitazone.",
                "This medication is used to treat mental/mood problems such as depression. It may help improve mood and feelings of well-being, relieve anxiety and tension, help you sleep better, and increase your energy level. This medication belongs to a class of medications called tricyclic antidepressants. It works by affecting the balance of certain natural chemicals (neurotransmitters such as serotonin) in the brain."
                };
        boolean contains = false;
        for (int i = 0; i < names.length; i++)
            {
                if (!contains(names[i])) {
                    medicines.addMed(names[i], descriptions[i]);
                }
                else contains = true;
            }
        if(contains) JOptionPane.showMessageDialog(frame,"Already Added");
        else JOptionPane.showMessageDialog(frame ,"Test Data is Generated!");
    }
}
