package com.example.BE_Homework.controller;

import com.example.BE_Homework.dto.CouponReq;
import com.example.BE_Homework.entity.Coupon;
import com.example.BE_Homework.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupons")
public class CouponController {
    private final CouponService couponService;

    // 쿠폰 생성
    @PostMapping
    public Coupon createCoupon(@RequestBody CouponReq couponReq){
        return couponService.createCoupon(couponReq);
    }

    // 모든 쿠폰 조회
    @GetMapping
    public List<Coupon> findAllCoupons(){
        return couponService.getAllCoupons();
    }
    // 쿠폰 정보 수정
    @PutMapping
    public Coupon updateCoupon(@RequestBody Coupon coupon){
        return couponService.updateCoupon(coupon);
    }

    // 쿠폰 삭제
    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable Long id){
        couponService.deleteCoupon(id);
    }



}
