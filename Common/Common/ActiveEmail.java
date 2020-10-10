package Common;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;

import com.sun.mail.imap.protocol.FLAGS;

import Constant.Constant;

public class ActiveEmail {

	public static void clickLinkInEmail(String mailSubject, String keyword) {
		String resetLink = "";
		try {
			// create properties field
			Properties properties = new Properties();
			properties.put("mail.store.protocol", "pop3");
			properties.put("mail.pop3.host", "pop.gmail.com");
			properties.put("mail.pop3.port", "995");
			properties.put("mail.pop3.starttls.enable", "true");
			Session emailSession = Session.getDefaultInstance(properties);
			// emailSession.setDebug(true);

			// create the POP3 store object and connect with the pop server
			Store store = emailSession.getStore("imaps");

			store.connect("pop.gmail.com", Constant.EMAIL_USERNAME, Constant.EMAIL_PASSWORD);

			// create the folder object and open it
			Folder emailFolder = store.getFolder("Inbox");
			emailFolder.open(Folder.READ_WRITE);
			int time = 0;
			while (time != Constant.MEDIUM_TIME) {
				// retrieve the messages from the folder in an array and print it
				Message[] messages = emailFolder.getMessages();

				for (int i = messages.length - 1; i >= messages.length - 10; i--) {
					Message message = messages[i];
					System.out.println(message.getSubject());
					if (message.getSubject().equals(mailSubject + " " + keyword)) {
						String msgContent = message.getContent().toString();
						message.setFlag(FLAGS.Flag.DELETED, true);
						Pattern linkPattern = Pattern.compile("href=\"([^\"]*)",
								Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
						Matcher pageMatcher = linkPattern.matcher(msgContent);
						while (pageMatcher.find()) {
							resetLink = pageMatcher.group(1);
						}
						break;
					}
				}
				if (resetLink != "") {
					break;
				} else {
					Thread.sleep(Constant.TIME_SLEEP);
					time++;
				}
			}
			// close the store and folder objects
			emailFolder.close(false);
			store.close();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Click link in email
		Constant.WEBDRIVER.navigate().to(resetLink);
	}
}
