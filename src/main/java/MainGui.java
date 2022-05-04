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
class ModifyMed extends MainGui {
    ModifyMed(Medicines medicines) {
        // Create frame with title Registration Demo
        JFrame frame4 = new JFrame();
        frame4.setTitle("Med Database");

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
        JLabel NameLabel = new JLabel("Remove a medicines:");
        JLabel pwdLabel = new JLabel("Modify a medicines's description :");

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
            new RemoveMed(medicines); // Main Form to show after the Login Form..
        });
        button3.addActionListener(e -> {
            frame4.setVisible(false);
            new UpdateMed(medicines); // Main Form to show after the Login Form..
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
class RemoveMed extends MainGui
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
class ListAll extends MainGui {
    public ListAll(Medicines medicines)
    {
        System.out.println(medicines.ListMedicines());
        JFrame frame2 = new JFrame();

        frame2.setTitle("All Med with Description:");

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

        JLabel NameLabel = new JLabel("Added Medicine:");
        headingPanel.add(NameLabel);


        // Set the initial grid values to 0,0
        constr.gridx=0;
        constr.gridy=0;

        // Declare the required Labels

        JTextArea Content = new JTextArea(medicines.ListMedicines());
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
            saveToXML(medicines);
            frame2.setVisible(false);
            new Done(medicines); // Main Form to show after the Login Form..
        });
        button8.addActionListener(e -> {
            frame2.setVisible(false);
            new MainGui(medicines); // Main Form to show after the Login Form..
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
    public void saveToXML(Medicines medicines)
    {
        Xml.saveMedToXml(medicines.medList,"src/main/resources/medicines.xml");
    }
}
class UpdateMed extends MainGui
{
    UpdateMed(Medicines medicines)
    {
        JFrame frame1= new JFrame();
        frame1.setTitle("Modifying Existing Med Description");

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
        JLabel NameLabel = new JLabel("Enter the name: ");
        JLabel pwdLabel = new JLabel("Enter the description: ");

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
            medicines.updateDes(NameTxt.getText(),pwdTxt.getText());
            System.out.println(NameTxt.getText());
            System.out.println(pwdTxt.getText());
            frame1.setVisible(false);
            new Done(medicines);
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
class AddMed extends MainGui
{
    public AddMed(Medicines medicines)
    {
        // Create frame with title Registration Demo
        JFrame frame1= new JFrame();
        frame1.setTitle("Adding New Med");

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
            medicines.addMed(NameTxt.getText(),pwdTxt.getText());
            frame1.setVisible(false);
            new Done(medicines);
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
class Done extends MainGui
{
    public Done(Medicines medicines)
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
            new MainGui(medicines); // Main Form to show after the Login Form..
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
