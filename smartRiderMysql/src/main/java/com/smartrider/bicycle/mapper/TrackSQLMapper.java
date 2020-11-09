package com.smartrider.bicycle.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;

import com.smartrider.bicycle.vo.MemberVo;
import com.smartrider.bicycle.vo.TrackVo;

public interface TrackSQLMapper {
	
	// 주행기록 아이디 불러오기
	@Select("SELECT * FROM bicycle_member WHERE member_id = #{id}")
	public MemberVo selectById(String id);
	
	@Select("SELECT * FROM TrackDB ORDER BY member_id DESC")
	public ArrayList<TrackVo> selectAll();
}
