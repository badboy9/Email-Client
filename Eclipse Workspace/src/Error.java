
import javax.swing.*;
import javax.swing.border.MatteBorder;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Error extends JFrame implements ActionListener
{
	private JFrame parent;
	public Error(String code) {
		
		setLayout(null);
		String s=code;
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel.setBounds(0, 0, 350, 196);
		add(panel);
		panel.setLayout(null);
		
		JButton button = new JButton("Continue");
		button.addActionListener(this);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		button.setBorder(null);
		button.setBackground(new Color(0, 51, 102));
		button.setBounds(125, 120, 100, 40);
		panel.add(button);
		
		JLabel lbl1 = new JLabel(s);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lbl1.setBounds(100, 50, 150, 30);
		panel.add(lbl1);
		
		setUndecorated(true);
		setSize(350,196);
		setResizable(false);
		this.toFront();
		setLocationRelativeTo(null);
		setVisible(true);

	}
	public void actionPerformed(ActionEvent e)
	{
		dispose();
	}
	
}
