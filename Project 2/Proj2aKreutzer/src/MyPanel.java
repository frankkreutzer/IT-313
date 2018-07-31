// Drawing Example
// Source code file: MyPanel.java
// Define panel based on Swing class 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel {

	public MyPanel( ) {
		setBackground(Color.white);
	}
	
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);
	
        // Print title.
        g.setFont(new Font("arial", Font.BOLD, 30));
        g.setColor(Color.black);
        g.drawString("Java Street Sign Art", 150, 60);
        
        // Creating the Yield sign \\
        // Create the primary white triangle
        g.setColor( Color.black );
        g.drawPolygon(new int[] {100, 200, 300}, new int[] {99, 300, 99}, 3);
        
        // Create the secondary red triangle
        g.setColor( Color.red );
        g.fillPolygon(new int[] {110, 200, 290}, new int[] {105, 288, 105}, 3);
        
        // Create inner white triangle
        g.setColor( Color.white );
        g.fillPolygon(new int[] {140, 200, 260}, new int[] {125, 238, 125}, 3);  
        
        // Create the "YIELD" text on the sign
        g.setFont(new Font("arial", Font.BOLD, 30));
        g.setColor(Color.red);
        g.drawString("YIELD", 155, 155);
        
        
        // Creating the Stop sign \\
        // Create outer white octagon
        g.setColor(Color.black);
        g.drawPolygon(new int[] {400, 451, 487, 487, 451, 400, 364, 364}, new int[] {400, 400, 436, 487, 523, 523, 487, 436}, 8);
        
        // Create inner red octagon
        g.setColor(Color.red);
        g.fillPolygon(new int[] {401, 450, 482, 482, 450, 401, 369, 369}, new int[] {405, 405, 437, 486, 518, 518, 486, 437}, 8);

        // Create "STOP" text on the sign
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.BOLD, 36));
        g.drawString("STOP", 377, 476);
        
        
        // Create Do Not Enter Sign \\
        // Creating rounded square backgorund
        g.setColor(Color.black);
        g.drawRoundRect(50, 350, 175, 175, 15, 15);

        // Creating circle
        g.setColor(Color.red);
        g.fillOval(53, 353 , 170, 170);
        
        // Creating white horizontal bar
        g.setColor(Color.white);
        g.fillRoundRect(65, 430, 145, 20, 10, 10);
        
        // Create "DO NOT" text on sign
        g.setFont(new Font("arial", Font.BOLD, 30));
        g.drawString("DO NOT", 80, 415);
        
        // Create "DO NOT" text on sign
        g.setFont(new Font("arial", Font.BOLD, 30));
        g.drawString("ENTER", 85, 485);
        
        
        // Create Wabash Ave. street sign \\
        // Create primary green rectangle
        g.setColor(new Color(0x308446, false));
        g.fillRect(315, 275, 225, 65);
        g.setColor(Color.black);
        g.drawRect(308, 269, 238, 76);
        
        // Create "S WABASH AV" text on sign
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.BOLD, 20));
        g.drawString("S", 328, 312);
        g.setFont(new Font("arial", Font.BOLD, 40));
        g.drawString("Wabash", 348, 320);
        g.setFont(new Font("arial", Font.BOLD, 20));
        g.drawString("Av", 508, 312);
        
        
        
        
	}
}
