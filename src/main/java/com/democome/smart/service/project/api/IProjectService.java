package com.democome.smart.service.project.api;

import java.util.List;

import com.democome.smart.model.filter.project.ProjectFilter;
import com.democome.smart.model.project.Project;
import com.democome.smart.model.project.ProjectDetail;

public interface IProjectService {

	public List<Project> searchProjectByFilter(ProjectFilter filter);

	public Project getProject(Integer id);
	
	public ProjectDetail getProjectDetail(Integer id);

	public void createProject(Project project);

	public void updateProject(Project project);

	public void deleteProjectr(Integer id);
}
