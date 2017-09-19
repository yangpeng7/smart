package com.democome.smart.controller.home;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

	@GetMapping(value = "/")
	public String home(HttpServletRequest request) {

		List<ProjectVO> projects = new ArrayList<>();
		ProjectVO vo = new ProjectVO();
		vo.setLanguage("JAVA");
		vo.setName("测试");
		projects.add(vo);
		projects.add(vo);
		projects.add(vo);
		projects.add(vo);
		projects.add(vo);
		projects.add(vo);
		projects.add(vo);
		projects.add(vo);
		projects.add(vo);
		projects.add(vo);
		
		request.setAttribute("articles", projects);

		return "home";
	}

}
