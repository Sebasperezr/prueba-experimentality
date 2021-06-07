package com.perez.ptbackend.core.business;

import java.util.Iterator;
import java.util.UUID;
import com.perez.ptbackend.core.models.FilterModel;
import com.perez.ptbackend.core.models.RoleName;
import com.perez.ptbackend.core.models.UserModel;
import com.perez.ptbackend.core.ports.inputs.UserService;
import com.perez.ptbackend.infrastructore.persistence.jpa.entities.RoleEntity;
import com.perez.ptbackend.infrastructore.persistence.jpa.entities.UserEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Profile(value = {"dev", "pdn", "docker"})
public class UserServiceImp extends BaseService<UserModel> implements UserService {

    @Override
    public UserModel update(UserModel model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Page<UserModel> list(FilterModel<UserModel> model) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserModel deleteById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserEntity getUserById(UUID userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserEntity getCurrentUser() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserModel getCurrentUserMapped() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserModel findById(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserModel save(UserModel userModel) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void havePermission(RoleName action, UserEntity currentUser) {
        // TODO Auto-generated method stub

    }

    @Override
    public void havePermission(RoleName[] actions, UserEntity currentUser) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isThereARole(Iterator<RoleEntity> roles, RoleName roleName) {
        // TODO Auto-generated method stub
        return false;
    }


}
