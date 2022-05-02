import javax.swing.*;
import java.awt.*;


public class MainGui extends JFrame
{
    public MainGui() {
    }
    public MainGui(Medicines medicines)
    {

         // Create frame with title Registration Demo
        JFrame frame= new JFrame();
        frame.setTitle("Med Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Panel to define the layout. We are using GridBagLayout
        JPanel mainPanel = new JPanel();
        JLabel headingLabel = new JLabel("");
        mainPanel.add(headingLabel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));



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
        JLabel NameLabel = new JLabel("Add new medicines :");
        JLabel pwdLabel = new JLabel("Modify existing medicines :");
        JLabel list = new JLabel("List all medicines :");

        // Declare Text fields
        JButton button = new JButton("Add New");
        JButton button0 = new JButton("Modify");
        JButton button1 = new JButton("List all");

        panel.add(NameLabel, constr);
        constr.gridx=1;
        panel.add(button, constr);
        constr.gridx=0; constr.gridy=1;

        panel.add(pwdLabel, constr);
        constr.gridx=1;
        panel.add(button0, constr);
        constr.gridx=0; constr.gridy=2;

        panel.add(list, constr);
        constr.gridx=1;
        panel.add(button1, constr);
        constr.gridx=0; constr.gridy=2;

        constr.gridwidth = 2;
        constr.anchor = GridBagConstraints.CENTER;

        // add a listener to button
        button.addActionListener(e -> {
            frame.setVisible(false);
            new AddMed(medicines);
        });
        button0.addActionListener(e -> {
            frame.setVisible(false);
            new ModifyMed(medicines);
        });
        button1.addActionListener(e ->{
            frame.setVisible(false);
            new ListAll(medicines);
        });
        // Add label and button to panel

        mainPanel.add(panel);

        // Add panel to frame
        frame.add(mainPanel);
        frame.pack();
        Xml newxml =  new Xml();
        frame.setSize(newxml.getdata()[0], newxml.getdata()[1]);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}