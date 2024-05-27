package com.example.BE_Homework.dto;

import com.example.BE_Homework.entity.enumType.Type;

import java.time.LocalDateTime;

public record CouponReq(Type couponType, Integer discount, LocalDateTime expirationDate) {
     
}
