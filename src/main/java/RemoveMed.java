import javax.swing.*;
import java.awt.*;

public class RemoveMed extends MainGui
{
    RemoveMed(Medicines medicines)
    {
        // Create frame with title Registration Demo
        JFrame frame0 = new JFrame();
        frame0.setTitle("Remove MedicineS");

        // Panel to define the layout. We are using GridBagLayout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("");
        headingPanel.add(headingLabel);

        // Panel to define the layout. We are using GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        // Constraints for the layout
        GridBagConstraints constr = new GridBagConstraints();
        constr.insets = new Insets(5, 5, 5, 5);
        constr.anchor = GridBagConstraints.WEST;

        // Set the initial grid values to 0,0
        constr.gridx=0;
        constr.gridy=0;

        // Declare the required Labels
        JLabel NameLabel = new JLabel("Enter the name :");

        // Declare Text fields
        JTextField NameTxt = new JTextField(20);

        panel.add(NameLabel, constr);
        constr.gridx=1;
        panel.add(NameTxt, constr);
        constr.gridx=0; constr.gridy=1;

        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;

        // Button with text "Register"
        JButton button4 = new JButton("Done!");
        // add a listener to button
        button4.addActionListener(e -> {
            medicines.removeMedicine(NameTxt.getText());
            new Done(medicines);
        });

        // Add label and button to panel
        panel.add(button4, constr);

        mainPanel.add(headingPanel);
        mainPanel.add(panel);

        // Add panel to frame
        frame0.add(mainPanel);
        frame0.pack();
        Xml newxml=  new Xml();
        frame0.setSize(newxml.getdata()[0], newxml.getdata()[1]);
        frame0.setLocationRelativeTo(null);
        frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame0.setVisible(true);
    }
}
