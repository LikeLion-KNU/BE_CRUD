package com.likelion.crud.api.member.dto.response;

import com.likelion.crud.domain.Member;

public record UpdateMemberResponse(
    String email,
    String password,
    String name
) {
    public static UpdateMemberResponse of(Member member) {
        return new UpdateMemberResponse(member.email(), member.password(), member.name());
    }
}
