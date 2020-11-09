package com.smartrider.bicycle;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartrider.bicycle.mapper.ClubSQLMapper;
import com.smartrider.bicycle.mapper.MemberSQLMapper;

import com.smartrider.bicycle.vo.ClubVo;
import com.smartrider.bicycle.vo.MemberVo;

@Controller
public class ClubController {

	@Autowired
	private ClubSQLMapper clubSqlMapper;

	@Autowired
	private MemberSQLMapper memberSqlMapper;

	// 동호회 생성
	@RequestMapping("/club_create.do")
	public String clubCreate() {
		return "club_create";
	}

	// 클럽생성 프로세스
	@RequestMapping("/create_club_process.do")
	public String ClubProcess(ClubVo vo, HttpSession session) {

		MemberVo memberVo = (MemberVo) session.getAttribute("sessionUserData");
		int member_no = memberVo.getMember_no();
		vo.setMember_no(member_no);

		int club_no = clubSqlMapper.clubKey();
		vo.setClub_no(club_no);
		club_no = club_no + 1;
		clubSqlMapper.clubInsert(vo);

		return "redirect:/club_list.do";
	}

	// 클럽 리스트 페이지
	@RequestMapping("/club_list.do")
	public String clubPage(Model model, String search_word) {

		ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		ArrayList<ClubVo> clubList = null;

		if (search_word == null) {
			clubList = clubSqlMapper.selectClubAll();
		} else {
			clubList = clubSqlMapper.selectByarea(search_word);
		}

		for (ClubVo clubVo : clubList) {
			int member_no = clubVo.getMember_no();
			MemberVo memberVo = memberSqlMapper.selectByNo(member_no);

			HashMap<String, Object> map = new HashMap<String, Object>();

			map.put("memberVo", memberVo);
			map.put("clubVo", clubVo);

			resultList.add(map);

		}
		model.addAttribute("xxx", resultList);

		return "club_list";

	}

	@RequestMapping("/club_list_detail.do")
	public String readClub(int club_no, Model model) {

		ClubVo clubVo = clubSqlMapper.selectByNo(club_no);

		MemberVo memberVo = memberSqlMapper.selectByNo(clubVo.getMember_no());

		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("member", memberVo);
		map.put("club", clubVo);
		model.addAttribute("data", map);

		return "club_list_detail";
	}

}
