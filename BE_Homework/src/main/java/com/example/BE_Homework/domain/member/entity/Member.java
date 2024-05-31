package com.example.BE_Homework.domain.member.entity;

import com.example.BE_Homework.domain.couponholders.entity.CouponHolders;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder @AllArgsConstructor
@Getter @Setter
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
