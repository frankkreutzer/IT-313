import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

	private MyPanel p;
    public MyFrame()
    {
        super("Drawing Example");
        p = new MyPanel();
        p.setLayout(new FlowLayout());
       
        setContentPane(p);
        setSize(600, 600);
        setVisible(true);
    }
}