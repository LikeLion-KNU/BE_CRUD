package com.likelion.crud.domain;


import java.time.LocalDateTime;

public record Coupon(
        Long couponId,
        CouponType type,
        Integer discount,
        LocalDateTime issueDate,
        LocalDateTime expirationDate
) {
}
