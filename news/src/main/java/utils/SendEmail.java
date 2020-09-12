package utils;

import org.apache.commons.mail.*;

public class SendEmail {
	
	  public void send_email()
	  
	  {
	// Create the attachment
		  EmailAttachment attachment = new EmailAttachment();
		  attachment.setPath("mypictures/john.jpg");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Picture of John");
		  attachment.setName("John");
	
		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("mail.myserver.com");
		  email.addTo("jdoe@somewhere.org", "John Doe");
		  email.setFrom("me@apache.org", "Me");
		  email.setSubject("The picture");
		  email.setMsg("Here is the picture you wanted");
	
		  // add the attachment
		  email.attach(attachment);
	
		  // send the email
		  email.send();
		 
	  }

}
