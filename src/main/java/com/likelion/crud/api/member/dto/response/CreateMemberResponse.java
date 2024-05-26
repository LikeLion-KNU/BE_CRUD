package com.likelion.crud.api.member.dto.response;

import com.likelion.crud.domain.Member;
import com.likelion.crud.domain.MemberRole;

public record CreateMemberResponse(
        String name,
        MemberRole role
) {

    public static CreateMemberResponse of(Member member) {
        return new CreateMemberResponse(member.name(), member.role());
    }
}
