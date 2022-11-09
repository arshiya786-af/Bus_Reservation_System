package com.masai.exceptions;

import java.time.LocalDateTime;

public class errorDetail {
	
	private LocalDateTime time;
	private String msg;
	private String desc;
	
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public errorDetail(LocalDateTime time, String msg, String desc) {
		super();
		this.time = time;
		this.msg = msg;
		this.desc = desc;
	}
	
	public errorDetail() {
		
	}
	@Override
	public String toString() {
		return "errorDetail [time=" + time + ", msg=" + msg + ", desc=" + desc + "]";
	}
	
	
	

}
