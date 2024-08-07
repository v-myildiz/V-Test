package utilities.TestData;

import javax.mail.*;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MailReader {
    private final String host = "sandbox.smtp.mailtrap.io";
    private final String username = "1bd1a05ac0eda2";
    private final String password = "851c623a9351dd";

    public String getOtpCode() throws MessagingException, IOException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Store store = session.getStore("imaps");
        store.connect(host, username, password);

        Folder folder = store.getFolder("inbox");
        folder.open(Folder.READ_ONLY);

        Message[] messages = folder.getMessages();
        for (Message message : messages) {
            String content = message.getContent().toString();
            if (content.contains("verification")) {
                String otpCode = extractOtpCode(content);
                folder.close(false);
                store.close();
                return otpCode;
            }
        }
        folder.close(false);
        store.close();
        return null;
    }

    private String extractOtpCode(String content) {
        String[] lines = content.split("\n");
        for (String line : lines) {
            line = line.trim();
            if (line.length() == 6 && line.matches("[A-Z0-9]+")) {
                return line;
            }
        }
        return null;
    }
}
