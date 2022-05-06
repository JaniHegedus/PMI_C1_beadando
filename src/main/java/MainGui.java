import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
public class MainGui extends JFrame
{
    public final String url = "https://img.rawpixel.com/s3fs-private/rawpixel_images/website_content/rm373batch15-217-01.jpg?w=800&dpr=1&fit=default&crop=default&q=65&vib=3&con=3&usm=15&bg=F4F4F3&ixlib=js-2.2.1&s=d8bbc66e02e81095950de55fcc9347f5";
    public final String url0 ="https://wallpaper-mania.com/wp-content/uploads/2018/09/High_resolution_wallpaper_background_ID_77701450862.jpg";
    final Image image = BackgroundImage.requestImage(url);
    final Image image0 = BackgroundImage.requestImage(url0);
    ImageIcon img = new ImageIcon("src/main/resources/icon.png");
    //BackgroundImage
    public MainGui(Medicines medicines)
    {
        // Menu
        JMenuBar mb;
        JMenu file = new JMenu("File");
        JMenuItem exit;

        // Create frame with title Registration Demo

        JFrame frame= new JFrame();
        frame.setTitle("Med Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(mb=new JMenuBar());
        file.add(exit=new JMenuItem("Exit"));
        mb.add(file);
        // Panel to define the layout. We are using GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout()){
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
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
            new AddMed(medicines,"");
        });
        button0.addActionListener(e -> {
            frame.setVisible(false);
            new ModifyMed(medicines);
        });
        button1.addActionListener(e ->{
            frame.setVisible(false);
            new ListAll(medicines);
        });
        exit.addActionListener(e ->{
            System.exit(0);
        });

        // Add panel to frame
        frame.setJMenuBar(mb);
        frame.add(panel);
        frame.pack();
        Xml newxml =  new Xml();
        frame.setSize(newxml.getdata()[0], newxml.getdata()[1]);
        frame.setResizable(false);
        frame.setIconImage(img.getImage());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public MainGui() {

    }
}
class ModifyMed extends MainGui {
    ModifyMed(Medicines medicines) {
        //BackgroundImage
        BackgroundImage newbackgroundimage = new BackgroundImage();
        final Image image = newbackgroundimage.requestImage(url);

        // Menu
        JMenuBar mb;
        JMenu file = new JMenu("File");
        JMenuItem back,exit;

        setJMenuBar(mb=new JMenuBar());
        file.add(back=new JMenuItem("Back"));
        file.add(exit=new JMenuItem("Exit"));
        mb.add(file);

        // Create frame with title Registration Demo
        JFrame frame4 = new JFrame();
        frame4.setTitle("Med Database");

        // Panel to define the layout. We are using GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout()){
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
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
            try {
                String medname = JOptionPane.showInputDialog("Removable Med: ");
                if(!medname.equals(""))
                {
                    if(medicines.contains(medname))
                    {
                        JOptionPane.showMessageDialog(this, "Operation successful!");
                        medicines.removeMedicine(medname);
                        new MainGui(medicines); // Main Form to show after the Login Form..
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Operation failed!\nGiven Medicine is not found!");
                        int reply =JOptionPane.showConfirmDialog(this,"Do you want to modyfie the existing?");
                        if(reply==JOptionPane.YES_OPTION)
                        {
                            frame4.setVisible(false);
                            new UpdateMed(medicines,medname);
                        }
                        else {
                            frame4.setVisible(false);
                            new MainGui();
                        }
                        new ModifyMed(medicines);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Operation failed!\nNo Name is given!");
                    new ModifyMed(medicines);
                }
            }catch (NullPointerException exception)
            {
                new ModifyMed(medicines);
            }

        });
        button3.addActionListener(e -> {
            frame4.setVisible(false);
            new UpdateMed(medicines,""); // Main Form to show after the Login Form..
        });
        back.addActionListener(e ->
        {
            frame4.setVisible(false);
            new MainGui(medicines);
        });
        exit.addActionListener(e ->{
            System.exit(0);
        });

        // Add panel to frame
        frame4.setJMenuBar(mb);
        frame4.add(panel);
        frame4.pack();
        Xml newxml =  new Xml();
        frame4.setSize(newxml.getdata()[0], newxml.getdata()[1]);
        frame4.setLocationRelativeTo(null);
        frame4.setIconImage(img.getImage());
        frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame4.setVisible(true);
    }
}

class ListAll extends MainGui {
    public ListAll(Medicines medicines) {

        System.out.println(medicines.ListMedicines());
        JFrame frame2 = new JFrame();

        frame2.setTitle("All Med with Description:");

        JPanel panel = new JPanel(new GridBagLayout()){
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(image0, 0, 0, null);
            }
        };
        GridBagConstraints constr = new GridBagConstraints();
        constr.insets = new Insets(5, 5, 5, 5);
        constr.anchor = GridBagConstraints.WEST;

        // Declare the required Labels
        JTextArea Content = new JTextArea(medicines.ListMedicines());
        JButton button7 = new JButton("Save to XML!");
        JButton button8 = new JButton("Back");

        // Set the initial grid values to 0,0
        constr.gridx=0;
        constr.gridy=0;

        constr.gridx=1;
        panel.add(Content, constr);
        constr.gridx=2;
        constr.gridx=0;
        constr.gridy=1;
        panel.add(button7, constr);
        constr.gridx=1;
        constr.gridx=2;
        panel.add(button8, constr);

