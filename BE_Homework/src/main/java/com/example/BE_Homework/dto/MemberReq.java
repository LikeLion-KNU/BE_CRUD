package com.example.BE_Homework.dto;

import com.example.BE_Homework.entity.enumType.Role;

public record MemberReq(String email, String password, Role role, String name, Integer age) {
}
