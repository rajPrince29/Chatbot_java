import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;
public class GUI extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 209, 321, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setBounds(341, 209, 83, 44);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String s=null;
				try {
					s=textField.getText();
					System.out.println(s);
					if(s.startsWith("OPEN")
							||s.startsWith("CLOSE")
							||s.startsWith("START")
							||s.startsWith("STOP")
							||s.startsWith("SITE"))
					{
						System.out.println("reched handle");
					Command.handle(s);
					}
					else if (s.startsWith("#")) 
					{
						System.out.println("Crawler");
					}
					else {
						s=Bot.fromBot(s);
					}
					textField_1.setText(s);
					textField.setText(null);
				} catch (Exception e1) {
					System.out.println(e1);
				}
				Bot.textToSpeech(s, "kevin16");
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Command");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnNewButton_1.setBounds(341, 156, 83, 42);
		contentPane.add(btnNewButton_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(137, 156, -67, 31);
		contentPane.add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 156, 321, 42);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
