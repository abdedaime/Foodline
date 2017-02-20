package net.te6.foodline.controller;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

public abstract class AbstractController implements ServletContextAware {
	protected Logger log = Logger.getLogger(AbstractController.class);

	private ServletContext servletContext;
	protected static final String IMAGE_DIR = "images";
	protected static final String AVATAR_NAME = "avatar";
	protected static final String EXT_IMAGE = ".png";
	public static final String LOGO_NAME = "logo";

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	public void createFile(String typeFolder, MultipartFile multipartFile,
			long id) {
		String appPath = getServletContext().getRealPath("");
		StringBuilder filePath = new StringBuilder().append(appPath)
				.append(IMAGE_DIR).append(File.separator).append(typeFolder);

		File fileSaveDir = new File(filePath.toString());
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}
		filePath = filePath.append(File.separator).append(id).append(EXT_IMAGE);
		log.info(filePath);

		try {
			multipartFile.transferTo(new File(filePath.toString()));
		} catch (Exception e) {
			log.error("Error " + e.getMessage());
		}

	}
	
	protected  void deleteFile(String typeFolder,long id){
		String appPath = getServletContext().getRealPath("");
		StringBuilder filePath = new StringBuilder().append(appPath)
				.append(IMAGE_DIR).append(File.separator).append(typeFolder).append(File.separator).append(id).append(EXT_IMAGE);
		File fileSaveDir = new File(filePath.toString());
		if (fileSaveDir.exists()){
		 boolean delete=	fileSaveDir.delete();
		 log.info("delete file return  "+delete);
			
		 } 
		
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
