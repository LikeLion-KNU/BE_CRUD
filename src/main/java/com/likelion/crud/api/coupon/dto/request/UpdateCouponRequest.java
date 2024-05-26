package com.likelion.crud.api.coupon.dto.request;

import com.likelion.crud.domain.CouponType;

public record UpdateCouponRequest(
        CouponType couponType,
        Integer discount
) {
}
