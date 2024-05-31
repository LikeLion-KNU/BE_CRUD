package com.example.BE_Homework.domain.coupon.controller;

import com.example.BE_Homework.domain.coupon.dto.CouponReadRequestDto;
import com.example.BE_Homework.domain.coupon.dto.CouponUpdateRequestDto;
import com.example.BE_Homework.domain.coupon.entity.Coupon;
import com.example.BE_Homework.domain.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/coupons")
public class CouponController {
    private final CouponService couponService;

    // 쿠폰 생성
    @PostMapping
    public Coupon createCoupon(@RequestBody CouponReadRequestDto couponReadRequestDto){
        return couponService.createCoupon(couponReadRequestDto);
    }

    // 모든 쿠폰 조회
    @GetMapping
    public List<Coupon> findAllCoupons(){
        return couponService.getAllCoupons();
    }

    // 쿠폰 정보 수정
    @PutMapping
    public Coupon updateCoupon(@RequestBody CouponUpdateRequestDto couponUpdateRequestDto){
        return couponService.updateCoupon(couponUpdateRequestDto);
    }

    // 쿠폰 삭제
    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable("id") Long id){
        couponService.deleteCoupon(id);
    }

}
