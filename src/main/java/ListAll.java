import javax.swing.*;
import java.awt.*;

import static javax.swing.JOptionPane.showMessageDialog;

public class ListAll extends MedicineGui {
    public ListAll(Reciept reciept)
    {
        System.out.println(reciept.createReceipt());
        JFrame frame2 = new JFrame();

        frame2.setTitle("All Medicine with Description:");

        JPanel headingPanel = new JPanel();
        JPanel mainPanel = new JPanel();
        JPanel underPanel = new JPanel();

        headingPanel.setLayout(new BoxLayout(headingPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        underPanel.setLayout(new BoxLayout(underPanel, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        constr.insets = new Insets(5, 5, 5, 5);
        constr.anchor = GridBagConstraints.WEST;

        JLabel NameLabel = new JLabel("Added Medicines:");
        headingPanel.add(NameLabel);


        // Set the initial grid values to 0,0
        constr.gridx=0;
        constr.gridy=0;

        // Declare the required Labels

        JTextArea Content = new JTextArea(reciept.createReceipt());
        JButton button7 = new JButton("Save to XML!");
        JButton button8 = new JButton("Ok!");

        panel.add(Content, constr);
        constr.gridx=0;
        constr.gridy=1;
        panel.add(button7, constr);
        constr.gridx=1;
        panel.add(button8, constr);
        constr.gridx=1;

        // add a listener to button
        button7.addActionListener(e -> {
            saveToXML(reciept);
            frame2.setVisible(false);
            new Done(reciept); // Main Form to show after the Login Form..
        });
        button8.addActionListener(e -> {
            frame2.setVisible(false);
            new MedicineGui(reciept); // Main Form to show after the Login Form..
        });

        // Add label and button to panel
        panel.add(Content);

        // Add panel to frame
        frame2.add(panel);
        frame2.pack();
        Xml newxml =  new Xml();
        frame2.setSize(newxml.getdata()[2], newxml.getdata()[3]);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);

    }
    public void saveToXML(Reciept reciept)
    {
        Xml.saveMedToXml(reciept.medicineList,"src/main/resources/medicine.xml");
    }
}
