package com.LikeLion.CRUD.Entity.Coupon;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum CouponType {
    PERCENTAGE, FIXED_AMOUNT;

    @JsonCreator
    public static CouponType toCoupnType(String couponType){
        return Stream.of(CouponType.values())
                .filter(value -> value.toString().equals(couponType))
                .findFirst()
                .orElse(null);

    }
}
