package refactored;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/*
import GUI.AnalyzeButtonEvent;
import GUI.GenerateButtonEvent;
*/
public class GUI extends JFrame{
	
	private JButton btn1 = new JButton("Analyze");
	private JButton btn2 = new JButton("Generate");
	
	private Controller ctrl;
	
	public GUI() {
		super("GUI");
		this.setBounds(250, 250, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3, 2, 2, 2));
		
		btn1.addActionListener(new AnalyzeButtonEvent());
		btn2.addActionListener(new GenerateButtonEvent());
		
		btn1.setFont(new Font("Serif", Font.PLAIN, 40));
		btn2.setFont(new Font("Serif", Font.PLAIN, 40));
		
		container.add(btn1);
		container.add(btn2);
		
		ctrl = new Controller();
	}
	
	
	private WordsPreparing prep;
	private Splitter splitter;
	
	public void showList() {
		JFrame frame  = new JFrame("List");
        
		frame.setBounds(0, 0, 5000, 5000);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JList jlist = new JList(prep.makeReadable()); 
		
		JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        jlist.setFont(new Font("Serif", Font.PLAIN, 35));
        
        JScrollPane scroll = new JScrollPane(jlist);
        
        mainPanel.add(scroll);
        
        frame.getContentPane().add(mainPanel);
        
        frame.setVisible(true);
	}
	
	
	class AnalyzeButtonEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println(ctrl == null);			\
			prep = ctrl.analyse();
			showList();
		}
	}
	
	class GenerateButtonEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
		//	MainClass.parse(MainClass.file);
		}
		
	}
}
