import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
public class MainGui extends JFrame
{
    public final String url = "https://img.rawpixel.com/s3fs-private/rawpixel_images/website_content/rm373batch15-217-01.jpg?w=800&dpr=1&fit=default&crop=default&q=65&vib=3&con=3&usm=15&bg=F4F4F3&ixlib=js-2.2.1&s=d8bbc66e02e81095950de55fcc9347f5";
    public final String url0 ="https://wallpaper-mania.com/wp-content/uploads/2018/09/High_resolution_wallpaper_background_ID_77701450862.jpg";

    public final Image image = BackgroundImage.requestImage(url);
    public final Image image0 = BackgroundImage.requestImage(url0);

    public ImageIcon img = new ImageIcon("src/main/resources/icon.png");
    //BackgroundImage
    public MainGui(Medicines medicines)
    {
        // Menu
        JMenuBar mb;
        JMenu file = new JMenu("File");
        JMenuItem exit,generate;

        // Create frame with title Registration Demo

        JFrame frame= new JFrame();
        frame.setTitle("Med Database");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(mb=new JMenuBar());
        file.add(generate=new JMenuItem("Generate test Data"));
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
            new AddMed(medicines,"","");
        });
        button0.addActionListener(e -> {
            frame.setVisible(false);
            new ModifyMed(medicines);
        });
        button1.addActionListener(e ->{
            frame.setVisible(false);
            new ListAll(medicines);
        });
        generate.addActionListener(e -> medicines.generateMed(medicines,frame));
        exit.addActionListener(e -> System.exit(0));

        // Add panel to frame
        frame.setJMenuBar(mb);
        frame.add(panel);
        frame.pack();
        frame.setSize(Xml.getdata()[0], Xml.getdata()[1]);
        frame.setResizable(false);
        frame.setIconImage(img.getImage());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public MainGui() {
    }
    boolean onlySpaces(String str) {
        return str.trim().length() == 0;
    }
}
class ModifyMed extends MainGui
{
    ModifyMed(Medicines medicines) {
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
            try {
                String rename = JOptionPane.showInputDialog("Removable Med: ");
                if(!rename.equals("")&&!onlySpaces(rename))
                {
                    if(medicines.contains(rename))
                    {
                        frame4.setVisible(false);
                        JOptionPane.showMessageDialog(this, "Operation successful!");
                        medicines.removeMedicine(rename);
                        new MainGui(medicines); // Main Form to show after the Login Form.
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "Operation failed!\nMedicine with given Name is not found!");
                        int reply =JOptionPane.showConfirmDialog(this,"Do you want to create new with given name?");
                        if(reply==JOptionPane.YES_OPTION)
                        {
                            frame4.setVisible(false);
                            new AddMed(medicines,rename,"");
                        }
                    }
                }
                else
                {
                    frame4.setVisible(false);
                    JOptionPane.showMessageDialog(this, "Operation failed!\nNo Name is given!");
                    new ModifyMed(medicines);
                }
            }catch (NullPointerException exception)
            {
                frame4.setVisible(false);
                new ModifyMed(medicines);
            }

        });
        button3.addActionListener(e -> {
            frame4.setVisible(false);
            new UpdateMed(medicines,"",""); // Main Form to show after the Login Form.
        });
        back.addActionListener(e ->
        {
            frame4.setVisible(false);
            new MainGui(medicines);
        });
        exit.addActionListener(e -> System.exit(0));

        frame4.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new MainGui(medicines);
            }
        });
        // Add panel to frame
        frame4.setJMenuBar(mb);
        frame4.add(panel);
        frame4.pack();
        frame4.setSize(Xml.getdata()[0], Xml.getdata()[1]);
        frame4.setLocationRelativeTo(null);
        frame4.setIconImage(img.getImage());
        frame4.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame4.setVisible(true);
    }
}