        // add a listener to button
        button7.addActionListener(e -> {
            saveToXML(medicines);
            frame2.setVisible(false);
            JOptionPane.showMessageDialog(frame2,"Operation successful!");
            new MainGui(medicines); // Main Form to show after the Login Form..
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
        frame2.setLocationRelativeTo(null);
        frame2.setSize(Content.getWidth()+220,Content.getHeight()+100);
        frame2.setIconImage(img.getImage());
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);

    }
    public void saveToXML(Medicines medicines)
    {
        Xml.saveMedToXml(medicines.medList,"src/main/resources/medicines.xml");
    }
}
class AddMed extends MainGui
{
    public AddMed(Medicines medicines,String name)
    {
        // Menu
        JMenuBar mb;
        JMenu file = new JMenu("File");
        JMenuItem back,exit;

        setJMenuBar(mb=new JMenuBar());
        file.add(back=new JMenuItem("Back"));
        file.add(exit=new JMenuItem("Exit"));
        mb.add(file);

        // Create frame with title Registration Demo
        JFrame frame1= new JFrame();
        frame1.setTitle("Adding New Med");

        // Panel to define the layout. We are using GridBagLayout


        // Panel to define the layout. We are using GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout()){
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
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
        NameTxt.setText(name);

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
            if(!NameTxt.getText().equals("")&&!pwdTxt.getText().equals(""))
            {
                if(!medicines.contains(NameTxt.getText()))
                {
                    frame1.setVisible(false);
                    medicines.addMed(NameTxt.getText(), pwdTxt.getText());
                    JOptionPane.showMessageDialog(this, "Operation successful!");
                    new MainGui(medicines); // Main Form to show after the Login Form..
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Operation failed!\nName is taken!");
                    int reply =JOptionPane.showConfirmDialog(this,"Do you want to modyfie the existing?");
                    if(reply==JOptionPane.YES_OPTION)
                    {
                        frame1.setVisible(false);
                        new UpdateMed(medicines,NameTxt.getText());
                    }
                    else {
                        frame1.setVisible(false);
                        new MainGui();
                    }
                }
            }
            else {
                if (NameTxt.getText().equals("") && pwdTxt.getText().equals("")) JOptionPane.showMessageDialog(frame1, "Operation failed!\n No Name given!\n No Description given!");
                else if(NameTxt.getText().equals("")) JOptionPane.showMessageDialog(frame1, "Operation failed!\n No Name given!");
                else if(pwdTxt.getText().equals("")) JOptionPane.showMessageDialog(frame1, "Operation failed!\n No Description given!");
            }
        });
        back.addActionListener(e ->
        {
            frame1.setVisible(false);
            new MainGui(medicines);
        });
        exit.addActionListener(e ->{
            System.exit(0);
        });
        // Add label and button to panel
        panel.add(button6, constr);


        // Add panel to frame
        frame1.add(panel);
        frame1.pack();
        Xml newxml=  new Xml();
        frame1.setSize(newxml.getdata()[0], newxml.getdata()[1]);
        frame1.setJMenuBar(mb);
        frame1.setLocationRelativeTo(null);
        frame1.setIconImage(img.getImage());
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
}
class UpdateMed extends MainGui
{
    UpdateMed(Medicines medicines, String name)
    {

        // Menu
        JMenuBar mb;
        JMenu file = new JMenu("File");
        JMenuItem back,exit;

        setJMenuBar(mb=new JMenuBar());
        file.add(back=new JMenuItem("Back"));
        file.add(exit=new JMenuItem("Exit"));
        mb.add(file);

        //Frame
        JFrame frame1= new JFrame();
        frame1.setTitle("Modifying Existing Med Description");

        // Panel to define the layout. We are using GridBagLayout

        // Panel to define the layout. We are using GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout()){
            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
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
        NameTxt.setText(name);

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
            if(!NameTxt.getText().equals("")&&!pwdTxt.getText().equals(""))
            {
                if(medicines.contains(NameTxt.getText()))
                {
                    frame1.setVisible(false);
                    medicines.updateDes(NameTxt.getText(), pwdTxt.getText());
                    JOptionPane.showMessageDialog(frame1, "Operation successful!");
                    new MainGui(medicines); // Main Form to show after the Login Form..
                }
                else
                {
                    JOptionPane.showMessageDialog(frame1, "Operation failed!\nMedicine with given Name does not exist!");
                    int reply = JOptionPane.showConfirmDialog(this,"Do you want to create new with this name?");
                    if(reply==JOptionPane.YES_OPTION)
                    {
                        frame1.setVisible(false);
                        new AddMed(medicines,NameTxt.getText());
                    }
                    else {
                        frame1.setVisible(false);
                        new MainGui(medicines);
                    }
                }
            }
            else {
                if (NameTxt.getText().equals("") && pwdTxt.getText().equals("")) JOptionPane.showMessageDialog(frame1, "Operation failed!\n No Name given!\n No Description given!");
                else if(NameTxt.getText().equals("")) JOptionPane.showMessageDialog(frame1, "Operation failed!\n No Name given!");
                else if(pwdTxt.getText().equals("")) JOptionPane.showMessageDialog(frame1, "Operation failed!\n No Description given!");
            }
        });
        back.addActionListener(e ->
        {
            frame1.setVisible(false);
            new MainGui(medicines);
        });
        exit.addActionListener(e ->{
            System.exit(0);
        });
        // Add label and button to panel
        panel.add(button6, constr);


        // Add panel to frame
        frame1.add(panel);
        frame1.pack();
        Xml newxml=  new Xml();
        frame1.setSize(newxml.getdata()[0], newxml.getdata()[1]);
        frame1.setJMenuBar(mb);
        frame1.setIconImage(img.getImage());
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
}
class BackgroundImage extends MainGui
{
    static Image requestImage(String url)
    {
        Image image = null;
        try
        {
            image = ImageIO.read(new URL(url));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
}