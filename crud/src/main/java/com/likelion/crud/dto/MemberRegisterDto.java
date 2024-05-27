package com.likelion.crud.dto;

import com.likelion.crud.entity.Member;
import com.likelion.crud.entity.Role;
import lombok.Getter;

@Getter
public class MemberRegisterDto {
    @Getter
    public static class Response {
        private String name;
        private String password;
        private String email;
        private int age;
        private Role role;

        public void update(Member member) {
            name = member.getName();
            password = member.getPassword();
            email = member.getEmail();
            age = member.getAge();
            role = member.getRole();
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
