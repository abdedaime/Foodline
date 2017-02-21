package net.te6.foodline.mailing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.mail.internet.MimeMessage;

import net.te6.foodline.models.Snack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service("mailService")
public class ApplicationMailer  implements
		IapplicationMailer {

	private static final String linkActivate = "http://www.mydomain.com:8081/FoodLineBackEnd/activate-account/";

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendMailNewAccount(Snack snack) throws Exception {
		MimeMessage mime = this.mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mime, true);
		helper.setTo(snack.getLogin());
		helper.setSubject("Nouveau compte Sur Foodline");
		String token = clairToMd5(snack.getLogin()+snack.getId());
		System.out.println("-----"+token);
    	String name=snack.getName();
		token = linkActivate.concat(token);
		String text = "<table class='body-wrap' style='background-color: #f6f6f6;width: 100%;'>"
				+ "<tr><td></td><td class='container' width='600' style='display: block;max-width: 600px;margin: 0 auto;clear: both;'>"
				+ "<div class='content' style='max-width: 600px;margin: 0 auto;display: block;padding: 20px;'>"
				+ "<table class='main' style='background: #fff;border: 1px solid #e9e9e9;border-radius: 3px;' width='100%' cellpadding='0' cellspacing='0'>"
				+ "<tr><td class='alert alert-good' style='font-size: 16px;color: #fff;font-weight: 500;padding: 20px;text-align: center;border-radius: 3px 3px 0 0;background: #1ab394;'>"
				+ "Nouveau compte Sur Foodline.</td></tr><tr><td class='content-wrap' style='padding: 20px;'><table width='100%' cellpadding='0' cellspacing='0'>"
				+ "<tr><td class='content-block' style='padding: 0 0 20px;'>Bonjour, <strong>"
				+ name
				+ "</strong></td></tr><tr>"
				+ "<td class='content-block' style='padding: 0 0 20px;'>Vous avez un nouveau compte sur Foodline,<br>"
				+ "pour ativer votre compte , vous devez renseigner un mot de passe, qui doit être composé par des caractères AlphaNumériques et des caractères spéciaux."
				+ "<br> le boutton suivant vous permettera de saisir votre mot de passe."
				+ "</td></tr><tr><td class='content-block' style='padding: 0 0 20px;text-align: center;'>"
				+ "<a href='"
				+ token
				+ "' class='btn-primary' style='text-decoration: none;color: #FFF;background-color: #1ab394;border: solid #1ab394;border-width: 5px 10px;line-height: 2;font-weight: bold;text-align: center;cursor: pointer;display: inline-block;border-radius: 5px;text-transform: capitalize;'>Activer votre compte  </a>"
				+ "</td></tr><tr><td class='content-block' style='padding: 0 0 20px;'>&copy  Youssef Najeh Hicham Abdedaime</td></tr></table></td></tr></table>"
				+ "<div class='footer' style='width: 100%;clear: both;color: #999;padding: 20px;'></div></div></td><td></td></tr></table>";
		helper.setText(text, true);
		this.mailSender.send(mime);
	}
	
	
	public String clairToMd5(String txt) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(txt.getBytes());

		byte byteData[] = md.digest();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < byteData.length; i++) {
			sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return sb.toString();

	}

}
