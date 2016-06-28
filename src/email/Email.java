package email;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Email {
	private static final String FROM = "cinemabuddyvdi@gmail.com";
	private static final String USER_NAME = "cinemabuddyvdi";
	private static final String PASSWORD = "cinema$123";
	private static final String HOST = "smtp.gmail.com";
	private String receiver, subject, content;

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	Email() {
	};

	Email(String receiver, String subject, String content) {

		this.receiver = receiver;
		this.subject = subject;
		this.content = content;

	};

	public void sendMessage() {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", HOST);
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USER_NAME, PASSWORD);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(FROM));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver));
			message.setSubject(subject);
			message.setText(content);
			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
