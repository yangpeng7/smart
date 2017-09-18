package com.democome.smart.service.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.democome.smart.mapper.ProjectMapper;
import com.democome.smart.model.filter.project.ProjectFilter;
import com.democome.smart.model.project.Project;
import com.democome.smart.service.project.api.IProjectService;

@Service
public class ProjectService implements IProjectService {

	@Autowired
	private ProjectMapper mapper;

	@Override
	public List<Project> searchProjectByFilter(ProjectFilter filter) {

		return mapper.selectProjectByFilter(filter);
	}

	@Override
	public Project getProject(Integer id) {

		return mapper.selectProjectById(id);
	}

	@Override
	public void createProject(Project project) {

		mapper.insertProject(project);
	}

	@Override
	public void updateProject(Project project) {

		mapper.updateProject(project);
	}

	@Override
	public void deleteProjectr(Integer id) {

		mapper.deleteProject(id);
	}

}
