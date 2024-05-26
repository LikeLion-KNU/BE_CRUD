package com.likelion.crud.api.coupon.dto.response;

import com.likelion.crud.domain.Coupon;
import com.likelion.crud.domain.CouponType;

public record UpdateCouponResponse(
        CouponType couponType,
        Integer discount
) {

    public static UpdateCouponResponse of(Coupon coupon) {
        return new UpdateCouponResponse(
                coupon.type(),
                coupon.discount()
        );
    }
}
