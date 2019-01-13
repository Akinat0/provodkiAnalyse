package refactored;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;
import javax.swing.JTextPane;
/*
import GUI.AnalyzeButtonEvent;
import GUI.GenerateButtonEvent;
*/
public class GUI extends JFrame{
	
	private JButton btn1 = new JButton("Analyze");
	private JButton btn2 = new JButton("Generate");
	private JButton btn3 = new JButton("Programming");
	protected JTextField filePath;
	
	private Controller ctrl;
	
	public GUI() {
		super("GUI");
		this.setBounds(250, 250, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3, 2, 2, 2));
		
		btn1.addActionListener(new AnalyzeButtonEvent());
		btn2.addActionListener(new GenerateButtonEvent());
		btn3.addActionListener(new ProgrammingButtonEvent());
		
		btn1.setFont(new Font("Serif", Font.PLAIN, 40));
		btn2.setFont(new Font("Serif", Font.PLAIN, 40));
		btn3.setFont(new Font("Serif", Font.PLAIN, 40));
		
		container.add(btn1);
		container.add(btn2);
		container.add(btn3);
		
		ctrl = new Controller();
	}
	
	
	private WordsPreparing prep;
	private Splitter splitter;
	
	public void showProgrammingActions() {
		JFrame frame  = new JFrame("New Action List");
        
		frame.setBounds(0, 0, 1000, 1000);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();

		panel.setBounds(61, 0, 81, 140);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    frame.add(panel);

	    JButton applyBtn = new JButton("Apply");
	    applyBtn.addActionListener(new ApplyPathButtonEvent());
	    
	    filePath = new JTextField("Path to file");
	    filePath.setMaximumSize(new Dimension(2000, 100));
	    applyBtn.setFont(new Font("Serif", Font.PLAIN, 35));
	    filePath.setFont(new Font("Serif", Font.PLAIN, 35));
	    
	    panel.add(filePath);
	    panel.add(applyBtn);
	    
	    frame.setVisible(true);
	}
	
	public void showList() {
		JFrame frame  = new JFrame("List");
        
		frame.setBounds(0, 0, 10000, 10000);
		
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
	
	class ApplyPathButtonEvent implements ActionListener{

		 
		
		@Override
		public void actionPerformed(ActionEvent e) {
			FileManager fmanager = new FileManager(filePath.getText());
			boolean isOpened = fmanager.edit();
			if(!isOpened) {
				Debug.log("There is a problem with file on path " + fmanager.file.getPath());
			}
		}
		
		
		
	}
	
	class GenerateButtonEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ctrl.parse();
		}
		
	}

	class ProgrammingButtonEvent implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			showProgrammingActions();
			Debug.log("Programming Button event happened");
		}
		
	}
}
