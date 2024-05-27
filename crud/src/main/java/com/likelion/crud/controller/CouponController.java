package com.likelion.crud.controller;

import com.likelion.crud.dto.CouponRegisterDto;
import com.likelion.crud.dto.CouponUpdateDto;
import com.likelion.crud.entity.Coupon;
import com.likelion.crud.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;
    //생성
    @PostMapping("/coupon/register")
    public CouponRegisterDto.Response registerCoupon(CouponRegisterDto.Request couponRegisterDtoRequest) {
        return couponService.registerCoupon(couponRegisterDtoRequest);
    }
    //모든 조회
    @GetMapping("/coupon/getAll")
    public List<Coupon> findAllCoupon() {
        return couponService.findCouponAll();
    }

    //삭제
    @DeleteMapping("/coupon/delete/{id}")
    public void deleteCouponById(@PathVariable("id") Long couponId) {
        couponService.deleteCoupon(couponId);
    }
    //수정
    @PutMapping("/coupon/edit/{id}")
    public CouponUpdateDto.Response editCouponById(@PathVariable("id") Long couponId, @RequestBody CouponUpdateDto.Request couponUpdateDtoRequest) {
        return couponService.updateCoupon(couponId, couponUpdateDtoRequest);
    }
}
