package com.onlinebuysell.OnlinebuyProject.Entity;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String username;
    private String password;
    private Long contactid;
    private BigInteger   contactnumber;
	
    
    public Long getId() {
		return id;
	}
	
	public BigInteger getContactnumber() {
		return contactnumber;
	}

	public void setContactnumber(BigInteger contactnumber) {
		this.contactnumber = contactnumber;
	}

	public String getPassword() {
		return password;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	public Long getContactid() {
		return contactid;
	}

	public void setContactid(Long contactid) {
		this.contactid = contactid;
	}

}
