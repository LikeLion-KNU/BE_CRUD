package com.LikeLion.CRUD.dto.member;

import com.LikeLion.CRUD.entity.member.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberInfoDTO {
    private String email;
    private Role role;
    private String name;
    private Short age;
    private Boolean isAccountExpired;
    private Boolean isAccountLocked;
}
