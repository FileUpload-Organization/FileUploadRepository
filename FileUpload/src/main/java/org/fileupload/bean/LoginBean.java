package org.fileupload.bean;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.fileupload.model.Users;
import org.fileupload.service.UsersService;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 12314312521345L;
	private String username;
	private String password;
	private boolean isLoggedIn = false;
	private Users user;

	public LoginBean() {
		// TODO Auto-generated constructor stub
	}

	public String login() {
		UsersService service = new UsersService();
		user = service.getEntityWithNamedQuery("Users.TestLogin", username, password);
		if (!(user == null)) {
			isLoggedIn = true;
			return "/fileUpload.jsf?faces-redirect=true";
		}
		return "login";
	}

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

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}
