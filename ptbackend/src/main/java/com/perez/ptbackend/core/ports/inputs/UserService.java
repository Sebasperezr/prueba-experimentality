package com.perez.ptbackend.core.ports.inputs;

import java.util.Iterator;
import java.util.UUID;
import com.perez.ptbackend.core.models.RoleName;
import com.perez.ptbackend.core.models.UserModel;
import com.perez.ptbackend.core.ports.base.CRUDService;
import com.perez.ptbackend.infrastructore.persistence.jpa.entities.RoleEntity;
import com.perez.ptbackend.infrastructore.persistence.jpa.entities.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService, CRUDService<UserModel, UUID> {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    UserEntity getUserById(UUID userId);

    UserEntity getCurrentUser();

    UserModel getCurrentUserMapped();

    UserModel findById(UUID id);

    UserModel save(UserModel userModel);

    void havePermission(RoleName action, UserEntity currentUser);

    void havePermission(RoleName[] actions, UserEntity currentUser);

    boolean isThereARole(Iterator<RoleEntity> roles, RoleName roleName);


}
