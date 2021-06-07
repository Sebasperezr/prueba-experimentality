package com.perez.ptbackend.core.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.perez.ptbackend.core.constants.Message;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserModel extends UserDateAuditModel<UUID> {

    @NotEmpty(message = Message.NOT_EMPTY_MESSAGE)
    @Size(max = 100)
    private String name;
    @NotEmpty(message = Message.NOT_EMPTY_MESSAGE)
    @Size(max = 15)
    private String identification;
    @NotEmpty(message = Message.NOT_EMPTY_MESSAGE)
    @Size(max = 100)
    private String username;
    private String password;
    @NotNull(message = Message.NOT_EMPTY_MESSAGE)
    private UUID companyId;
    private boolean changePassword = true;
    @NotNull(message = Message.NOT_EMPTY_MESSAGE)
    private RoleModel role;
    @NotNull(message = Message.NOT_EMPTY_MESSAGE)
    private Set<UserRoleModel> roles = new HashSet<>();


}
