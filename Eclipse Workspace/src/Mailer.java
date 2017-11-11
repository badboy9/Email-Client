    import java.io.File;
import java.util.Properties;    

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;    
import javax.mail.internet.*; 
    class Mailer{  
    	String from,password,to,sub,msg;
    	String array[];
    	int n;
    	Mailer(String frm,String pass,String s1,String s2,String s3, String []arr, int attach)
    	{
    		n=attach;
    		array=arr;
    		from=frm;
    		password=pass;
    		to=s1;
    		sub=s2;
    		msg=s3;
    	}
        public void send(){  
              //Get properties object    
        	  
        	try{
        		
        	
              Properties props = new Properties();    
              props.put("mail.smtp.host", "smtp.gmail.com");    
              props.put("mail.smtp.socketFactory.port", "465");    
              props.put("mail.smtp.socketFactory.class",    
                        "javax.net.ssl.SSLSocketFactory");    
              props.put("mail.smtp.auth", "true");    
              props.put("mail.smtp.port", "465");    
              //get Session   
              Session session = Session.getDefaultInstance(props,    
               new javax.mail.Authenticator() {    
               protected PasswordAuthentication getPasswordAuthentication() {    
               return new PasswordAuthentication(from,password);  
               }    
              });    
              //compose message    
                 
               MimeMessage message = new MimeMessage(session);
               message.addRecipients(Message.RecipientType.BCC,setRecipients());    
               message.setSubject(sub);  
               Multipart multipart =createBody(array); 
               message.setContent(multipart);  
              
               //send message  
               
               Transport.send(message);    
               
               System.out.println("message sent successfully");    
              } catch (Exception e) 
              {
            	  //e.printStackTrace();
            	  Error obj=new Error("Error");
            	
              }    
                 
        }  
        
        public InternetAddress[] setRecipients()
        {
        	to.trim();
        	to=to.replaceAll(";", ",");
            System.out.println(to);
            InternetAddress []bcc= new InternetAddress[1];
            try{
            	bcc=InternetAddress.parse(to);
            }
            catch(Exception e){e.printStackTrace();}
        	return bcc;
        }
        public Multipart createBody(String []arr) throws MessagingException
        {
        	Multipart multipart = new MimeMultipart(); 
        	BodyPart textpart=new MimeBodyPart();
        
        	textpart.setText(msg);
        	multipart.addBodyPart(textpart);
        	for(int i=0;i<n;i++)
        	{
        		MimeBodyPart attachment = new MimeBodyPart();  
                String filename = arr[i]; 
                DataSource source = new FileDataSource(filename);  
                attachment.setDataHandler(new DataHandler(source));  
                attachment.setFileName(new File(filename).getName());
                multipart.addBodyPart(attachment); 
        	}
        	return multipart;

        }
        
        
    }
    
    
    
