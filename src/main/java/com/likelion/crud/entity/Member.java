package com.likelion.crud.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private MemberRole role;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "is_account_expired")
    private boolean isAccountExpired;

    @Column(name = "is_account_locked")
    private boolean isAccountLocked;

    public boolean getIsAccountExpired() {
        return this.isAccountExpired;
    }

    public boolean getIsAccountLocked() {
        return this.isAccountLocked;
    }
}
