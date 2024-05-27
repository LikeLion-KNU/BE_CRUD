package com.LikeLion.CRUD.controller.relationship;

import com.LikeLion.CRUD.dto.member.MemberInfoDTO;
import com.LikeLion.CRUD.entity.coupon.Coupon;
import com.LikeLion.CRUD.entity.relation.CouponHolders;
import com.LikeLion.CRUD.service.relationship.CouponHoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coupon-holders")
public class CouponHoldersController {

    @Autowired
    private CouponHoldersService couponHoldersService;

    // 모든 쿠폰 보유자 조회 -> DTO 사용
    @GetMapping
    public ResponseEntity<List<MemberInfoDTO>> getAllCouponHolders() {
        List<MemberInfoDTO> allCouponHolders = couponHoldersService.findAllCouponHolders();
        return ResponseEntity.ok().body(allCouponHolders);
    }

    // 회원ID로 해당 회원이 보유하고 있는 쿠폰 조회
    @GetMapping("/member/{memberId}")
    public ResponseEntity<List<Coupon>> getCouponsByMemberId(@PathVariable Long memberId) {
        return ResponseEntity.ok().body(couponHoldersService.findCouponsByMemberId(memberId));
    }

    // 쿠폰ID로 해당 쿠폰을 보유하고 있는 회원 조회 -> DTO 사용
    @GetMapping("/coupon/{couponId}")
    public ResponseEntity<List<MemberInfoDTO>> getMembersByCouponId(@PathVariable Long couponId) {
        List<MemberInfoDTO> members = couponHoldersService.findMembersByCouponId(couponId);
        return ResponseEntity.ok().body(members);
    }

    // 특정 회원에게 쿠폰 할당
    @PostMapping("/assign")
    public ResponseEntity<CouponHolders> assignCoupon(@RequestParam Long memberId, @RequestParam Long couponId) {
        return ResponseEntity.ok().body(couponHoldersService.assignCouponToMember(memberId, couponId));
    }

    // 특정 회원의 쿠폰 삭제
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCoupon(@RequestParam Long memberId, @RequestParam Long couponId) {
        couponHoldersService.deleteMemberCoupon(memberId, couponId);
        return ResponseEntity.ok().build();
    }
}

