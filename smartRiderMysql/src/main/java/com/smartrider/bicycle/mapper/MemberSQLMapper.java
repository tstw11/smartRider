package com.smartrider.bicycle.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.smartrider.bicycle.vo.MemberVo;

public interface MemberSQLMapper {
	
	// 회원가입
	@Insert("INSERT INTO bicycle_member(member_id, member_pw, member_nick, member_email, member_gender, member_area, member_joindate) "
			+ "VALUES(#{member_id}, #{member_pw}, #{member_nick}, #{member_email}, #{member_gender}, #{member_area}, SYSDATE())")
	public void insert(MemberVo memberVo);
	
	// 로그인할 때 ID PW 확인
	@Select("SELECT * FROM bicycle_member WHERE member_id = #{member_id} AND member_pw = #{member_pw}")
	public MemberVo selectByIdAndPw(MemberVo vo);

	// 게시물 관련
	@Select("SELECT * FROM bicycle_member WHERE member_no = #{no}")
	public MemberVo selectByNo(int no);
	
}
