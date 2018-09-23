
import java.awt.*;
import java.awt.event.*;
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
		
		btn1.addActionListener(new AnalyzeButtonEvent());
		btn2.addActionListener(new GenerateButtonEvent());
		
		container.add(btn1);
		container.add(btn2);
	}
	
	class AnalyzeButtonEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//Analyze method
		}
	}
	
	class GenerateButtonEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			MainClass.parse(MainClass.file);
			
		}
		
	}
}
