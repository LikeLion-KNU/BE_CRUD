package com.example.crud.dto.member;

import com.example.crud.entity.Member;
import com.example.crud.entity.enumType.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class CreateMemberDto {

    @Builder
    @Getter @Setter
    public static class CreateMemberRequest{

        private String email;

        private String password;

        private String name;

        private Integer age;

    }

    @Builder
    @Getter @Setter
    public static class CreateMemberResponse{

        private String name;

        private Role role;

        public static CreateMemberResponse toDto(Member member){
            return CreateMemberResponse
                    .builder()
                    .name(member.getName())
                    .role(member.getRole())
                    .build();
        }

    }

}
