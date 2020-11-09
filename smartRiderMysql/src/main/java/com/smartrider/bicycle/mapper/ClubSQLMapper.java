package com.smartrider.bicycle.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


import com.smartrider.bicycle.vo.ClubVo;
import com.smartrider.bicycle.vo.MemberVo;

public interface ClubSQLMapper {

	@Select("SELECT * FROM club ORDER BY club_no DESC")
	public ArrayList<ClubVo> selectClubAll();

	// 중복확인
	@Select("SELECT * FROM club WHERE club_name = #{club_name}")
	public ClubVo selectName(String club_name);

	@Select("SELECT * FROM club WHERE club_area LIKE CONCAT('%',#{searchWord},'%') ORDER BY club_no DESC")
	public ArrayList<ClubVo> selectByarea(String searchWord);

	//
	@Select("SELECT * FROM bicycle_member WHERE member_id = #{id}")
	public MemberVo selectById(String id);

	// 클럽 보기
	@Select("SELECT * FROM club WHERE club_no = #{no}")
	public ClubVo selectByNo(int no);

	// 동호회 생성
	@Insert("INSERT INTO club(member_no, club_name, club_manager, club_phone, club_page, club_area, club_introduce, club_date) "
			+ "VALUES(#{member_no}, #{club_name}, #{club_manager}, #{club_phone}, #{club_page}, #{club_area}, #{club_introduce}, SYSDATE())")
	public void clubInsert(ClubVo vo);
	
	@Select("SELECT MAX(club_no)FROM club")
	public int clubKey();
	
	
	

}
