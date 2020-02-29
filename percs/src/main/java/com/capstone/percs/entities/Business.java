package com.capstone.percs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Business {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String busName;
	private String punchPassword;
	
	public Business() {
		super();
	}

	public Business(long id, String busName) {
		super();
		this.id = id;
		this.busName = busName;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the busName
	 */
	public String getBusName() {
		return busName;
	}

	/**
	 * @param busName the busName to set
	 */
	public void setBusName(String busName) {
		this.busName = busName;
	}

	/**
	 * @return the punchPassword
	 */
	public String getPunchPassword() {
		return punchPassword;
	}

	/**
	 * @param punchPassword the punchPassword to set
	 */
	public void setPunchPassword(String punchPassword) {
		this.punchPassword = punchPassword;
	}
	
	
	

}
