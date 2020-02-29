package com.capstone.percs.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Promotion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private long busId;
	private String startImg;
	private String pImg1;
	private String pImg2;
	private String pImg3;
	private String pImg4;
	private String pImg5;
	private String pImg6;
	private String pImg7;
	
	@OneToOne
	@JoinColumn(name="promoId")
	private PunchCard pCard;
	
	@OneToOne
	@JoinColumn(name="busName")
	private Business busName;
	
	
	public Promotion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Promotion(long id, long busId, String pImg1) {
		super();
		this.id = id;
		this.busId = busId;
		this.pImg1 = pImg1;
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

	/**
	 * @return the startImg
	 */
	public String getStartImg() {
		return startImg;
	}

	/**
	 * @param startImg the startImg to set
	 */
	public void setStartImg(String startImg) {
		this.startImg = startImg;
	}
	
	/**
	 * @return the pImg1
	 */
	public String getpImg1() {
		return pImg1;
	}
	
	/**
	 * @param pImg1 the pImg1 to set
	 */
	public void setpImg1(String pImg1) {
		this.pImg1 = pImg1;
	}

	/**
	 * @return the pImg2
	 */
	public String getpImg2() {
		return pImg2;
	}

	/**
	 * @param pImg2 the pImg2 to set
	 */
	public void setpImg2(String pImg2) {
		this.pImg2 = pImg2;
	}

	/**
	 * @return the pImg3
	 */
	public String getpImg3() {
		return pImg3;
	}

	/**
	 * @param pImg3 the pImg3 to set
	 */
	public void setpImg3(String pImg3) {
		this.pImg3 = pImg3;
	}

	/**
	 * @return the pImg4
	 */
	public String getpImg4() {
		return pImg4;
	}

	/**
	 * @param pImg4 the pImg4 to set
	 */
	public void setpImg4(String pImg4) {
		this.pImg4 = pImg4;
	}

	/**
	 * @return the pImg5
	 */
	public String getpImg5() {
		return pImg5;
	}

	/**
	 * @param pImg5 the pImg5 to set
	 */
	public void setpImg5(String pImg5) {
		this.pImg5 = pImg5;
	}

	/**
	 * @return the pImg6
	 */
	public String getpImg6() {
		return pImg6;
	}

	/**
	 * @param pImg6 the pImg6 to set
	 */
	public void setpImg6(String pImg6) {
		this.pImg6 = pImg6;
	}

	/**
	 * @return the pImg7
	 */
	public String getpImg7() {
		return pImg7;
	}

	/**
	 * @param pImg7 the pImg7 to set
	 */
	public void setpImg7(String pImg7) {
		this.pImg7 = pImg7;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Promotion [id=");
		builder.append(id);
		builder.append(", busId=");
		builder.append(busId);
		builder.append(", startImg=");
		builder.append(startImg);
		builder.append(", pImg1=");
		builder.append(pImg1);
		builder.append(", pImg2=");
		builder.append(pImg2);
		builder.append(", pImg3=");
		builder.append(pImg3);
		builder.append(", pImg4=");
		builder.append(pImg4);
		builder.append(", pImg5=");
		builder.append(pImg5);
		builder.append(", pImg6=");
		builder.append(pImg6);
		builder.append(", pImg7=");
		builder.append(pImg7);
		builder.append(", pCard=");
		builder.append(pCard);
		builder.append(", busName=");
		builder.append(busName);
		builder.append("]");
		return builder.toString();
	}

	
	/**
	 * @return the pCard
	 */
	public PunchCard getpCard() {
		return pCard;
	}

	/**
	 * @param pCard the pCard to set
	 */
	public void setpCard(PunchCard pCard) {
		this.pCard = pCard;
	}

	/**
	 * @return the busName
	 */
	public Business getBusName() {
		return busName;
	}

	/**
	 * @param busName the busName to set
	 */
	public void setBusName(Business busName) {
		this.busName = busName;
	}
	
	

}
