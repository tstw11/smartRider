package com.smartrider.bicycle.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.smartrider.bicycle.vo.UploadFileVo;

public interface UploadFileSQLMapper {
	
	@Insert("INSERT INTO bicycle_uploadfile(board_no, file_link) VALUES(#{board_no}, #{file_link})")
	public void insert(UploadFileVo vo);
	
	@Select("SELECT * FROM bicycle_uploadfile WHERE board_no = #{board_no}")
	public ArrayList<UploadFileVo> selectByBoardNo(int board_no);

}
