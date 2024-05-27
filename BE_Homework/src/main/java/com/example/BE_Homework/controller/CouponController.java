package com.example.BE_Homework.controller;

import com.example.BE_Homework.dto.CouponReq;
import com.example.BE_Homework.entity.Coupon;
import com.example.BE_Homework.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupons")
public class CouponController {
    private final CouponService couponService;


    public Coupon createCoupon(@RequestBody CouponReq conponReq){
        return couponService.createCoupon(conponReq);
    }


}
