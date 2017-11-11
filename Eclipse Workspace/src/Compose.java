import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.MatteBorder;


public class Compose extends JFrame implements ActionListener {
	private static JTextField tto;
	private static JTextField tsub;
	private static JTextArea ttext;
	private static String user,pass;
	JScrollPane span;
	JPanel pan2,pan;
	JButton bup,bsend,bx,bclr;
	int buttons;
	String arr[];
	public Compose() {
		
		arr=new String[100];
		buttons=0;
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTo.setForeground(new Color(102, 102, 102));
		lblTo.setFont(new Font("Cambria", Font.BOLD, 20));
		lblTo.setBounds(20, 40, 100, 40);
		getContentPane().add(lblTo);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubject.setForeground(new Color(102, 102, 102));
		lblSubject.setFont(new Font("Cambria", Font.BOLD, 20));
		lblSubject.setBounds(20, 100, 100, 40);
		getContentPane().add(lblSubject);
		
		tto = new JTextField();
		tto.setBorder(null);
		tto.setFont(new Font("Cambria", Font.PLAIN, 18));
		tto.setBounds(130, 45, 250, 30);
		getContentPane().add(tto);
		tto.setColumns(10);
		
		tsub = new JTextField();
		tsub.setBorder(null);
		tsub.setFont(new Font("Cambria", Font.PLAIN, 18));
		tsub.setColumns(10);
		tsub.setBounds(130, 105, 450, 30);
		getContentPane().add(tsub);
		
		ttext = new JTextArea();
		ttext.setWrapStyleWord(true);
		ttext.setLineWrap(true);
		ttext.setFont(new Font("Cambria", Font.PLAIN, 18));
		ttext.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
	
		
		JScrollPane scroll = new JScrollPane(ttext);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    	scroll.setBounds(130, 160, 450, 300);
		getContentPane().add(scroll);
        
		JLabel lblBody = new JLabel("Body");
		lblBody.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBody.setForeground(new Color(102, 102, 102));
		lblBody.setFont(new Font("Cambria", Font.BOLD, 20));
		lblBody.setBounds(20, 160, 100, 40);
		getContentPane().add(lblBody);
		
		bup = new JButton("Upload");
		bup.addActionListener(this);
		bup.setFont(new Font("Cambria", Font.BOLD, 16));
		bup.setForeground(new Color(255, 255, 255));
		bup.setBackground(new Color(102, 102, 102));
		bup.setBounds(20, 473, 100, 30);
		getContentPane().add(bup);
		
		bsend = new JButton("Send");
		bsend.addActionListener(this);
		bsend.setForeground(new Color(255, 255, 255));
		bsend.setBackground(new Color(102, 102, 102));
		bsend.setFont(new Font("Cambria", Font.BOLD, 20));
		bsend.setBounds(275, 640, 100, 35);
		getContentPane().add(bsend);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(130, 75, 250, 5);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(130, 135, 450, 5);
		getContentPane().add(separator_1);
		
	//	pan = new JPanel();
	//	pan.setLayout(null);
	//	pan.setBounds(130, 475, 450, 150);
	//	getContentPane().add(pan);

		bx = new JButton("X");
		bx.addActionListener(this);
		bx.setHorizontalAlignment(SwingConstants.LEFT);
		bx.setForeground(new Color(255, 255, 255));
		bx.setFont(new Font("Cambria", Font.BOLD, 22));
		bx.setBackground(new Color(153, 0, 0));
		bx.setBounds(600, 0, 50, 50);
		getContentPane().add(bx);

		pan2 = new JPanel();
		
		pan2.setLayout(null);
		pan2.setBackground(new Color(255, 255, 255));
		pan2.setBorder(null);
		span=new JScrollPane(pan2);
		span.setBorder(null);
		span.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        span.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		span.setBounds(130, 475, 450, 150);
		getContentPane().add(span);
		
		bclr = new JButton("Clear");
		bclr.addActionListener(this);
		bclr.setForeground(Color.WHITE);
		bclr.setFont(new Font("Cambria", Font.BOLD, 16));
		bclr.setBackground(new Color(102, 102, 102));
		bclr.setBounds(20, 595, 100, 30);
		getContentPane().add(bclr);
		//	pan.add(span);
	
		
		this.getRootPane().setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		setUndecorated(true);
		setVisible(false);	
		setSize(650,700);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		JButton btn=(JButton)e.getSource();
		if(btn==bsend)
		{	
			Mailer obj2=new Mailer(user,pass,tto.getText(),tsub.getText(),ttext.getText(),arr,buttons);
   	 		obj2.send();
   	 		tto.setText("");
   	 		tsub.setText("");
   	 		ttext.setText("");
   	 		clearAttachments();
		}
		if(btn==bup)
		{
			LookAndFeel previousLF = UIManager.getLookAndFeel();
			try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } catch (Exception e1) {}
			JFileChooser fileDialog=new JFileChooser();
			try {
		        UIManager.setLookAndFeel(previousLF);
		    } catch (Exception e1) {}
			
			
			String path="";
			int returnVal = fileDialog.showOpenDialog(this);
            
            if (returnVal == JFileChooser.APPROVE_OPTION) {
               
              arr[buttons]=fileDialog.getSelectedFile().getPath();
              path=fileDialog.getSelectedFile().getName();
            } 
            else
            	return;
			buttons+=1;
			JTextField b=new JTextField(path);
			b.setBounds(5,(buttons-1)*30,300,25);
			b.setForeground(new Color(255, 255, 255));
			b.setBackground(new Color(102, 102, 102));
			b.setEditable(false);
			b.setFont(new Font("Cambria", Font.BOLD, 16));
			pan2.add(b);
			pan2.setPreferredSize(new Dimension(440,(buttons)*30+40));
			pan2.revalidate();
			span.revalidate();
			
		}
		if(btn==bx)
		{
			System.exit(0);
		}
		if(btn==bclr)
		{	
			clearAttachments();
		}
			
	}
	
	public void clearAttachments()
	{
		this.getContentPane().remove(span);
	 	buttons=0;
	  	pan2 = new JPanel();
	  	pan2.setLayout(null);
		pan2.setBackground(new Color(255, 255, 255));
		pan2.setBorder(null);
		span=new JScrollPane(pan2);
		span.setBorder(null);
		span.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	span.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		span.setBounds(130, 475, 450, 150);
		getContentPane().add(span);
	 	this.getContentPane().invalidate();
	 	this.getContentPane().validate();	
	}
	
	public static void main(String []args)
	{		
		Compose obj=new Compose();
		Login obj1 =new Login(obj,true);
		user=obj1.user;
		pass=obj1.pass;
		
	}
	
	
}
