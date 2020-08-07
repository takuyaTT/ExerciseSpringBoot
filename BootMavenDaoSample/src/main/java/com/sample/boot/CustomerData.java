package com.sample.boot;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	@Column(length = 200, nullable = true)
	private String mail;
	
	@Column(nullable = true)
	private Integer age;
	
	@Column(length = 5, nullable = true)
	private String gender;
	
	@Column(nullable = true)
	private String memo;
	
	// Getter / Setter
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getMail() {return mail;}
	public void setMail(String mail) {this.mail = mail;}
	public Integer getAge() {return age;}
	public void setAge(Integer age) {this.age = age;}
	public String getMemo() {return memo;}
	public void setMemo(String memo) {this.memo = memo;}
	public String getGender() {return gender;}
	public void setGender(String gender) {this.gender = gender;}
	
}
