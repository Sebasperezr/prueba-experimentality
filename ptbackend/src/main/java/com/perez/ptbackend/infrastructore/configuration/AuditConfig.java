package com.perez.ptbackend.infrastructore.configuration;

import java.util.Optional;
import java.util.UUID;
import com.perez.ptbackend.core.models.UserPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing
public class AuditConfig {
	@Bean
	public AuditorAware<UUID> auditorProvider() {
		return new SpringSecurityAuditAwareImpl();
	}

	static class SpringSecurityAuditAwareImpl implements AuditorAware<UUID> {

		@Override
		public Optional<UUID> getCurrentAuditor() {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

			if (authentication == null || !authentication.isAuthenticated()
					|| authentication instanceof AnonymousAuthenticationToken) {
				return Optional.empty();
			}

			UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

			return Optional.ofNullable(userPrincipal.getId());
		}
	}
}
