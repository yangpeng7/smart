package com.democome.smart.controller.project;

import java.util.List;

import com.democome.smart.controller.common.PageResponse;
import com.democome.smart.model.project.Project;

public class SearchProjectResponse extends PageResponse {

	private List<Project> projects;

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

}
