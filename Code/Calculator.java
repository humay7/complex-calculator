import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;

public class Calculator implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JButton bclear, bimag, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
	private JButton bmult, badd, bneg, bdiff, bdiv, bpoint, bC, bequal, bracket1, bracket2;
	String equation = "";
	
	public static void main(String[] args) {
		Calculator window = new Calculator();
		window.frame.setVisible(true);
}

	public Calculator() {
		initialize();
		
	}

	private void initialize() {
		//frame parameters
		frame = new JFrame();
		frame.setTitle("Calculator");
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 308, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		//display panel 
		JPanel displayPanel = new JPanel();
		displayPanel.setBounds(6, 6, 296, 62);
		frame.getContentPane().add(displayPanel);
		displayPanel.setLayout(null);
		
		//text field 
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		textField.setBounds(0, 0, 296, 62);
		displayPanel.add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		
		//keyboard panel with all buttons
		JPanel keyboardPanel = new JPanel();
		keyboardPanel.setForeground(Color.DARK_GRAY);
		keyboardPanel.setBackground(Color.LIGHT_GRAY);
		keyboardPanel.setBounds(6, 72, 296, 278);
		frame.getContentPane().add(keyboardPanel);
		keyboardPanel.setLayout(null);
		
		
		bclear = new JButton("CE");
		bclear.setBounds(148, 1, 148, 46);
		bclear.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		bclear.setForeground(Color.BLACK);
		keyboardPanel.add(bclear);
		bclear.addActionListener(this);
		
		bimag = new JButton("Im");
		bimag.setBackground(Color.DARK_GRAY);
		bimag.setBounds(0, 1, 148, 46);
		bimag.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		bimag.setForeground(Color.PINK);
		keyboardPanel.add(bimag);
		bimag.addActionListener(this);
		
		bracket1 = new JButton("(");
		bracket1.setBounds(0, 47, 74, 46);
		keyboardPanel.add(bracket1);
		bracket1.addActionListener(this);
		
		bracket2 = new JButton(")");
		bracket2.setBounds(74, 47, 74, 46);
		keyboardPanel.add(bracket2);
		bracket2.addActionListener(this);
		
		bC = new JButton("AC");
		bC.setBounds(148, 47, 74, 46);
		keyboardPanel.add(bC);
		bC.addActionListener(this);
		
		bdiv = new JButton("/");
		bdiv.setBounds(222, 47, 74, 46);
		keyboardPanel.add(bdiv);
		bdiv.addActionListener(this);
		
		b7 = new JButton("7");
		b7.setBounds(0, 93, 74, 46);
		keyboardPanel.add(b7);
		b7.addActionListener(this);
		
		b8 = new JButton("8");
		b8.setBounds(74, 93, 74, 46);
		keyboardPanel.add(b8);
		b8.addActionListener(this);
		
		b9 = new JButton("9");
		b9.setBounds(148, 93, 74, 46);
		keyboardPanel.add(b9);
		b9.addActionListener(this);
		
		bmult = new JButton("*");
		bmult.setBounds(222, 93, 74, 46);
		keyboardPanel.add(bmult);
		bmult.addActionListener(this);
		
		b4 = new JButton("4");
		b4.setBounds(0, 139, 74, 46);
		keyboardPanel.add(b4);
		b4.addActionListener(this);
		
		b5 = new JButton("5");
		b5.setBounds(74, 139, 74, 46);
		keyboardPanel.add(b5);
		b5.addActionListener(this);
		
		b6 = new JButton("6");
		b6.setBounds(148, 139, 74, 46);
		keyboardPanel.add(b6);
		b6.addActionListener(this);
		
		bdiff = new JButton("-");
		bdiff.setBounds(222, 139, 74, 46);
		keyboardPanel.add(bdiff);
		bdiff.addActionListener(this);
		
		b1 = new JButton("1");
		b1.setBounds(0, 185, 74, 46);
		keyboardPanel.add(b1);
		b1.addActionListener(this);
		
		b2 = new JButton("2");
		b2.setBounds(74, 185, 74, 46);
		keyboardPanel.add(b2);
		b2.addActionListener(this);
		
		b3 = new JButton("3");
		b3.setBounds(148, 185, 74, 46);
		keyboardPanel.add(b3);
		b3.addActionListener(this);
		
		badd = new JButton("+");
		badd.setBounds(222, 185, 74, 46);
		keyboardPanel.add(badd);
		badd.addActionListener(this);
		
		b0 = new JButton("0");
		b0.setBounds(0, 231, 74, 46);
		b0.addActionListener(this);
		keyboardPanel.add(b0);
		
		bpoint = new JButton(".");
		bpoint.setBounds(74, 231, 74, 46);
		keyboardPanel.add(bpoint);
		bpoint.addActionListener(this);
		
		bneg = new JButton("(-)");
		bneg.setBounds(148, 231, 74, 46);
		keyboardPanel.add(bneg);
		bneg.addActionListener(this);
		
		bequal = new JButton("=");
		bequal.setBounds(222, 231, 74, 46);
		bequal.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		bequal.setForeground(new Color(0, 128, 0));
		keyboardPanel.add(bequal);
		bequal.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		JButton actionSource = (JButton) e.getSource();
		  if(actionSource.equals(bracket1)) {
				String text = textField.getText()+bracket1.getText();
				textField.setText(text);
			}
			if(actionSource.equals(bracket2)) {
				String text = textField.getText()+bracket2.getText();
				textField.setText(text);
			}
			if(actionSource.equals(bclear)) {
				String text = textField.getText().substring(0, textField.getText().length()-1);
				textField.setText(text);
			}
			if(actionSource.equals(bimag)) {
				String text = textField.getText()+"i";
				textField.setText(text);
			}
			if(actionSource.equals(b1)) {
				String number = textField.getText()+b1.getText();
				textField.setText(number);
			}
			if(actionSource.equals(b2)) {
				String number = textField.getText()+b2.getText();
				textField.setText(number);
			}
			if(actionSource.equals(b3)) {
				String number = textField.getText()+b3.getText();
				textField.setText(number);
			}
			if(actionSource.equals(b4)) {
				String number = textField.getText()+b4.getText();
				textField.setText(number);
			}
			if(actionSource.equals(b5)) {
				String number = textField.getText()+b5.getText();
				textField.setText(number);
			}
			if(actionSource.equals(b6)) {
				String number = textField.getText()+b6.getText();
				textField.setText(number);
			}
			if(actionSource.equals(b7)) {
				String number = textField.getText()+b7.getText();
				textField.setText(number);
			}
			if(actionSource.equals(b8)) {
				String number = textField.getText()+b8.getText();
				textField.setText(number);
			}
			if(actionSource.equals(b9)) {
				String number = textField.getText()+b9.getText();
				textField.setText(number);
			}
			if(actionSource.equals(b0)) {
				String number = textField.getText()+b0.getText();
				textField.setText(number);
			}
			if(actionSource.equals(badd)) {
				textField.setText(textField.getText()+" "+badd.getText()+" ");
			}
			if(actionSource.equals(bdiff)) {
				textField.setText(textField.getText()+" "+bdiff.getText()+" ");
			}
			if(actionSource.equals(bmult)) {
				textField.setText(textField.getText()+" "+bmult.getText()+" ");
			}
			if(actionSource.equals(bdiv)) {
				textField.setText(textField.getText()+" "+bdiv.getText()+" ");
			}
			if(actionSource.equals(bC)) {
				textField.setText("");
			}
			if(actionSource.equals(bpoint)) {
				textField.setText(textField.getText()+bpoint.getText());
			}
			if(actionSource.equals(bneg)) {
				textField.setText(textField.getText()+"-");
			}
			if(actionSource.equals(bequal)) {
				String text = textField.getText()+" "+bequal.getText()+ " ";
				textField.setText(text);
				String equation = text;
				Socket socket2;
			    BufferedReader in;
			    PrintWriter out;
				try {
			        socket2 = new Socket(InetAddress.getLocalHost(),2007); 
			        out = new PrintWriter(socket2.getOutputStream());
			        out.println(equation);
			        out.flush();
			        in = new BufferedReader (new InputStreamReader (socket2.getInputStream()));
			        String result = in.readLine();
			        textField.setText(textField.getText() + result);
			        socket2.close();    
			    }catch (UnknownHostException ex) {         	
			        ex.printStackTrace();         
			    }catch (IOException ex) {
			    	ex.printStackTrace();
			    }
				}
	}
	
}





