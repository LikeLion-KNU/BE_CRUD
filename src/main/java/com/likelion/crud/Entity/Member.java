package com.likelion.crud.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@NoArgsConstructor
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;
    private String name;
    private int age;
    private Boolean is_account_expired;
    private Boolean is_account_locked;

    @OneToMany(mappedBy = "member")
    private List<CouponHolders> couponHolders = new ArrayList<>();
}
