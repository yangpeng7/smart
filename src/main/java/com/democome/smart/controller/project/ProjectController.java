package com.democome.smart.controller.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.democome.smart.model.project.ProjectDetail;
import com.democome.smart.service.project.ProjectService;

@Controller
public class ProjectController {

	// private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProjectService service;

	// @RequestMapping(value = "/search", method = RequestMethod.POST)
	// public SearchProjectResponse searchUser(@RequestBody SearchProjectRequest
	// request) {
	//
	// if (request.getPageNumber() != null && request.getPageSize() != null) {
	// PageHelper.startPage(request.getPageNumber(), request.getPageSize());
	// }
	//
	// ProjectFilter filter = new ProjectFilter();
	// filter.setKeyword(request.getKeyword());
	// List<Project> projects = service.searchProjectByFilter(filter);
	//
	// PageInfo<Project> pageInfo = new PageInfo<Project>(projects);
	// SearchProjectResponse response = new SearchProjectResponse();
	// response.setProjects(projects);
	// response.setTotalNumber(pageInfo.getSize());
	//
	// return response;
	// }

	@RequestMapping(value = "project/detail", method = RequestMethod.GET)
	public String detail(Model model, @RequestParam(defaultValue = "0") Integer id) {

		ProjectDetail detail = service.getProjectDetail(id);
		model.addAttribute("article", detail.getReadme());

		return "article";
	}

}
