package com.hugo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hugo.dao.HibernateConfiguration;
import com.hugo.form.VoiceUploadForm;
import com.hugo.pojo.MmsTemplatePojo;
import com.hugo.pojo.RegisterPojo;

public class VoiceUploadAction extends Action {
	int loginid;
	Session session;
	byte[] buffer;
	String path;
	FormFile formFile = null;
	String loginId;
	String templatename;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// HttpSession httpSession = request.getSession();
		// loginId = httpSession.getAttribute("loginId").toString();
		HttpSession httpSession = request.getSession();
		String loginId = httpSession.getAttribute("idno").toString();
		loginid = Integer.parseInt(loginId);
		VoiceUploadForm voiceform = (VoiceUploadForm) form;
		FileOutputStream outputStream = null;
		// FormFile formFile = null;
		// FormFile formfile;
		try {
			formFile = voiceform.getFilelocation();
			templatename=voiceform.getDescription();
			path = getServlet().getServletContext().getRealPath("") + "/"
					+ formFile.getFileName();
			System.out.println("path is " + path);
			outputStream = new FileOutputStream(new File(path));
			outputStream.write(formFile.getFileData());
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
		/*
		 * formFile = voiceform.getFilelocation(); String contenttype=
		 * formFile.getContentType(); System.out.println(contenttype); String
		 * path = getServlet().getServletContext().getRealPath("") + "/" +
		 * formFile.getFileName(); System.out.println("path is " + path);
		 */
		try {
			File file = new File(path);
			buffer = new byte[(int) file.length()];
			// File file = new File("C:\\mavan-hibernate-image-mysql.gif");
			// bFile = new byte[(int) file.length()];
			FileInputStream fileInputStream = new FileInputStream(file);
			// fileInputStream.read(bFile);
			// convert file into array of bytes
			// fileInputStream.read(buffer);
			// fileInputStream.close();
			AudioInputStream inputStream = AudioSystem
					.getAudioInputStream(fileInputStream);
			int numBytes = inputStream.available();
			buffer = new byte[numBytes];
			inputStream.read(buffer, 0, numBytes);
			MmsTemplatePojo mpojo = new MmsTemplatePojo();
			session = HibernateConfiguration.getsession();
			Transaction transaction = session.beginTransaction();
			/*
			 * String cquery = "FROM RegisterPojo as r where r.emailId=:mailId";
			 * 
			 * @SuppressWarnings("rawtypes") List getId =
			 * session.createQuery(cquery).setString("mailId", loginId) .list();
			 * for (@SuppressWarnings("rawtypes") Iterator iterator =
			 * getId.iterator(); iterator.hasNext();) { RegisterPojo
			 * registerPojo = (RegisterPojo) iterator.next(); id =
			 * registerPojo.getLoginId(); }
			 */
			mpojo.setLoginid(loginid);
			mpojo.setFile(buffer);
			mpojo.setMmstype("Voice");
			mpojo.setDescription(templatename);
			session.save(mpojo);
			transaction.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * FileInputStream fileInputStream = new FileInputStream(path);
		 * AudioInputStream inputStream =
		 * AudioSystem.getAudioInputStream(fileInputStream); int numBytes =
		 * inputStream.available(); byte[] buffer = new byte[numBytes];
		 * inputStream.read(buffer, 0, numBytes); inputStream.close();
		 */

		/*
		 * //File file = new File(path); // byte[] bFile = new byte[(int)
		 * file.length()];
		 * 
		 * try { FileInputStream fileInputStream = new FileInputStream(file);
		 * //convert file into array of bytes fileInputStream.read(bFile);
		 * fileInputStream.close(); } catch (Exception e) { e.printStackTrace();
		 * }
		 */

		/*
		 * outputStream = new FileOutputStream(new File(path));
		 * outputStream.write(formFile.getFileData()); } finally { if
		 * (outputStream != null) { outputStream.close(); } }
		 */

		return mapping.findForward("success");
	}
}
