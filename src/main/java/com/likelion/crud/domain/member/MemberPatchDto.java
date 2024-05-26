package com.likelion.crud.domain.member;

public record MemberPatchDto(
        String email,
        String password,
        String name
) {

}