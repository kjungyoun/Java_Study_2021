package com.ssafy.model;

import java.io.Serializable;

public class Weather implements Serializable{
	private String hour;
	private String temp;
	private String wfKor;
	private String reh;
	
	public Weather() {}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getWfKor() {
		return wfKor;
	}

	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}

	public String getReh() {
		return reh;
	}

	public void setReh(String reh) {
		this.reh = reh;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(100);
		builder.append("시간: ").append(hour+"시").append("     ")
		.append("온도: ").append(temp+"도").append("     ")
		.append("구름양: ").append(wfKor).append("     ")
		.append("습도: ").append(reh+"%");
		return builder.toString();
	}
	
	
}
