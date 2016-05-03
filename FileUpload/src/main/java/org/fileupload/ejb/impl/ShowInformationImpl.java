package org.fileupload.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import org.fileupload.ejb.ShowInformation;
import org.fileupload.model.Users;
import org.fileupload.service.UsersService;

@Stateless
public class ShowInformationImpl implements ShowInformation {

	public ShowInformationImpl() {
		System.out.println("Ejb Creation starts");
	}

	private UsersService userService;

	@Override
	public List<Users> getUsersList() {
		userService = new UsersService();
		return userService.getListWithNamedQuery("Users.FindAllUsers");
	}

}
