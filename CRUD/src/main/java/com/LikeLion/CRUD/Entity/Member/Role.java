package com.LikeLion.CRUD.Entity.Member;

import com.LikeLion.CRUD.Entity.Coupon.CouponType;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum Role {
    ADMIN, USER;

    @JsonCreator
    public static Role toRole(String role){
        return Stream.of(Role.values())
                .filter(value -> value.toString().equals(role))
                .findFirst()
                .orElse(null);

    }
}


