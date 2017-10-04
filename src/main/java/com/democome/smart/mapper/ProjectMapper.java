package com.democome.smart.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.democome.smart.model.filter.project.ProjectFilter;
import com.democome.smart.model.project.Project;
import com.democome.smart.model.project.ProjectDetail;

public interface ProjectMapper {

	public List<Project> selectProjectByFilter(@Param("filter") ProjectFilter filter);

	public Project selectProjectById(@Param("id") Integer id);

	public ProjectDetail selectProjectDetailByGithubId(@Param("id") Integer id);

	public void insertProject(Project project);

	public void updateProject(Project project);

	public void deleteProject(@Param("id") Integer id);
}
