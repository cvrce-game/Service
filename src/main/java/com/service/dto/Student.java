package com.service.dto;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "ForeignKeyAssoEntity")
@Table(name="Student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="studentId",unique = true, nullable = false)
	private int studentId;

	@Column(name="email",unique = true, nullable = false, length = 100)
	private String email;

	@Column(name="firstName",unique = false, nullable = false, length = 100)
	private String firstName;

	@Column(name="lastName",unique = false, nullable = false, length = 100)
	private String lastName;
	
	@Column(name="accountId",unique = false, nullable = false, length = 100)
	private int accountId;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<AccountEntity> accounts;

	public Integer getstudentId() {
		return studentId;
	}

	public void setstudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountEntity> accounts) {
		this.accounts = accounts;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", email=" + email + ", firstName=" + firstName + ", lastName="
				+ lastName + ", accountId=" + accountId + ", accounts=" + accounts + "]";
	}
	
}
