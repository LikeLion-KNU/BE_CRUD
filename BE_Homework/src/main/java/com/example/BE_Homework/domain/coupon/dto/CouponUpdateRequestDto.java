package com.example.BE_Homework.domain.coupon.dto;

import com.example.BE_Homework.domain.coupon.entity.CouponType;

import java.time.LocalDateTime;

public record CouponUpdateRequestDto(Long id, CouponType couponType, Integer discount, LocalDateTime expirationDate) {
}
