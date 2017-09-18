package com.democome.smart.model.filter.project;

import org.springframework.util.StringUtils;

public class ProjectFilter {

	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {

		if (!StringUtils.isEmpty(keyword)) {
			this.keyword = "%" + keyword + "%";
		}

	}

}
