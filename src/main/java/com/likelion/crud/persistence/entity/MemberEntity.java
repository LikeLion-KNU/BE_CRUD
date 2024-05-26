package com.likelion.crud.persistence.entity;

import com.likelion.crud.domain.Member;
import com.likelion.crud.domain.MemberRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "member")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private MemberRole role;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "age", nullable = false)
    private Integer age;

    @Column(name = "is_account_expired", nullable = false)
    private Boolean isExpiredAccount;

    @Column(name = "is_account_locked", nullable = false)
    private Boolean isLockedAccount;

    public Member toDomain() {
        return new Member(
                memberId,
                email,
                password,
                role,
                name,
                age,
                isExpiredAccount,
                isLockedAccount
        );
    }

    public static MemberEntity fromDomain(Member member) {
        return new MemberEntity(
                member.id(),
                member.email(),
                member.password(),
                member.role(),
                member.name(),
                member.age(),
                member.isExpiredAccount(),
                member.isLockedAccount()
        );
    }
}
