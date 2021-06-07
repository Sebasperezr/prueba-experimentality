package com.perez.ptbackend.core.models;

import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class UserRoleModel {

    private RoleModel role;
    private UUID userId;
    private UUID headquarterId;



    public RoleModel getRole() {
        return this.role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

}
