package com.example.BE_Homework.domain.couponholders.controller;

import com.example.BE_Homework.domain.coupon.entity.Coupon;
import com.example.BE_Homework.domain.couponholders.entity.CouponHolders;
import com.example.BE_Homework.domain.member.entity.Member;
import com.example.BE_Homework.domain.coupon.service.CouponService;
import com.example.BE_Homework.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/holders")
public class CouponHolderController {
    private final CouponService couponService;
    private final MemberService memberService;

    // 특정 회원에게 쿠폰 할당
    @PostMapping()
    public void assignCouponToMember(@RequestParam Long couponId, @RequestParam Long memberId){
        couponService.assignCouponToMember(couponId, memberId);
    }
    // 모든 쿠폰 보유자 조회
    @GetMapping()
    public List<CouponHolders> findAllHolders(){
        return couponService.getAllCouponHolders();
    }
    // 회원 ID로 해당 회원이 보유하고 있는 쿠폰 조회
    @GetMapping("/members/{id}")
    public List<Coupon> findCouponsByMemberId(@PathVariable Long id){
        return couponService.findCouponsByMemberId(id);
    }
    // 쿠폰 ID로 해당 쿠폰을 보유하고 있는 회원 조회
    @GetMapping("/coupons/{id}")
    public List<Member> findMembersByCouponId(@PathVariable Long id){
        return couponService.findMembersByCouponId(id);
    }
    // 특정 회원의 (특정) 쿠폰 삭제
    @DeleteMapping()
    public void deleteCouponFromMember(@RequestParam Long couponId, @RequestParam Long memberId){
        couponService.deleteCouponFromMember(couponId, memberId);
    }

}
