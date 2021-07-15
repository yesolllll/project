package util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	//매개변수 : 발신자, 수신자, 제목, 내용
	public static void sendMail(String from, String to, String subject, String content) {
		try {
			//1.발신자(메일서버) 정보 설정(Property) - 네이버 외부메일 연결하기에 있는 설정
			Properties prop = System.getProperties();
			prop.put("mail.smtp.startls.enable", "true"); //ssl을 사용하겠다. ssl 사용안하면 발송 x 
			prop.put("mail.smtp.host", "smtp.naver.com"); //메일라이브러리가 저대로 읽어오기때문에 무조건 이렇게 적어야함. (실제로 보내는건 네이버메일서버임)
			prop.put("mail.smtp.port", "587");  //IMAP/SMTP설정
			prop.put("mail.smtp.auth", "true"); //메일을 발송할때 인증이 없으면 x
			prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
			
			//2. Session 객체 생성
			Session session =  Session.getDefaultInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("dign3355", "hateapple2027.."); //네이버아이디, 네이버비밀번호
			 }
			});
			session.setDebug(true);
			//3.MimeMessage 객체 생성(발신자, 수신자, 제목, 내용 설정)
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(from)); //발신자
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(to)); //수신자
			mimeMessage.setSubject(subject); //제목
			//mimeMessage.setText(content); //내용   -> html이나 이미지로 발송하고 싶다면 사용하면 안됨 무조건 text로 전송됨
			
			//html발송 : 이미지 사용하고 싶으면 전체 경로 다 작성해줘야함
			mimeMessage.setContent(content, "text/html; charset=utf-8");
			
			
			//4.메일 전송
			Transport.send(mimeMessage);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void main(String[] args) {
		sendMail("dign3355@naver.com", "dign3355@daum.net", "A", "APPLE");  /* 보내는 주소/받는주소/제목/내용 */
	}
}
