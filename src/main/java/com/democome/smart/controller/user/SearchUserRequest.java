package com.democome.smart.controller.user;

import com.democome.smart.controller.common.PageRequest;

public class SearchUserRequest extends PageRequest {

	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
