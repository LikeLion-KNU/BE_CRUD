package com.likelion.crud.domain.coupon;

import com.likelion.crud.domain.CouponType;

public record CouponPatchDto(
        CouponType type,
        Integer discount
) {
}
