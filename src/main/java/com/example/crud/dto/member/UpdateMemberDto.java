package com.example.crud.dto.member;

import com.example.crud.entity.Member;
import com.example.crud.entity.enumType.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class UpdateMemberDto {

    @Builder
    @Getter
    @Setter
    public static class UpdateMemberRequest{

        private Long memberId;

        private String email;

        private String password;

        private String name;

    }

    @Builder
    @Getter @Setter
    public static class UpdateMemberResponse{

        private Long memberId;

        private String email;

        private String password;

        private String name;

        public static UpdateMemberResponse toDto(Member member){
            return UpdateMemberResponse
                    .builder()
                    .memberId(member.getId())
                    .name(member.getName())
                    .password(member.getPassword())
                    .email(member.getEmail())
                    .build();
        }
    }


}
