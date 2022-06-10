package com.study.jsp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.jsp.VO.ActorVO;

//RestControllex X
@Controller
public class HomeController {
	@GetMapping("/home")
	public String loadHomePage(ModelMap map) {
		//왼쪽은 key 오른쪽은 value
		map.addAttribute("name", "손흥민");
		map.addAttribute("backNumber" , 7);
		map.addAttribute("size", 100);
		
		List<String> list = new ArrayList<String>();
		list.add("씨아");
		list.add("쏠");
		list.add("윤은혜");
		map.addAttribute("wsgList", list);
		
		List<ActorVO> actorList = new ArrayList<ActorVO>();
		ActorVO a1 = new ActorVO();
		a1.name = "이병헌";
		a1.age = 51;
		ActorVO a2 = new ActorVO();
		a2.name = "차승원";
		a2.age = 52;
		actorList.add(a1);
		actorList.add(a2);
		map.addAttribute("actorList", actorList);
		
		List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
		Map<String,Object> map1 = new HashMap<String, Object>();
		Map<String,Object> map2 = new HashMap<String, Object>();
		map1.put("no", 300);
		map2.put("no", 100);
		mapList.add(map1);
		mapList.add(map2);
		map.addAttribute("mapList", mapList);
		
		return "index"; //jsp 파일명 리턴
	}

	@GetMapping("/board")
	public String loadBoardPage(ModelMap map, HttpSession httpSession) {
		
		Map<String, Object> data = new HashMap<String, Object>();
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("Company", "Alfreds Futterkiste");
		map1.put("Contact", "Maria Anders");
		map1.put("Country", "Germany");
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("Company", "Centro comercial Moctezuma");
		map2.put("Contact", "Francisco Chang");
		map2.put("Country", "Mexico");
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("Company", "Ernst Handel");
		map3.put("Contact", "Roland Mendel");
		map3.put("Country", "Austria");
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
	
		data.put("list", list);
		map.addAttribute("data", data);
		
		//세션데이터 가져오기
		String userId = (String)httpSession.getAttribute("userId");
		String userPassword = (String)httpSession.getAttribute("userPassword");
		System.out.println("세션에서 가져온 데이터" + userId);
		
		
		if(userId == null) {
			//redirect : 재요청
			return "redirect:/login";
		}
		map.addAttribute("userId",userId);
		map.addAttribute("userNo",100);
		return "board";
	}
	@GetMapping("/")
	public String loadMainPage() {
		return "home";
	}
	@GetMapping("/login")
	public String loadloginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public @ResponseBody boolean callLogin(
			@RequestBody Map<String , Object> data,
			HttpSession httpSession) {
		String userId = (String) data.get("userId");
		String userPassword = (String) data.get("userPassword");
		
		System.out.println(userId);
		System.out.println(userPassword);
		
		//세션에 데이터 SET
		httpSession.setAttribute("userId", userId);
		httpSession.setAttribute("userPassword", userPassword);
		
		return true;
	}

	@GetMapping("/logout")
	public String goLoginPage(HttpSession httpSession) {
		httpSession.removeAttribute("userId");
		httpSession.removeAttribute("userPassword");
		return "login";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
