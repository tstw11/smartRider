package com.smartrider.bicycle.vo;

import java.util.Date;

public class ClubVo {
	
	private int club_no;	// 클럽 번호
	private int member_no;	// 회원 번호
	private String club_name;	// 클럽 이름
	private String club_manager;	// 대표자 이름
	private String club_phone;	// 클럽 번호
	private String club_page;	//사이트 페이지
	private String club_area;	// 지역
	private String club_introduce;	// 클럽 소개
	private Date club_date;		// 만든 날짜
	
	public ClubVo() {
		super();
	}

	public ClubVo(int club_no, int member_no, String club_name, String club_manager, String club_phone,
			String club_page, String club_area, String club_introduce, Date club_date) {
		super();
		this.club_no = club_no;
		this.member_no = member_no;
		this.club_name = club_name;
		this.club_manager = club_manager;
		this.club_phone = club_phone;
		this.club_page = club_page;
		this.club_area = club_area;
		this.club_introduce = club_introduce;
		this.club_date = club_date;
	}

	public int getClub_no() {
		return club_no;
	}

	public void setClub_no(int club_no) {
		this.club_no = club_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public String getClub_manager() {
		return club_manager;
	}

	public void setClub_manager(String club_manager) {
		this.club_manager = club_manager;
	}

	public String getClub_phone() {
		return club_phone;
	}

	public void setClub_phone(String club_phone) {
		this.club_phone = club_phone;
	}

	public String getClub_page() {
		return club_page;
	}

	public void setClub_page(String club_page) {
		this.club_page = club_page;
	}

	public String getClub_area() {
		return club_area;
	}

	public void setClub_area(String club_area) {
		this.club_area = club_area;
	}

	public String getClub_introduce() {
		return club_introduce;
	}

	public void setClub_introduce(String club_introduce) {
		this.club_introduce = club_introduce;
	}

	public Date getClub_date() {
		return club_date;
	}

	public void setClub_date(Date club_date) {
		this.club_date = club_date;
	}


	
}
