package com.democome.smart.controller.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.democome.smart.model.filter.project.ProjectFilter;
import com.democome.smart.model.project.Project;
import com.democome.smart.service.project.ProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/project")
public class ProjectController {
	
	// private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProjectService service;

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public SearchProjectResponse searchUser(@RequestBody SearchProjectRequest request) {

		if (request.getPageNumber() != null && request.getPageSize() != null) {
			PageHelper.startPage(request.getPageNumber(), request.getPageSize());
		}

		ProjectFilter filter = new ProjectFilter();
		filter.setKeyword(request.getKeyword());
		List<Project> projects = service.searchProjectByFilter(filter);

		PageInfo<Project> pageInfo = new PageInfo<Project>(projects);
		SearchProjectResponse response = new SearchProjectResponse();
		response.setProjects(projects);
		response.setTotalNumber(pageInfo.getSize());

		return response;
	}

}
