package org.fileupload.ejb;

import java.util.List;

import javax.ejb.Local;

import org.fileupload.model.Users;

@Local
public interface ShowInformation {
	List<Users> getUsersList();
}
