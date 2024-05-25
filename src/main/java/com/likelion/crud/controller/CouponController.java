package com.likelion.crud.controller;

import com.likelion.crud.dto.CouponCreateReq;
import com.likelion.crud.entity.Coupon;
import com.likelion.crud.entity.CouponHolder;
import com.likelion.crud.entity.Member;
import com.likelion.crud.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/coupons")
@RestController
public class CouponController {

    private final CouponService couponService;

    @Autowired
    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping()
    public Coupon createCoupon(@RequestBody CouponCreateReq couponCreateReq) {
        return couponService.createCoupon(couponCreateReq);
    }

    @GetMapping()
    public List<Coupon> getAllCoupons() {
        return couponService.getAllCoupons();
    }

    @PutMapping()
    public Coupon updateCoupon(@RequestBody Coupon coupon) {
        return couponService.updateCoupon(coupon);
    }

    @DeleteMapping("/{id}")
    public void deleteCoupon(@PathVariable Long id) {
        couponService.deleteCoupon(id);
    }

    @PostMapping("/holders")
    public void assignCouponToMember(@RequestParam Long memberId, @RequestParam Long couponId) {
        couponService.assignCouponToMember(memberId, couponId);
    }

    @GetMapping("/holders")
    public List<CouponHolder> getCouponHolders() {
        return couponService.getAllCouponHolders();
    }

    @GetMapping("/holders/member/{memberId}")
    public List<Coupon> getCouponsByMember(@PathVariable Long memberId) {
        return couponService.getCouponsByMember(memberId);
    }

    @GetMapping("/holders/coupon/{couponId}")
    public List<Member> getMembersByCoupon(@PathVariable Long couponId) {
        return couponService.getMembersByCoupon(couponId);
    }

    @DeleteMapping("/holders")
    public void removeCouponFromMember(@RequestParam Long memberId, @RequestParam Long couponId) {
        couponService.removeCouponFromMember(memberId, couponId);
    }

}
