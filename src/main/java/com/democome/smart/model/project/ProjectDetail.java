package com.democome.smart.model.project;

import java.io.Serializable;

public class ProjectDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	private int githubId;
	private String readme;

	public int getGithubId() {
		return githubId;
	}

	public void setGithubId(int githubId) {
		this.githubId = githubId;
	}

	public String getReadme() {
		return readme;
	}

	public void setReadme(String readme) {
		this.readme = readme;
	}

}
