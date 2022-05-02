public class Main{
    public static void main(String[] args)
    {
        Medicines medicines = new Medicines();
        medicines.addMed("Rubifen","Rubifen is used to treat a behavioural disorder called Attention Deficit Hyperactivity Disorder (ADHD).");
        medicines.addMed("Strepsils","Strepsils Lozenges for Adults and Children Over Six contains two antiseptic ingredients for use in throat medications.");
        new MainGui(medicines);
    }

}

