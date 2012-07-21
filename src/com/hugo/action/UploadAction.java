package com.hugo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hugo.dao.HibernateConfiguration;
import com.hugo.form.UploadForm;
import com.hugo.pojo.RegisterPojo;
import com.hugo.pojo.UploadPojo;

public class UploadAction extends Action {

	String loginId;
	String path;
	Session session = null;
	private int id;
	Transaction transaction = null;

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession httpSession = request.getSession();
		loginId = httpSession.getAttribute("loginId").toString();
		UploadForm uploadform = (UploadForm) form;
		FileOutputStream outputStream = null;
		FormFile formFile = null;
		try {
			formFile = uploadform.getFilelocation();
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
		if (path != null) {
			ReadCSV1(path);
		}

		return mapping.findForward("success");
	}

	private void ReadCSV1(String fileName) {
		// TODO Auto-generated method stub
		/*
		 * SessionFactory sessionFactory = new Configuration().configure()
		 * .buildSessionFactory();
		 */
		Session session = HibernateConfiguration.getsession();
		transaction = session.beginTransaction();
		String cquery = "FROM RegisterPojo as r where r.emailId=:mailId";
		@SuppressWarnings("rawtypes")
		List getId = session.createQuery(cquery).setString("mailId", loginId)
				.list();
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = getId.iterator(); iterator.hasNext();) {
			RegisterPojo registerPojo = (RegisterPojo) iterator.next();
			id = registerPojo.getLoginId();
			transaction.commit();
			session.close();
		}

		// System.out.println("List contains.."+users);

		UploadPojo pojo = new UploadPojo();

		try {
			FileInputStream myInput = new FileInputStream(fileName);

			POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

			HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

			HSSFSheet mySheet = myWorkBook.getSheetAt(0);
			System.out.println("No.of records are.."
					+ mySheet.getPhysicalNumberOfRows());
			System.out.println("---------------------------------");
			System.out.println("Through War");
			System.out.println("-------------------------------------");
			// session = HibernateConfiguration.getsession();

			for (int i = 0; i < mySheet.getPhysicalNumberOfRows(); i++) {
				session = HibernateConfiguration.getsession();
				transaction = session.beginTransaction();

				HSSFRow row = mySheet.getRow(i);
				HSSFCell name = row.getCell(0);
				HSSFCell email = row.getCell(1);
				row.getCell(2).setCellType(1);
				HSSFCell phone = row.getCell(2);
				HSSFCell notes = row.getCell(3, Row.CREATE_NULL_AS_BLANK);
				// pojo.setContactId(1);
				pojo.setLoginId(id);
				pojo.setRecipientname(name.toString().trim());
				pojo.setRecipientemail(email.toString().trim());
				pojo.setRecipientphone(phone.toString().trim());
				pojo.setNotes(notes.toString().trim());
				System.out.println("------------------");
				System.out.println(session.save(pojo));
				System.out.println("------------------");
				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
		} finally {
			// Actual contact insertion will happen at this step
			if (session != null) {

				session.flush();
				session.close();
			}
		}

	}
}