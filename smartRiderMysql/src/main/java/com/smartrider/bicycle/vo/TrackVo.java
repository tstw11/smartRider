package com.smartrider.bicycle.vo;

public class TrackVo {
	
	private String member_id;  
	private String START_ADDR;
	private String START_TIME; 
	private String START_X; 
	private String START_Y; 
	private String END_ADDR; 
	private String END_TIME; 
	private String AVG_SPEED; 
	private String MAX_SPEED; 
	private String CALORIE; 
	private String DISTANCE; 
	private String END_X; 
	private String END_Y;
	
	public TrackVo() {
		super();
	}

	public TrackVo(String member_id, String sTART_ADDR, String sTART_TIME, String sTART_X, String sTART_Y,
			String eND_ADDR, String eND_TIME, String aVG_SPEED, String mAX_SPEED, String cALORIE, String dISTANCE,
			String eND_X, String eND_Y) {
		super();
		this.member_id = member_id;
		START_ADDR = sTART_ADDR;
		START_TIME = sTART_TIME;
		START_X = sTART_X;
		START_Y = sTART_Y;
		END_ADDR = eND_ADDR;
		END_TIME = eND_TIME;
		AVG_SPEED = aVG_SPEED;
		MAX_SPEED = mAX_SPEED;
		CALORIE = cALORIE;
		DISTANCE = dISTANCE;
		END_X = eND_X;
		END_Y = eND_Y;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getSTART_ADDR() {
		return START_ADDR;
	}

	public void setSTART_ADDR(String sTART_ADDR) {
		START_ADDR = sTART_ADDR;
	}

	public String getSTART_TIME() {
		return START_TIME;
	}

	public void setSTART_TIME(String sTART_TIME) {
		START_TIME = sTART_TIME;
	}

	public String getSTART_X() {
		return START_X;
	}

	public void setSTART_X(String sTART_X) {
		START_X = sTART_X;
	}

	public String getSTART_Y() {
		return START_Y;
	}

	public void setSTART_Y(String sTART_Y) {
		START_Y = sTART_Y;
	}

	public String getEND_ADDR() {
		return END_ADDR;
	}

	public void setEND_ADDR(String eND_ADDR) {
		END_ADDR = eND_ADDR;
	}

	public String getEND_TIME() {
		return END_TIME;
	}

	public void setEND_TIME(String eND_TIME) {
		END_TIME = eND_TIME;
	}

	public String getAVG_SPEED() {
		return AVG_SPEED;
	}

	public void setAVG_SPEED(String aVG_SPEED) {
		AVG_SPEED = aVG_SPEED;
	}

	public String getMAX_SPEED() {
		return MAX_SPEED;
	}

	public void setMAX_SPEED(String mAX_SPEED) {
		MAX_SPEED = mAX_SPEED;
	}

	public String getCALORIE() {
		return CALORIE;
	}

	public void setCALORIE(String cALORIE) {
		CALORIE = cALORIE;
	}

	public String getDISTANCE() {
		return DISTANCE;
	}

	public void setDISTANCE(String dISTANCE) {
		DISTANCE = dISTANCE;
	}

	public String getEND_X() {
		return END_X;
	}

	public void setEND_X(String eND_X) {
		END_X = eND_X;
	}

	public String getEND_Y() {
		return END_Y;
	}

	public void setEND_Y(String eND_Y) {
		END_Y = eND_Y;
	} 
	
	

	
	
}
