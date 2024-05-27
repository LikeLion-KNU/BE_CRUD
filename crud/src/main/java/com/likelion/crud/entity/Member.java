package com.likelion.crud.entity;

import com.likelion.crud.dto.MemberUpdateDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;
    private String email;
    private String password;
    private Role role;
    private String name;
    private int age;
    private boolean isAccountExpired;
    private boolean isAccountLocked;

    public void update(MemberUpdateDto.Request memberUpdateDtoRequest) {
        this.email = memberUpdateDtoRequest.getEmail();
        this.age = memberUpdateDtoRequest.getAge();
        this.name = memberUpdateDtoRequest.getName();
        this.password = memberUpdateDtoRequest.getPassword();
    }
}
