package com.likelion.crud.entity;

import com.likelion.crud.dto.CouponRegisterDto;
import com.likelion.crud.dto.MemberUpdateDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_id")
    private Long id;
    private String email;
    private String password;
    private Role role;
    private String name;
    private int age;
    private boolean isAccountExpired;
    private boolean isAccountLocked;

    @OneToMany(mappedBy = "member")
    private List<CouponHolders> couponHolders;

    public void update(MemberUpdateDto.Request memberUpdateDtoRequest) {
        this.email = memberUpdateDtoRequest.getEmail();
        this.age = memberUpdateDtoRequest.getAge();
        this.name = memberUpdateDtoRequest.getName();
        this.password = memberUpdateDtoRequest.getPassword();
    }
}
