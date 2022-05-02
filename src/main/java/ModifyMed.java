import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ModifyMed extends MedicineGui {
    ModifyMed(Reciept reciept) {
        // Create frame with title Registration Demo
        JFrame frame4 = new JFrame();
        frame4.setTitle("Medicine Database");

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
        constr.gridx = 0;
        constr.gridy = 0;

        // Declare the required Labels
        JLabel NameLabel = new JLabel("Remove a medicine:");
        JLabel pwdLabel = new JLabel("Modify a medicine's description :");

        // Declare Text fields
        JButton button2 = new JButton("Remove");
        JButton button3 = new JButton("Modify");

        panel.add(NameLabel, constr);
        constr.gridx = 1;
        panel.add(button2, constr);
        constr.gridx = 0;
        constr.gridy = 1;

        panel.add(pwdLabel, constr);
        constr.gridx = 1;
        panel.add(button3, constr);
        constr.gridx = 0;
        constr.gridy = 2;

        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;
        //constr.anchor = GridBagConstraints.CENTER;

        // add a listener to button
        button2.addActionListener(e -> {
            frame4.setVisible(false);
            new RemoveMed(reciept); // Main Form to show after the Login Form..
        });
        button3.addActionListener(e -> {
            frame4.setVisible(false);
            new UpdateMed(reciept); // Main Form to show after the Login Form..
        });
        // Add label and button to panel


        mainPanel.add(headingPanel);
        mainPanel.add(panel);

        // Add panel to frame
        frame4.add(mainPanel);
        frame4.pack();
        Xml newxml=  new Xml();
        frame4.setSize(newxml.getdata()[0], newxml.getdata()[1]);
        frame4.setLocationRelativeTo(null);
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(true);
    }
}