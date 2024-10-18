package com.example.SPRING_EXAM_MAVEN.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MobileEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Mobile_ID;
	
	private String Mobile_Name;
	
	private String Mobile_Ram;
	
	private String Mobile_Price;
	
	private String Mobile_Battery;

	@Override
	public String toString() {
		return "MobileEntity [Mobile_ID=" + Mobile_ID + ", Mobile_Name=" + Mobile_Name + ", Mobile_Ram=" + Mobile_Ram
				+ ", Mobile_Price=" + Mobile_Price + ", Mobile_Battery=" + Mobile_Battery + "]";
	}

	public MobileEntity(Integer mobile_ID, String mobile_Name, String mobile_Ram, String mobile_Price,
			String mobile_Battery) {
		super();
		Mobile_ID = mobile_ID;
		Mobile_Name = mobile_Name;
		Mobile_Ram = mobile_Ram;
		Mobile_Price = mobile_Price;
		Mobile_Battery = mobile_Battery;
	}

	public MobileEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getMobile_ID() {
		return Mobile_ID;
	}

	public void setMobile_ID(Integer mobile_ID) {
		Mobile_ID = mobile_ID;
	}

	public String getMobile_Name() {
		return Mobile_Name;
	}

	public void setMobile_Name(String mobile_Name) {
		Mobile_Name = mobile_Name;
	}

	public String getMobile_Ram() {
		return Mobile_Ram;
	}

	public void setMobile_Ram(String mobile_Ram) {
		Mobile_Ram = mobile_Ram;
	}

	public String getMobile_Price() {
		return Mobile_Price;
	}

	public void setMobile_Price(String mobile_Price) {
		Mobile_Price = mobile_Price;
	}

	public String getMobile_Battery() {
		return Mobile_Battery;
	}

	public void setMobile_Battery(String mobile_Battery) {
		Mobile_Battery = mobile_Battery;
	}

}
