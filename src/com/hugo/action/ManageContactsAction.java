package com.hugo.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
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
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.upload.FormFile;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hugo.dao.HibernateConfiguration;
import com.hugo.form.GetDataForm;
import com.hugo.form.ManageContactsForm;
import com.hugo.pojo.GroupContactsPojo;
import com.hugo.pojo.GroupPojo;
import com.hugo.pojo.RegisterPojo;
import com.hugo.pojo.UploadPojo;

public class ManageContactsAction extends DispatchAction {
	private int Id;
	int cid;
	int lid;
	String loginId;
	String path;
	List size;
	String notes;
	String groupname;
	HibernateConfiguration hiberconfig = null;
	Transaction transaction;
	Session session = null;

	public ActionForward insertdata(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession httpSession = request.getSession();
		loginId = httpSession.getAttribute("loginId").toString();

		ManageContactsForm manageform = (ManageContactsForm) form;
		groupname = manageform.getCreategroup();
		FileOutputStream outputStream = null;
		FormFile formFile = null;
		try {
			formFile = manageform.getFilelocation();
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

		hiberconfig = new HibernateConfiguration();
		List getId = hiberconfig.getEmailId(loginId);

		for (@SuppressWarnings("rawtypes")
		Iterator iterator = getId.iterator(); iterator.hasNext();) {
			RegisterPojo registerPojo = (RegisterPojo) iterator.next();
			Id = registerPojo.getLoginId();
		}
		String hql = "FROM GroupPojo as get WHERE get.groupname=:gname and get.loginid=:loginid";
		@SuppressWarnings("rawtypes")
		Session session1 = HibernateConfiguration.getsession();
		Query query3 = session1.createQuery(hql);
		query3.setParameter("gname", groupname);
		query3.setParameter("loginid", Id);
		size = query3.list();

		List<UploadPojo> list = hiberconfig.insertvalues(loginId);
		System.out.println(list.size());
		for (UploadPojo uploadpojo : list) {
			notes = uploadpojo.getNotes();
			// System.out.println(i+j+m+k);
			// transaction.commit();
			session1.close();
		}

		// manageform.setMessage("The file "+formFile.getFileName()+" is uploaded successfully.");
		if (path != null && !path.equals("")) {
			if (size.isEmpty()) {
				session = HibernateConfiguration.getsession();
				Transaction tx = session.beginTransaction();
				GroupPojo grouppojo = new GroupPojo();
				grouppojo.setLoginid(Id);
				grouppojo.setGroupname(groupname);
				session.save(grouppojo);
				tx.commit();
				session.flush();
				session.close();
			}
			cid = Id;
			if (cid == Id) {
				FileInputStream myInput = new FileInputStream(path);

				POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);

				HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);

				HSSFSheet mySheet = myWorkBook.getSheetAt(0);
				System.out.println("No.of records are.."
						+ mySheet.getPhysicalNumberOfRows());

				List<GroupPojo> pojo = hiberconfig.insertvalues(groupname);
				for (GroupPojo gpojo : pojo) {
					lid = gpojo.getGroupid();
				}
				GroupContactsPojo groupcontact = new GroupContactsPojo();
				for (int i = 0; i < mySheet.getPhysicalNumberOfRows(); i++) {
					HSSFRow row = mySheet.getRow(i);
					HSSFCell name = row.getCell(0);
					HSSFCell email = row.getCell(1);
					row.getCell(2).setCellType(1);
					HSSFCell phone = row.getCell(2);
					HSSFCell notes = row.getCell(3, Row.CREATE_NULL_AS_BLANK);

					session = HibernateConfiguration.getsession();
					Transaction transaction1 = session.beginTransaction();
					groupcontact.setMloginid(Id);
					groupcontact.setNotes(notes.toString().trim());
					groupcontact.setRemail(email.toString().trim());
					groupcontact.setRname(name.toString().trim());
					groupcontact.setRphone(phone.toString().trim());
					groupcontact.setMgroupid(lid);
					System.out.println(session.save(groupcontact));
					transaction1.commit();

					session.flush();
					session.close();
				}

			}
		} else {

		}

		return mapping.findForward("success");

	}

}
