package Assignment.crud.dto;

import Assignment.crud.domain.Member;
import Assignment.crud.domain.Role;
import lombok.Data;

@Data
public class MemberResponseDto {

    private Long id;

    private String name;

    private int age;

    private Role role;

    private String email;

    private Boolean isAccountExpired;

    private Boolean isAccountLocked;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.age = member.getAge();
        this.role = member.getRole();
        this.email = member.getEmail();
        this.isAccountExpired = member.getIsAccountExpired();
        this.isAccountLocked = member.getIsAccountLocked();
    }
}
