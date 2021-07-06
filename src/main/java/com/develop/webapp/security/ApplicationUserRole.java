package com.develop.webapp.security;
import com.google.common.collect.Sets;

import java.util.Set;

public enum ApplicationUserRole {
	CUSTOMER(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(
			ApplicationUserPermission.CUSTOMER_READ,
			ApplicationUserPermission.CUSTOMER_DELETE
		));
	
	private final Set<ApplicationUserPermission> permissions;
	
	ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}
	
}
