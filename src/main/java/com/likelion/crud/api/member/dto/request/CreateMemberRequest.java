package com.likelion.crud.api.member.dto.request;

public record CreateMemberRequest(
        String email,
        String password,
        String name,
        Integer age
) {

}
