package Assignment.crud.dto;

import Assignment.crud.domain.Role;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberRequestDto {

    @NotNull
    private String name;

    @NotNull
    private String password;

    private int age;

    private Role role;

    private String email;

    private Boolean isAccountExpired;

    private Boolean isAccountLocked;

}
