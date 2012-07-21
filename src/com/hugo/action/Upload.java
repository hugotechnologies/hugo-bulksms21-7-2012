package com.hugo.action;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hugo.pojo.RegisterPojo;
import com.hugo.pojo.UploadPojo;

@SuppressWarnings("serial")
public class Upload extends HttpServlet {

	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 1500 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file;
	private String fileName;
	String loginId;
	Session session = null;
	private int id;
	Transaction transaction;

	@Override
	public void init() {
		// Get the file location where it would be stored.
		filePath = getServletContext().getInitParameter("file-upload");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		HttpSession httpSession = request.getSession();
		loginId = httpSession.getAttribute("loginId").toString();
		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		if (!isMultipart) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File("c:\\temp"));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {
			// Parse the request to get file items.
			@SuppressWarnings("rawtypes")
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			@SuppressWarnings("rawtypes")
			Iterator i = fileItems.iterator();
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					System.out.println("fieldName is.." + fieldName);
					fileName = fi.getName();
					System.out.println("fileName is.." + fileName);
					String contentType = fi.getContentType();
					System.out.println("contentType is.." + contentType);
					boolean isInMemory = fi.isInMemory();
					System.out.println("isInMemory" + isInMemory);
					long sizeInBytes = fi.getSize();
					System.out.println("sizeInBytes.." + sizeInBytes);
					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(
								filePath
										+ fileName.substring(fileName
												.lastIndexOf("\\")));
					} else {
						file = new File(
								filePath
										+ fileName.substring(fileName
												.lastIndexOf("\\") + 1));
					}
					fi.write(file);
					out.println("Uploaded Filename: " + fileName + "<br>");
				}
				// filePath +
				String uploadedfile = filePath + fileName;
				System.out.println("uploadedfile name is" + uploadedfile);

				ReadCSV(uploadedfile);

			}

		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private void ReadCSV(String fileName) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		String cquery = "FROM RegisterPojo as r where r.emailId=:mailId";
		@SuppressWarnings("rawtypes")
		List getId = session.createQuery(cquery).setString("mailId", loginId)
				.list();
		for (@SuppressWarnings("rawtypes")
		Iterator iterator = getId.iterator(); iterator.hasNext();) {
			RegisterPojo registerPojo = (RegisterPojo) iterator.next();
			id = registerPojo.getLoginId();
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
			for (int i = 0; i < mySheet.getPhysicalNumberOfRows(); i++) {

				session = sessionFactory.openSession();
				transaction = session.beginTransaction();
				HSSFRow row = mySheet.getRow(i);

				HSSFCell name = row.getCell(0);
				HSSFCell email = row.getCell(1);
				row.getCell(2).setCellType(1);
				HSSFCell phone = row.getCell(2);
				HSSFCell notes = row.getCell(3, Row.CREATE_NULL_AS_BLANK);
				pojo.setContactId(1);
				pojo.setLoginId(id);
				pojo.setRecipientname(name.toString().trim());
				pojo.setRecipientemail(email.toString().trim());
				pojo.setRecipientphone(phone.toString().trim());
				pojo.setNotes(notes.toString().trim());

				session.save(pojo);
				transaction.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// System.out.println(e.getMessage());
		} finally {
			// Actual contact insertion will happen at this step
			session.flush();
			session.close();
		}

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		throw new ServletException("GET method used with "
				+ getClass().getName() + ": POST method required.");
	}
}
