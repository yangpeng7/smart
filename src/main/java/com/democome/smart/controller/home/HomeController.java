package com.democome.smart.controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.democome.smart.model.filter.project.ProjectFilter;
import com.democome.smart.model.project.Project;
import com.democome.smart.service.project.ProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class HomeController {

	@Autowired
	private ProjectService service;

	@RequestMapping(value = "/home")
	public String index(Model model, @RequestParam(defaultValue = "1") Integer pageNumber,
			@RequestParam(defaultValue = "21") Integer pageSize) {

		PageHelper.startPage(pageNumber, pageSize);

		ProjectFilter filter = new ProjectFilter();

		List<Project> projects = service.searchProjectByFilter(filter);

		PageInfo<Project> pageInfo = new PageInfo<Project>(projects);

		model.addAttribute("pageNum", pageInfo.getPageNum());
		model.addAttribute("pageSize", pageInfo.getPageSize());
		model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
		model.addAttribute("totalPages", pageInfo.getPages());

		if (pageNumber <= 5) {
			model.addAttribute("beginPage", 1);
			model.addAttribute("endPage", 5);
		} else {
			model.addAttribute("beginPage", pageNumber - 3);
			model.addAttribute("endPage", pageNumber + 2);
		}

		model.addAttribute("isLastPage", pageInfo.isIsLastPage());
		model.addAttribute("articles", pageInfo.getList());

		return "home";
	}

}
