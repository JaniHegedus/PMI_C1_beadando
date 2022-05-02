import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AddMed extends MedicineGui
{
    public AddMed(Reciept reciept)
    {
        // Create frame with title Registration Demo
        JFrame frame1= new JFrame();
        frame1.setTitle("Adding New Medicine");

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
        JLabel pwdLabel = new JLabel("Enter the description :");

        // Declare Text fields
        JTextField NameTxt = new JTextField(20);
        JTextField pwdTxt = new JTextField(20);

        panel.add(NameLabel, constr);
        constr.gridx=1;
        panel.add(NameTxt, constr);
        constr.gridx=0; constr.gridy=1;

        panel.add(pwdLabel, constr);
        constr.gridx=1;
        panel.add(pwdTxt, constr);
        constr.gridx=0; constr.gridy=2;

        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;

        // Button with text "Register"
        JButton button6 = new JButton("Done!");
        // add a listener to button
        button6.addActionListener(e -> {
            reciept.addMed(NameTxt.getText(),pwdTxt.getText());
            frame1.setVisible(false);
            new Done(reciept);
        });

        // Add label and button to panel
        panel.add(button6, constr);

        mainPanel.add(headingPanel);
        mainPanel.add(panel);

        // Add panel to frame
        frame1.add(mainPanel);
        frame1.pack();
        Xml newxml=  new Xml();
        frame1.setSize(newxml.getdata()[0], newxml.getdata()[1]);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
}