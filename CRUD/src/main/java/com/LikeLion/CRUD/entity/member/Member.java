package com.LikeLion.CRUD.entity.member;

import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @Column(nullable = false, length = 20)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false, length = 5)
    private String name;

    @Column(nullable = false)
    private Short age;

    @Column(name = "is_account_expired", nullable = false)
    private Boolean isAccountExpired;

    @Column(name = "is_account_locked", nullable = false)
    private Boolean isAccountLocked;

}

