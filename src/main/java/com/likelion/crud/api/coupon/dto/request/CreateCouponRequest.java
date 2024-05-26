package com.likelion.crud.api.coupon.dto.request;

import com.likelion.crud.domain.CouponType;

public record CreateCouponRequest(
        CouponType couponType,
        Integer discount,
        Long expiration
) {
}
