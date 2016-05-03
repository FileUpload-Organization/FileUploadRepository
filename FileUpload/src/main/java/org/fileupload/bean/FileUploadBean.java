package org.fileupload.bean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.fileupload.ejb.ShowInformation;
import org.fileupload.model.Users;
import org.primefaces.event.FileUploadEvent;

@Named
@SessionScoped
public class FileUploadBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String destination = "C:/UploadedFilesLocation/";
	private List<Users> usersList;

	@Inject
	private ShowInformation showInformation;
	
	
	public FileUploadBean() {
		File f = new File(destination);
		if (!f.exists())
			f.mkdir();
	}
	
	
	public void upload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		// Do what you want with the file
		try {
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void copyFile(String fileName, InputStream in) {
		try {

			// write the inputStream to a FileOutputStream
			OutputStream out = new FileOutputStream(new File(destination + fileName));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();

			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	@PostConstruct
	public void fillList() {
		try {
			usersList = showInformation.getUsersList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Users> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}

}