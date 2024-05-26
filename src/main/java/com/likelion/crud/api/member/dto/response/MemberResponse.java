package com.likelion.crud.api.member.dto.response;

import com.likelion.crud.domain.Member;

public record MemberResponse(
        Integer age,
        String name
) {
    public static MemberResponse of(Member member) {
        return new MemberResponse(member.age(), member.name());
    }
}
