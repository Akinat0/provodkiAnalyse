package refactored;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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
	private JButton btn4 = new JButton("Generate progarmmed file");
	protected JTextField programmFilePath;
	
	private Controller ctrl;
	
	public GUI() {
		super("GUI");
		this.setBounds(250, 250, 1000, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		Container container = this.getContentPane();
		container.setLayout(new GridLayout(3, 2, 2, 2));
		
		class AnalyzeButtonEvent implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				prep = ctrl.analyse();
				showList();
			}
		}
	
		//EDITED
		class GenerateButtonEvent implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
		
		//		ctrl.parse();
			}
			
		}
		class PreparationButtonEvent implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				showPreparingForGeneration();
				Debug.log("Preparation Button event happened");
			}
		}
		class ProgrammingButtonEvent implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				showProgrammingActions();
				Debug.log("Programming Button event happened");
			}
			
		}

		btn1.addActionListener(new AnalyzeButtonEvent());
		btn2.addActionListener(new GenerateButtonEvent());
		btn3.addActionListener(new ProgrammingButtonEvent());
		btn4.addActionListener(new PreparationButtonEvent());
		
		btn1.setFont(new Font("Serif", Font.PLAIN, 40));
		btn2.setFont(new Font("Serif", Font.PLAIN, 40));
		btn3.setFont(new Font("Serif", Font.PLAIN, 40));
		btn4.setFont(new Font("Serif", Font.PLAIN, 40));
		
		container.add(btn1);
		container.add(btn2);
		container.add(btn3);
		container.add(btn4);
		
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
	    class ApplyPathButtonEvent implements ActionListener{

			 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileManager fmanager = new FileManager(programmFilePath.getText());
				boolean isOpened = fmanager.edit();
				if(!isOpened) {
					Debug.log("There is a problem with file on path " + fmanager.file.getPath());
				}
			}
			
			
			
		}
	    applyBtn.addActionListener(new ApplyPathButtonEvent());
	    
	    programmFilePath = new JTextField("Path to file");
	    programmFilePath.setMaximumSize(new Dimension(2000, 100));
	    applyBtn.setFont(new Font("Serif", Font.PLAIN, 35));
	    programmFilePath.setFont(new Font("Serif", Font.PLAIN, 35));
	    
	    panel.add(programmFilePath);
	    panel.add(applyBtn);
	    
	    frame.setVisible(true);
	}
	
	public void showPreparingForGeneration() {
		JFrame frame  = new JFrame("Preparing");
        
		frame.setBounds(0, 0, 1000, 1000);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();

		panel.setBounds(61, 0, 81, 140);
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    frame.add(panel);

	    
	    
	    //programmFilePath = new JTextField("Path to file with programm");
	    programmFilePath = new JTextField("C:\\Users\\User\\Desktop\\Banking\\behaviour.txt");
	    programmFilePath.setMaximumSize(new Dimension(2000, 100));

	    JTextField originFilePath;
	    //originFilePath = new JTextField("Path to file with origin");
	    originFilePath = new JTextField("C:\\Users\\User\\Desktop\\Banking\\Проводки.xlsx");
	    originFilePath.setMaximumSize(new Dimension(2000, 100));

	    JTextField generatedFilePath;
	    //generatedFilePath = new JTextField("Path to generated file");
	    generatedFilePath = new JTextField("C:\\Users\\User\\Desktop\\Banking\\Output.xlsx");
	    generatedFilePath.setMaximumSize(new Dimension(2000, 100));
	    
	    JButton applyBtn = new JButton("Apply");
	    class ApplyAllPathsButtonEvent implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					Debug.log("We are going to Controller");
					ctrl.Generate(programmFilePath.getText(), originFilePath.getText(), generatedFilePath.getText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	    
	    applyBtn.addActionListener(new ApplyAllPathsButtonEvent());
	    
	    applyBtn.setFont(new Font("Serif", Font.PLAIN, 35));
	    programmFilePath.setFont(new Font("Serif", Font.PLAIN, 35));
	    originFilePath.setFont(new Font("Serif", Font.PLAIN, 35));
	    generatedFilePath.setFont(new Font("Serif", Font.PLAIN, 35));
	    
	    
	    
	    panel.add(programmFilePath);
	    panel.add(originFilePath);
	    panel.add(generatedFilePath);
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
	
	

	
	
	
	

}
