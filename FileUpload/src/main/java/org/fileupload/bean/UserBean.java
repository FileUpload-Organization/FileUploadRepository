package org.fileupload.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.fileupload.service.UsersService;

@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private boolean isLoggedIn = false;

	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	// To Logi n
	public String login() {
		UsersService service = new UsersService();
		if (!(service.getEntityWithNamedQuery("Users.TestLogin", username, password) == null)) {
			isLoggedIn = true;
			return "/fileUpload.jsf?faces-redirect=true";
		}
		return "login";
	}

	// To Logout
	public String logout() {
		isLoggedIn = false;
		System.out.println("Action performed!!!!");
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login.xhtml?faces-redirect=true";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return isLoggedIn;
	}

	public void setLoggedIn(boolean isLoggedIn) {
		this.isLoggedIn = isLoggedIn;
	}

}
