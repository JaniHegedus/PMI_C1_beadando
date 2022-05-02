import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Done extends MedicineGui
{
    public Done(Reciept reciept)
    {
        JFrame frame2 = new JFrame();

        frame2.setTitle("Done");

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constr = new GridBagConstraints();
        constr.insets = new Insets(5, 5, 5, 5);
        constr.anchor = GridBagConstraints.WEST;

        // Set the initial grid values to 0,0
        constr.gridx=0;
        constr.gridy=0;

        // Declare the required Labels
        JLabel NameLabel = new JLabel("The Operation was successfull!");
        JButton button7 = new JButton("Ok!");

        panel.add(NameLabel, constr);
        constr.gridx=1;
        panel.add(button7, constr);
        constr.gridx=0; constr.gridy=1;

        // add a listener to button
        button7.addActionListener(e -> {
            frame2.setVisible(false);
            new MedicineGui(reciept); // Main Form to show after the Login Form..
        });
        // Add label and button to panel
        panel.add(button7, constr);
        mainPanel.add(panel);

        // Add panel to frame
        frame2.add(mainPanel);
        frame2.pack();
        Xml newxml=  new Xml();
        frame2.setSize(newxml.getdata()[0], newxml.getdata()[1]);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
    }
}
