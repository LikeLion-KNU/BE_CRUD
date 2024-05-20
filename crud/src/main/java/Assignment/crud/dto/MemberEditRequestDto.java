package Assignment.crud.dto;

import Assignment.crud.domain.Role;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MemberEditRequestDto {

    @NotNull
    private String name;

    private int age;

    @NotNull
    private Role role;

    @NotNull
    private String email;

}
