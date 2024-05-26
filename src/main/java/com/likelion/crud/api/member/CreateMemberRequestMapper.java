package com.likelion.crud.api.member;

import com.likelion.crud.api.member.dto.request.CreateMemberRequest;
import com.likelion.crud.domain.Member;
import com.likelion.crud.domain.MemberRole;
import org.springframework.stereotype.Component;

@Component
public class CreateMemberRequestMapper {

    public Member map(CreateMemberRequest request) {
        return new Member(
                null,
                request.email(),
                request.password(),
                MemberRole.USER,
                request.name(),
                request.age(),
                false,
                false
        );
    }
}
