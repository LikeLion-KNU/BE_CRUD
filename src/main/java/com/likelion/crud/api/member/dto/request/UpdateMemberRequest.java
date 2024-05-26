package com.likelion.crud.api.member.dto.request;

public record UpdateMemberRequest(
        String email,
        String password,
        String name
) {
}
