package com.smartrider.bicycle;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.smartrider.bicycle.mapper.BoardSQLMapper;
import com.smartrider.bicycle.mapper.MemberSQLMapper;
import com.smartrider.bicycle.mapper.UploadFileSQLMapper;
import com.smartrider.bicycle.vo.BoardVo;
import com.smartrider.bicycle.vo.MemberVo;
import com.smartrider.bicycle.vo.UploadFileVo;

@Controller
public class BoardController {
	
	@Autowired
	private BoardSQLMapper boardSQLMapper;
	
	@Autowired
	private MemberSQLMapper memberSqlMapper;
	
	@Autowired
	private UploadFileSQLMapper uploadFileSQLMapper;
	
	@RequestMapping("/main_page_about.do")
	public String mainPage(Model model, String search_word, String pnum) {
		
		int pageNum = 1;
		if (pnum != null) {
			pageNum = Integer.parseInt(pnum);
		}
		
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String,Object>>();
		
		ArrayList<BoardVo> boardList = null;
		
		if (search_word == null) {
			boardList = boardSQLMapper.selectAll();
		} else {
			boardList = boardSQLMapper.selectByTitle(search_word);
		}
		
		for (BoardVo boardVo : boardList) {
			int member_no = boardVo.getMember_no();
			MemberVo memberVo = memberSqlMapper.selectByNo(member_no);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			// (그냥 쓰는 키 값, 진짜 값) put get만 알면 됌
			map.put("memberVo", memberVo);
			map.put("boardVo", boardVo);
			
			resultList.add(map);
		}
		
		model.addAttribute("xxx", resultList);
		
		return "main_page_about";
		
	}
	
	
	
	
	
	// 글 쓰기 페이지
	@RequestMapping("/write_content_page.do")
	public String writeContentPage() {
		
		return "write_content_page";
	}
	
	
	// 파일 업로드
	@RequestMapping("/write_content_process.do")
	public String WriteContentProcess(MultipartFile [] files, BoardVo vo, HttpSession session) {
		
		ArrayList<UploadFileVo> fileList = new ArrayList<UploadFileVo>();
		
		String rootFolderName = "C:\\upload\\";
		
		// 현재 시간 가져오기
		Date now = new Date();
		
		// 날짜를 문자로 만들어주는 API
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tempNow = sdf.format(now);
		
		String uploadFolder = rootFolderName + tempNow;
		
		File uploadPath = new File(uploadFolder);
		
		if (!uploadPath.exists()) {
			uploadPath.mkdirs();
		}
		
		// 파일 업로드 처리...
		for (MultipartFile x : files) {
			
			// 예외처리 파일이 없어도 들어가는거 방지
			if (x.getSize() <= 0) {
				continue;
			}
			
			// 랜덤 + 시간 : 안전성 향상
			// 독특한 아이디를 만들어주는 API 싱글톤 패턴
			UUID uuid = UUID.randomUUID();
			String uploadFileName = uuid.toString();
			
			long tempCurrentTime = System.currentTimeMillis();
			
			uploadFileName = uploadFileName + "_" + tempCurrentTime;
			
			// 확장자 처리
			String oriFilleName = x.getOriginalFilename();
			String ext = oriFilleName.substring(oriFilleName.lastIndexOf("."));
			
			uploadFileName += ext;
			
			// 파일 결과 담는 것
			File dest = new File(uploadFolder, uploadFileName);
			
			try {
				x.transferTo(dest);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			String fileLink = tempNow + "/" + uploadFileName;
			UploadFileVo fileVo = new UploadFileVo();
			fileVo.setFile_link(fileLink);
			
			fileList.add(fileVo);
			
			
			// 알아보기 검색해보기
			// x.getOriginalFilename()
			
		}
		
		MemberVo memberVo = (MemberVo)session.getAttribute("sessionUserData");
		int member_no = memberVo.getMember_no();
		vo.setMember_no(member_no);
		
		int board_no = boardSQLMapper.createKey();
		vo.setBoard_no(board_no);
		board_no = board_no + 1;
		boardSQLMapper.insert(vo);
		
		for (UploadFileVo fileVo : fileList) {
			fileVo.setBoard_no(board_no);
			uploadFileSQLMapper.insert(fileVo);
		}
		
		return "redirect:./main_page_about.do";
		
		
		
		
		
	}
	
		
	
	// 글 보기
	@RequestMapping("/read_content_page.do")
	public String readContentPage(int board_no, Model model) {
		
		boardSQLMapper.updateCount(board_no);
		
		BoardVo boardVo = boardSQLMapper.selectByNo(board_no);
		
		MemberVo memberVo = memberSqlMapper.selectByNo(boardVo.getMember_no());
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		ArrayList<UploadFileVo> fileList = uploadFileSQLMapper.selectByBoardNo(board_no);
		map.put("a", memberVo);
		map.put("b", boardVo);
		map.put("c", fileList);
		model.addAttribute("data", map);
		
		return "read_content_page";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	// 글 삭제 프로세스
	@RequestMapping("/delete_content_process")
	public String deleteContentProcess(int board_no) {
		
		boardSQLMapper.delete(board_no);
		
		return "redirect:./main_page_about.do";
		
	}
	
	
	
	
	
	
	// 글 수정 페이지
	@RequestMapping("/update_content_page.do")
	public String updateContentPage(int board_no, Model model) {
		
		BoardVo boardVo = boardSQLMapper.selectByNo(board_no);
		MemberVo memberVo = memberSqlMapper.selectByNo(boardVo.getMember_no());
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("memberVo", memberVo);
		map.put("boardVo", boardVo);
		
		model.addAttribute("data", map);
		
		return "update_content_page";
		
	}
	
	
	
	
	// 글 수정 프로세스
	@RequestMapping("/update_content_process.do")
	public String updateContentProcess(BoardVo vo) {
		
		boardSQLMapper.updateTitleAndContent(vo);
		
		return "redirect:./main_page_about.do";
	}
	
	
	
	

}
