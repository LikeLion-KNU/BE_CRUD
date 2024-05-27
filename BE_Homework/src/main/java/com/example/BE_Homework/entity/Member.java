package com.example.BE_Homework.entity;

import com.example.BE_Homework.entity.enumType.Role;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder @AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String name;

    private Integer age;

    private Boolean isAccountExpired;

    private Boolean isAccountLocked;

    @OneToMany(mappedBy = "member")
    private List<CouponHolders> couponHolders;
}
