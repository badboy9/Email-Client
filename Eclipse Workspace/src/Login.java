import javax.swing.border.MatteBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JDialog implements ActionListener{
	private JTextField tmail;
	private JTextField tpass;
	String pass,user;
	JButton blogin,bx;
	JFrame parent;
	JLabel lerror;
	public Login(JFrame a,boolean bm) 
	{
		super(a,bm);
		getContentPane().setBackground(new Color(255, 255, 255));
		
		parent=a;
		setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		tmail = new JTextField();
		tmail.setBorder(null);
		tmail.setFont(new Font("Cambria", Font.PLAIN, 20));
		tmail.setBounds(230, 255, 250, 30);
		getContentPane().add(tmail);
		tmail.setColumns(10);
		
		tpass = new JPasswordField();
		tpass.setBorder(null);
		tpass.setFont(new Font("Cambria", Font.PLAIN, 20));
		tpass.setBounds(230, 325, 250, 30);
		getContentPane().add(tpass);
		
		JLabel lblNewLabel = new JLabel("Email ID");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 22));
		lblNewLabel.setBounds(120, 250, 100, 40);
		getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Cambria", Font.BOLD, 22));
		lblPassword.setBounds(120, 320, 100, 40);
		getContentPane().add(lblPassword);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(230, 285, 250, 5);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 0, 0));
		separator_1.setBounds(230, 355, 250, 5);
		getContentPane().add(separator_1);
		
		blogin = new JButton("Login");
		blogin.addActionListener(this);
		blogin.setBackground(new Color(102, 102, 102));
		blogin.setForeground(new Color(255, 255, 255));
		blogin.setFont(new Font("Cambria", Font.BOLD, 22));
		blogin.setBounds(275, 430, 100, 40);
		getContentPane().add(blogin);
		
		JLabel lblGmailClient = new JLabel("Gmail Client");
		lblGmailClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblGmailClient.setFont(new Font("Cambria", Font.BOLD, 28));
		lblGmailClient.setBounds(235, 130, 180, 50);
		getContentPane().add(lblGmailClient);
		
		JLabel lblDevelopedByBhushan = new JLabel("Developed by");
		lblDevelopedByBhushan.setFont(new Font("Cambria", Font.BOLD, 21));
		lblDevelopedByBhushan.setBounds(300, 650, 140, 30);
		getContentPane().add(lblDevelopedByBhushan);
		
		JLabel lblBhushanDeshmukh = new JLabel("Bhushan Deshmukh");
		lblBhushanDeshmukh.setFont(new Font("Cambria", Font.PLAIN, 21));
		lblBhushanDeshmukh.setBounds(440, 650, 200, 30);
		getContentPane().add(lblBhushanDeshmukh);
		
		lerror = new JLabel("Do not leave the field Empty");
		lerror.setForeground(new Color(153, 51, 51));
		lerror.setHorizontalAlignment(SwingConstants.CENTER);
		lerror.setFont(new Font("Cambria", Font.PLAIN, 18));
		lerror.setBounds(175, 380, 300, 30);
		lerror.setVisible(false);
		getContentPane().add(lerror);
		
		bx = new JButton("X");
		bx.addActionListener(this);
		bx.setHorizontalAlignment(SwingConstants.LEFT);
		bx.setForeground(Color.WHITE);
		bx.setFont(new Font("Cambria", Font.BOLD, 22));
		bx.setBackground(new Color(153, 0, 0));
		bx.setBounds(600, 0, 50, 50);
		getContentPane().add(bx);

		setUndecorated(true);
		parent.setVisible(false);
		setSize(650,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		JButton btn=(JButton)e.getSource();
		if(btn==blogin)
		{
			lerror.setVisible(false);
			if(tmail.getText().trim().isEmpty()==true&&tpass.getText().trim().isEmpty()==true)
			{
				lerror.setVisible(true);
				return;
			}
			user=tmail.getText();
			pass=tpass.getText();
			dispose();
			parent.setVisible(true);
		}
		if(btn==bx)
			System.exit(0);
	
	}
}
