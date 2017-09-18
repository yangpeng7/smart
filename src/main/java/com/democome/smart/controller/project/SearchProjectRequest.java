package com.democome.smart.controller.project;

import com.democome.smart.controller.common.PageRequest;

public class SearchProjectRequest extends PageRequest {

	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
