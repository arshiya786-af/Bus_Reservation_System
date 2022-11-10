package com.masai.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AvailableAdminSession {
	
	
	@Id
	@Column(unique = true)
	private Integer adminId;
	
	private String uid;
	
	private LocalDateTime dateTime;
	
	
	

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "AvailableAdminSession [adminId=" + adminId + ", uid=" + uid + ", dateTime=" + dateTime + "]";
	}
	
	
	

}
