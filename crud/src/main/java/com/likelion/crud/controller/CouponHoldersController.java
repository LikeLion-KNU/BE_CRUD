package com.likelion.crud.controller;

import com.likelion.crud.entity.CouponHolders;
import com.likelion.crud.service.CouponHoldersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CouponHoldersController {

    private final CouponHoldersService couponHoldersService;

//    특정 회원에게 쿠폰 할당
    @PostMapping("/couponHolder/giveCoupon/{memberId}/{couponId}")
    public void giveCouponToMember(@PathVariable Long memberId, @PathVariable Long couponId) {
        couponHoldersService.giveCouponToMember(memberId, couponId);
    }
//    모든 쿠폰 보유자 조회
    @GetMapping("/couponHolder/get/All")
    public List<CouponHolders> findAllCouponHolder() {
        return couponHoldersService.findAllCouponHolders();
    }
//    회원ID로 해당 회원이 보유하고 있는 쿠폰 조회
    @GetMapping("/couponHolder/memberID/{memberId}")
    public List<CouponHolders> findCouponByMemberId(@PathVariable Long memberId) {
        return couponHoldersService.findByMemberId(memberId);
    }
//    쿠폰ID로 해당 쿠폰을 보유하고 있는 회원 조회
    @GetMapping("/couponHolder/couponID/{couponId}")
    public List<CouponHolders> findMemberByCouponId(@PathVariable Long couponId) {
        return couponHoldersService.findByCouponId(couponId);
    }
//    특정 회원의 쿠폰 삭제
    @DeleteMapping("/couponHolder/delete/{memberId}/{couponId}")
    public void deleteByMemberId(@PathVariable Long memberId, @PathVariable Long couponId) {
        couponHoldersService.deleteMemberCoupon(memberId, couponId);
    }
}
