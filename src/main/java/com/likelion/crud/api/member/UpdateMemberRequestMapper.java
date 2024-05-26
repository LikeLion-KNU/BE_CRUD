package com.likelion.crud.api.member;

import com.likelion.crud.api.member.dto.request.UpdateMemberRequest;
import com.likelion.crud.domain.member.MemberPatchDto;
import org.springframework.stereotype.Component;

@Component
public class UpdateMemberRequestMapper {

    public MemberPatchDto map(UpdateMemberRequest request) {
        return new MemberPatchDto(
                request.email(),
                request.password(),
                request.name()
        );
    }

}
