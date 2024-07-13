package godproject;
import godproject.CricketJavaClass;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Color;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Result;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class CricketSwingClass extends CricketJavaClass {

	private JFrame frame;
	private JTextField inputDateField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		 
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CricketSwingClass window = new CricketSwingClass();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CricketSwingClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 946, 722);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Automated Match Data Scraper and Presentation");
		lblNewLabel.setBackground(new Color(128, 128, 192));
		lblNewLabel.setBounds(24, 23, 888, 82);
		lblNewLabel.setForeground(new Color(128, 0, 64));
		lblNewLabel.setFont(new Font("Lucida Calligraphy", Font.BOLD, 31));
		frame.getContentPane().add(lblNewLabel);
		
		inputDateField = new JTextField("26 june 2024");
		inputDateField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		inputDateField.setBounds(443, 204, 209, 33);
		frame.getContentPane().add(inputDateField);
		inputDateField.setColumns(10);
		
		JTextArea result = new JTextArea("Your results will appear here...");
		result.setFont(new Font("Cambria Math", Font.PLAIN, 19));
		result.setBounds(10, 11, 888, 164);
		frame.getContentPane().add(result);
		
		JScrollPane js=new JScrollPane(result,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		js.setBounds(22, 373, 890, 230);
		frame.getContentPane().add(js);
		
		String tutorial="Enter the date(eg.24 july 2024) you wants to search for matches and click on run button. ";
		
		JButton btnNewButton = new JButton("Know how it works!");
		btnNewButton.setBounds(175, 299, 231, 44);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,tutorial);
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Run Application");
		btnNewButton_1.setBounds(443, 300, 253, 44);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				instanceDate=inputDateField.getText();
				try {
					godprojectFunction();
				} catch (ClassNotFoundException | InterruptedException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				result.setText("");
				for(int i=0;i<instanceNoOfLinks;i++)
				{
//					String combined= "Match NO: "+(i+1)+"|| DATE: "+instanceDate+" || ABOUT: "+instanceDescription[i]+" || TEAMS: "+instanceTeams[i]+" || SCORES: "+instanceScorecardSummery[i]+" || RESULT: "+instanceResult[i]; 
					result.append("Match NO: "+(i+1)+"\n");
					result.append("DATE : "+instanceDate+"\n");
					result.append("ABOUT : "+instanceDescription[i]+"\n");
					result.append("TEAMS : "+instanceTeams[i]+"\n");
					result.append("SCORES : "+instanceScorecardSummery[i]+"\n");
					result.append("RESULT : "+instanceResult[i]+"\n");
					result.append("\n");
					
				}
//				textField.setText(instanceTeams[0]);
			}
		});
//		
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel inputDate = new JLabel("Enter Date:");
		inputDate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		inputDate.setBounds(278, 200, 155, 37);
		frame.getContentPane().add(inputDate);
		
		
		
		
	}
}
