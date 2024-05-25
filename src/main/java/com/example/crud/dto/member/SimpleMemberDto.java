package com.example.crud.dto.member;

import com.example.crud.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class SimpleMemberDto {

    private Integer age;

    private String name;

    public static SimpleMemberDto toDto(Member member){
        return SimpleMemberDto.builder()
                .age(member.getAge())
                .name(member.getName())
                .build();
    }

}
