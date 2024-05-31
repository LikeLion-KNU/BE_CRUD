package com.example.BE_Homework.domain.member.dto;

import com.example.BE_Homework.domain.member.entity.Role;

public record MemberReq(String email, String password, Role role, String name, Integer age) {
}
