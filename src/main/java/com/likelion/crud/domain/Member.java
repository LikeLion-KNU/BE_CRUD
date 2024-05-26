package com.likelion.crud.domain;

public record Member(
        Long id,
        String email,
        String password,
        MemberRole role,
        String name,
        Integer age,
        Boolean isExpiredAccount,
        Boolean isLockedAccount
) {

}
