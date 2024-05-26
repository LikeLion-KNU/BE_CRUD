package com.likelion.crud.api.coupon.controller;

import com.likelion.crud.api.coupon.dto.request.AllocateCouponRequest;
import com.likelion.crud.domain.Coupon;
import com.likelion.crud.domain.Member;
import com.likelion.crud.domain.coupon.service.CouponHolderService;
import com.likelion.crud.domain.coupon.service.CouponService;
import com.likelion.crud.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberCouponController {

    private final MemberService memberService;
    private final CouponService couponService;
    private final CouponHolderService couponHolderService;

    @PostMapping("/member/{memberId}/coupon")
    public ResponseEntity<Void> allocateCouponToMember(
            @PathVariable Long memberId,
            @RequestBody AllocateCouponRequest request
    ) {
        Member member = memberService.getById(memberId);
        Coupon coupon = couponService.getById(request.couponId());

        couponHolderService.allocateCouponToMember(member, coupon);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/member/{memberId}/coupon")
    public ResponseEntity<List<Coupon>> getCouponsOfMember(@PathVariable Long memberId) {
        return ResponseEntity.ok(couponHolderService.findAllCouponByMemberId(memberId));
    }

    @DeleteMapping("/member/{memberId}/coupon")
    public ResponseEntity<Void> deleteAllCouponFromMember(@PathVariable Long memberId) {
        couponHolderService.deleteAllCouponFromMember(memberId);
        return ResponseEntity.noContent().build();
    }
}
