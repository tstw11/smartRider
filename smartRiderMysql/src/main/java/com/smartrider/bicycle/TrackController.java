package com.smartrider.bicycle;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartrider.bicycle.mapper.MemberSQLMapper;
import com.smartrider.bicycle.mapper.TrackSQLMapper;
import com.smartrider.bicycle.vo.MemberVo;
import com.smartrider.bicycle.vo.TrackVo;

@Controller
public class TrackController {
	
	@Autowired
	private MemberSQLMapper memberSqlMapper;
	
	@Autowired
	private TrackSQLMapper trackSQLMapper;
	
	// 주행기록페이지
	@RequestMapping("/track_page.do")
	public String TrackPage(Model model, String search_word) {
		
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String,Object>>();
		
		ArrayList<TrackVo> trackList = null;
		
		if (search_word == null) {
			trackList = trackSQLMapper.selectAll();
		}
		
		for (TrackVo trackVo : trackList) {
			String member_id = trackVo.getMember_id();
			
			MemberVo memberVo = trackSQLMapper.selectById(member_id);
			
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put("memberVo", memberVo);
			map.put("trackVo", trackVo);
			
			resultList.add(map);
		}
		
		model.addAttribute("xxx", resultList);
		
		return "track_page";
		
			
	}
}
