package com.perez.ptbackend.core.models;

public enum RoleName {
	SUPERADMIN("SUPERADMIN"), ADMIN("ADMIN"), SUPERVISOR("SUPERVISOR"), OPERATOR(
			"OPERATOR"), CONTROLLER("CONTROLLER"), USER("USER");

	private String value;

	RoleName(String value) {
		this.value = value;
	}

	public static RoleName fromValue(String value) {
		for (RoleName role : values()) {
			if (role.value.equalsIgnoreCase(value)) {
				return role;
			}
		}
		return null;
	}
}
