package com.develop.webapp.security;

public enum ApplicationUserPermission {
	CUSTOMER_READ("customer:read"),
	CUSTOMER_DELETE("customer:delete");
	
	private final String permission;

	ApplicationUserPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
	
	
}
