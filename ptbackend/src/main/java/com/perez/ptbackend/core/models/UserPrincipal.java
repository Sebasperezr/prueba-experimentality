package com.perez.ptbackend.core.models;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import com.perez.ptbackend.infrastructore.persistence.jpa.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

	/**
	*
	*/
	private static final long serialVersionUID = -5341236837435208797L;

	private UserEntity user;

	private Collection<? extends GrantedAuthority> authorities;

	private UserPrincipal(UserEntity user, Collection<? extends GrantedAuthority> authorities) {
		this.user = user;
		this.authorities = authorities;
	}

	private UserPrincipal() {
		this.user = new UserEntity();
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	public static UserPrincipal create(UserEntity user) {
		List<GrantedAuthority> authorities =
				user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getName()))
						.collect(Collectors.toList());

		return new UserPrincipal(user, authorities);
	}

	public UUID getId() {
		return user.getId();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.getDeletedAt() == null;
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.getDeletedAt() == null;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.getDeletedAt() == null;
	}

	@Override
	public boolean isEnabled() {
		return user.getDeletedAt() == null;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}


}
