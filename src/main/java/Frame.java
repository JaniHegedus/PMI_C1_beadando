import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Frame
{
    public static void main(String[] args)
    {
        Window t = new Window();
        t.teszt();
    }
}
class Window extends JFrame implements ActionListener
{
    JFrame ablak = new JFrame();
    JTextField text = new JTextField(10);
    JButton Rbutton = new JButton("Piros");
    JButton Ybutton = new JButton("Sárga");
    JButton Gbutton = new JButton("Zöld");
    JButton Exit = new JButton("Exit");
    public void teszt()
    {
        ablak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ablak.setLayout(new FlowLayout());
        ablak.setLocation(400, 400);
        ablak.setTitle("Teszt");
        ablak.add(Rbutton);
        ablak.add(Ybutton);
        ablak.add(Gbutton);
        ablak.add(Exit);
        ablak.add(text);
        ablak.setSize(400, 150);
        ablak.setVisible(true);
        Rbutton.addActionListener(this);
        Ybutton.addActionListener(this);
        Gbutton.addActionListener(this);
        Exit.addActionListener(this);
    }
    @Override public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == Rbutton) text.setBackground(Color.red);
        else if(e.getSource() == Ybutton)text.setBackground(Color.yellow);
        else if(e.getSource() == Gbutton)text.setBackground(Color.green);
        else if(e.getSource() == Exit)System.exit(0);
    }
}