
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GUI extends JFrame{
	
	private JButton btn1 = new JButton("Analyze");
	private JButton btn2 = new JButton("Generate");
	
	public GUI() {
		super("GUI");
		this.setBounds(250, 250, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3, 2, 2, 2));
		
//		btn1.addActionListener(new AnalyzeButtonEvent());
//		btn2.addActionListener(new GenerateButtonEvent());
		
		btn1.setFont(new Font("Serif", Font.PLAIN, 40));
		btn2.setFont(new Font("Serif", Font.PLAIN, 40));
		
		container.add(btn1);
		container.add(btn2);
	} 
	
	public static void showList() {
		JFrame frame  = new JFrame("List");
        
		frame.setBounds(0, 0, 5000, 5000);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JList jlist = new JList(WordSeparator.makeReadable()); 
		
		JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        jlist.setFont(new Font("Serif", Font.PLAIN, 35));
        
        JScrollPane scroll = new JScrollPane(jlist);
        
        mainPanel.add(scroll);
        
        frame.getContentPane().add(mainPanel);
        
      //  frame.setPreferredSize(new Dimension(330, 450));
        //frame.pack();
        //frame.setLocationRelativeTo(null);
        frame.setVisible(true);
	}
	
	 
	   
}
