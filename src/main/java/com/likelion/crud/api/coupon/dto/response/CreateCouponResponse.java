package com.likelion.crud.api.coupon.dto.response;

import com.likelion.crud.domain.Coupon;
import com.likelion.crud.domain.CouponType;

import java.time.LocalDateTime;

public record CreateCouponResponse(
        Long couponId,
        CouponType couponType,
        LocalDateTime issueDate,
        LocalDateTime expirationDate
) {

    public static CreateCouponResponse of(Coupon coupon) {
        return new CreateCouponResponse(
                coupon.couponId(),
                coupon.type(),
                coupon.issueDate(),
                coupon.expirationDate()
        );
    }

}
