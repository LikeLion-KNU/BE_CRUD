package com.likelion.crud.dto;

import com.likelion.crud.entity.MemberRole;

public record MemberCreateReq(String email, String password, MemberRole role, String name, int age) {}
