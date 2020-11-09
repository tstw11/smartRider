package com.smartrider.bicycle.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.smartrider.bicycle.vo.BoardVo;

public interface BoardSQLMapper {
	
	@Select("SELECT MAX(board_no)FROM bicycle_board")
	public int createKey();
	
	@Insert("INSERT INTO bicycle_board(member_no, board_title, board_content, board_readcount, board_writedate) VALUES(#{member_no}, #{board_title}, #{board_content}, 0, SYSDATE())")
	public void insert(BoardVo vo);
	
	@Select("SELECT * FROM bicycle_board ORDER BY board_no DESC")
	public ArrayList<BoardVo> selectAll();
	
	@Select("SELECT * FROM bicycle_board WHERE board_title LIKE CONCAT('%',#{searchWord},'%') ORDER BY board_no DESC")
	public ArrayList<BoardVo> selectByTitle(String searchWord);
	
	
	
	
	//글 보기
	@Select("SELECT * FROM bicycle_board WHERE board_no = #{no}")
	public BoardVo selectByNo(int no);
	
	//조회수 증가...
	@Update("UPDATE bicycle_board SET board_readcount = board_readcount + 1 WHERE board_no = #{no}")
	public void updateCount(int no);
	
	//글 삭제....
	@Delete("DELETE FROM bicycle_board WHERE board_no = #{no}")
	public void delete(int no);
	
	
	//글 수정....
	@Update("UPDATE bicycle_board SET board_title = #{board_title} , board_content = #{board_content} WHERE board_no = #{board_no}")
	public void updateTitleAndContent(BoardVo xxxx);

}
