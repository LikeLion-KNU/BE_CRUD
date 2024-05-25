package com.likelion.crud.dto;

import com.likelion.crud.entity.CouponType;

import java.time.LocalDateTime;

public record CouponCreateReq (CouponType type, Integer discount, LocalDateTime expirationDate) {}
