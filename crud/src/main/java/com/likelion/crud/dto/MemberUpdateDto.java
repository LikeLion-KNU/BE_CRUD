package com.likelion.crud.dto;

import com.likelion.crud.entity.Member;
import lombok.Getter;

public class MemberUpdateDto {
    @Getter
    public static class Response {
        private String name;
        private String password;
        private String email;
        private int age;

        public void update(Member member) {
            name = member.getName();
            password = member.getPassword();
            email = member.getEmail();
            age = member.getAge();
        }

    }
    @Getter
    public static class Request {
        private String password;
        private String name;
        private String email;
        private int age;
    }
}
