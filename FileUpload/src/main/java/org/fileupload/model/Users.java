package org.fileupload.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Users
 * 
 */
@Entity
@Table(name = "Users")
@NamedQueries({
		@NamedQuery(name = "Users.TestLogin", query = "select u from Users u where u.username=:username and u.password=:password") })
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	public Users() {
		super();
	}

	@Column(name = "UUID")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uuid;

	@Column(name = "CNAME")
	private String cname;

	@Column(name = "CSURNAME")
	private String csurname;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "CREATEDATE")
	private Date createdate;

	@Column(name = "GENDER")
	private String gender;

	public int getUuid() {
		return uuid;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCsurname() {
		return csurname;
	}

	public void setCsurname(String csurname) {
		this.csurname = csurname;
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

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
