package com.capstone.percs.entities;

import javax.persistence.*;

@Entity
public class PunchCard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String punch; // This is the relative file location for the artwork.
//	private long userId;
	private long busId;
	private long promoId;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	
	public PunchCard() {
	
	}

	public PunchCard(long id, String punch, long busId, long promoId) {
		super();
		this.id = id;
		this.punch = punch;
		this.busId = busId;
		this.promoId = promoId;
		
		
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
	
//	/**
//	 * @return the userId
//	 */
//	public long getUserId() {
//		return userId;
//	}
//
//	/**
//	 * @param userId the userId to set
//	 */
//	public void setUserId(long userId) {
//		this.userId = userId;
//	}

	/**
	 * @return the busId
	 */
	public long getBusId() {
		return busId;
	}

	/**
	 * @param busId the busId to set
	 */
	public void setBusId(long busId) {
		this.busId = busId;
	}

//	/**
//	 * @return the promoId
//	 */
//	public long getPromoId() {
//		return promoId;
//	}
//
//	/**
//	 * @param promoId the promoId to set
//	 */
//	public void setPromoId(long promoId) {
//		this.promoId = promoId;
//	}

	/**
	 * @return the punch
	 */
	public String getPunch() {
		return punch;
	}

	/**
	 * @param punch the punch to set
	 */
	public void setPunch(String punch) {
		this.punch = punch;
	}

	/**
	 * @return the promoId
	 */
	public long getPromoId() {
		return promoId;
	}

	/**
	 * @param promoId the promoId to set
	 */
	public void setPromoId(long promoId) {
		this.promoId = promoId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PunchCard [id=");
		builder.append(id);
		builder.append(", punch=");
		builder.append(punch);
		builder.append(", busId=");
		builder.append(busId);
		builder.append(", user=");
		builder.append(user);
		builder.append("]");
		return builder.toString();
	}

	
	
	
	

}
