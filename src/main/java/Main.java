public class Main extends Xml {
    public static void main(String[] args)
    {
        Reciept reciept = new Reciept();
        reciept.addMed("Rubifen","Rubifen is used to treat a behavioural disorder called Attention Deficit Hyperactivity Disorder (ADHD).");
        reciept.addMed("Strepsils","Strepsils Lozenges for Adults and Children Over Six contains two antiseptic ingredients for use in throat medications.");
        new MedicineGui(reciept);
    }

}