class ListAll extends MainGui {
    public ListAll(Medicines medicines)
    {
        System.out.println(medicines.ListMedicines());
        JFrame frame2 = new JFrame();
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenu med = new JMenu("Medicine");
        JMenu modify;
        JMenuItem exit,generate,remove,update,added,removea;
        file.add(generate=new JMenuItem("Generate test Data"));
        file.add(exit=new JMenuItem("Exit"));

        med.add(added = new JMenuItem("Add") );
        med.add(modify = new JMenu("Modify") );
        med.add(removea = new JMenuItem("Remove all") );

        modify.add(remove = new JMenuItem("Remove"));
        modify.add(update = new JMenuItem("Update"));

        mb.add(file);
        mb.add(med);

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
        String[] col = {"Name","Description"};

        JTable table = new JTable()
        {
            final DefaultTableCellRenderer renderCENTER = new DefaultTableCellRenderer();

            { // initializer block
                renderCENTER.setHorizontalAlignment(SwingConstants.CENTER);
            }

            @Override
            public TableCellRenderer getCellRenderer (int arg0, int arg1)
            {
                return renderCENTER;
            }
        };
        table.setBounds(0,0,400,500);

        JScrollPane scrollPane = new JScrollPane(table);
        //JTextArea Content = new JTextArea(medicines.ListMedicines());
        JButton button7 = new JButton("Save to XML!");
        JButton button8 = new JButton("Back to Main");

        // Set the initial grid values to 0,0
        constr.gridy=0;

        constr.gridx=1;
        //panel.add(Content, constr);
        panel.add(scrollPane, constr);
        constr.gridx=0;
        constr.gridy=1;
        panel.add(button7, constr);
        constr.gridx=2;
        panel.add(button8, constr);

        // add a listener to button
        button7.addActionListener(e -> {
            saveToXML(medicines);
            frame2.setVisible(false);
            JOptionPane.showMessageDialog(frame2,"Operation successful!");
            new MainGui(medicines); // Main Form to show after the Login Form.
        });
        button8.addActionListener(e -> {
            frame2.setVisible(false);
            new MainGui(medicines); // Main Form to show after the Login Form.
        });
        added.addActionListener(e -> {
            frame2.setVisible(false);
            new AddMed(medicines,"","");
        });
        update.addActionListener(e ->{
            frame2.setVisible(false);
            Component source = (Component) e.getSource();
            String response = (String) JOptionPane.showInputDialog(source,"Choose One?", "Update", JOptionPane.QUESTION_MESSAGE, null, medicines.createNameArray(), medicines.createNameArray()[0]);
            for(Med meds:medicines.medList)
            {
                if(meds.getName().equals(response))
                {
                    new UpdateMed(medicines,meds.getName(),meds.getDes());
                }
            }

        });
        remove.addActionListener(e ->{
            frame2.setVisible(false);
            Component source = (Component) e.getSource();
            String response = (String) JOptionPane.showInputDialog(source,"Choose One?", "Remove", JOptionPane.QUESTION_MESSAGE, null, medicines.createNameArray(), medicines.createNameArray()[0]);
            medicines.removeMedicine(response);
            JOptionPane.showMessageDialog(this,"Operation successful!");
            new ListAll(medicines);
        });
        generate.addActionListener(e ->
        {
            frame2.setVisible(false);
            medicines.generateMed(medicines,frame2);
            new ListAll(medicines);
        });
        removea.addActionListener(e -> {
            if (!medicines.medList.isEmpty()){
                medicines.removeAll();
                frame2.setVisible(false);
                JOptionPane.showMessageDialog(this ,"All added Medicine is removed");
                new ListAll(medicines);
            }
            else JOptionPane.showMessageDialog(this ,"The Medicine List is empty");
        });
        exit.addActionListener(e -> System.exit(0));
        // Editable Table
        DefaultTableModel tableModel = new DefaultTableModel(medicines.createStringArray(),col) {

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };

        table.setModel(tableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(125);
        table.getColumnModel().getColumn(1).setPreferredWidth(table.getWidth()-table.getColumnModel().getColumn(0).getWidth());

        //Table Content Double Click
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                    if (me.getClickCount() == 2) {     // to detect double click events
                    JTable target = (JTable)me.getSource();
                    int row = target.getSelectedRow(); // select a row
                    int column = target.getSelectedColumn(); // select a column
                    JOptionPane.showMessageDialog(null, table.getValueAt(row, column)); // get the value of a row and column.
                }
            }
        });
        table.getTableHeader().setResizingAllowed(false);
        // Add panel to frame
        frame2.add(panel);
        frame2.pack();
        frame2.setLocationRelativeTo(null);
        //frame2.setSize(Content.getWidth()+220,Content.getHeight()+100);
        System.out.println(table.getHeight());
        frame2.setSize(800,600);
        frame2.setJMenuBar(mb);
        frame2.setIconImage(img.getImage());
        frame2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame2.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new MainGui(medicines);
            }
        });
        frame2.setVisible(true);

    }
    public void saveToXML(Medicines medicines)
    {
        Xml.saveMedToXml(medicines.medList,"src/main/resources/medicines.xml");
    }
}
class AddMed extends MainGui
{
    public AddMed(Medicines medicines,String name,String des)
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
        pwdTxt.setText(des);

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
            if(!NameTxt.getText().equals("")&&!pwdTxt.getText().equals("")&&!onlySpaces(NameTxt.getText())&&!onlySpaces(pwdTxt.getText()))
            {
                if(!medicines.contains(NameTxt.getText()))
                {
                    frame1.setVisible(false);
                    medicines.addMed(NameTxt.getText(), pwdTxt.getText());
                    JOptionPane.showMessageDialog(this, "Operation successful!");
                    new MainGui(medicines); // Main Form to show after the Login Form.
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Operation failed!\nName is taken!");
                    int reply =JOptionPane.showConfirmDialog(this,"Do you want to modify the existing?");
                    if(reply==JOptionPane.YES_OPTION)
                    {
                        frame1.setVisible(false);
                        for(Med meds:medicines.medList)
                        {
                            if(NameTxt.getText().equals(meds.getName())) new UpdateMed(medicines, meds.getName(), meds.getDes());
                        }

                    }
                }
            }
            else {
                if (NameTxt.getText().equals("") && pwdTxt.getText().equals("")||(onlySpaces(NameTxt.getText())&&onlySpaces(pwdTxt.getText()))) JOptionPane.showMessageDialog(frame1, "Operation failed!\n No Name given!\n No Description given!");
                else if(NameTxt.getText().equals("")||onlySpaces(NameTxt.getText())) JOptionPane.showMessageDialog(frame1, "Operation failed!\n No Name given!");
                else if(pwdTxt.getText().equals("")||onlySpaces(pwdTxt.getText())) JOptionPane.showMessageDialog(frame1, "Operation failed!\n No Description given!");
                else System.out.println("This cant happen!");
            }
        });
        back.addActionListener(e ->
        {
            frame1.setVisible(false);
            new MainGui(medicines);
        });
        exit.addActionListener(e -> System.exit(0));
        // Add label and button to panel
        panel.add(button6, constr);

        // Add panel to frame
        frame1.add(panel);
        frame1.pack();
        frame1.setSize(Xml.getdata()[0], Xml.getdata()[1]);
        frame1.setJMenuBar(mb);
        frame1.setLocationRelativeTo(null);
        frame1.setIconImage(img.getImage());
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new MainGui(medicines).setVisible(true);
            }
        });
        frame1.setVisible(true);
    }
}
class UpdateMed extends MainGui
{
    UpdateMed(Medicines medicines, String name,String des)
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
        pwdTxt.setText(des);

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
                    new MainGui(medicines); // Main Form to show after the Login Form.
                }
                else
                {
                    JOptionPane.showMessageDialog(frame1, "Operation failed!\nMedicine with given Name does not exist!");
                    int reply = JOptionPane.showConfirmDialog(this,"Do you want to create new with this name?");
                    if(reply==JOptionPane.YES_OPTION)
                    {
                        frame1.setVisible(false);
                        new AddMed(medicines,NameTxt.getText(),pwdTxt.getText());
                    }
                }
            }
            else {

                if (NameTxt.getText().equals("") && pwdTxt.getText().equals("")||(onlySpaces(NameTxt.getText())&&onlySpaces(pwdTxt.getText()))) JOptionPane.showMessageDialog(frame1, "Operation failed!\n No Name given!\n No Description given!");
                else if(NameTxt.getText().equals("")||onlySpaces(NameTxt.getText())) JOptionPane.showMessageDialog(frame1, "Operation failed!\n No Name given!");
                else if(pwdTxt.getText().equals("")||onlySpaces(pwdTxt.getText())) JOptionPane.showMessageDialog(frame1, "Operation failed!\n No Description given!");
                else System.out.println("This cant happen!");
            }
        });
        back.addActionListener(e ->
        {
            frame1.setVisible(false);
            new MainGui(medicines);
        });
        exit.addActionListener(e -> System.exit(0));
        // Add label and button to panel
        panel.add(button6, constr);

        // Add panel to frame
        frame1.add(panel);
        frame1.pack();
        frame1.setSize(Xml.getdata()[0], Xml.getdata()[1]);
        frame1.setJMenuBar(mb);
        frame1.setIconImage(img.getImage());
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new MainGui(medicines).setVisible(true);
            }
        });
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
class SplashScreen extends MainGui
{
    JFrame frame;
    JPanel panel = new JPanel(new GridBagLayout()){
        @Override
        protected void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(image0, 0, 0, null);
        }
    };
    JLabel text=new JLabel("Medicine Database");
    JProgressBar progressBar=new JProgressBar();
    JLabel message=new JLabel();//Crating a JLabel for displaying the message
    public SplashScreen(Medicines medicines)
    {
        createGUI();
        addText();
        addProgressBar();
        runningPBar();
        new MainGui(medicines);
    }
    public void createGUI(){
        frame=new JFrame();
        frame.add(panel);
        panel.setBounds(0,0,600,400);
        frame.getContentPane().setLayout(null);
        frame.setUndecorated(true);
        frame.setSize(600,200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public void addText()
    {
        text.setFont(new Font("arial",Font.BOLD,30));
        text.setBounds(160,50,600,40);
        text.setForeground(Color.BLUE);
        panel.add(text);
    }
    public void addProgressBar(){
        progressBar.setBounds(100,100,400,30);
        progressBar.setBorderPainted(true);
        progressBar.setStringPainted(true);
        progressBar.setBackground(Color.WHITE);
        progressBar.setForeground(Color.BLACK);
        progressBar.setValue(0);
        panel.add(progressBar);
    }
    public void runningPBar(){
        int i=0;//Creating an integer variable and initializing it to 0

        while( i<=100)
        {
            try{
                Thread.sleep(15);//Pausing execution for 50 milliseconds
                progressBar.setValue(i);//Setting value of Progress Bar
                message.setText("LOADING "+ i +"%");//Setting text of the message JLabel
                i++;
                if(i==100)
                    frame.dispose();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}