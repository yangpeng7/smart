package com.democome.smart.controller.user;

import com.democome.smart.controller.common.PageRequest;

public class SearchUserRequest extends PageRequest {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
