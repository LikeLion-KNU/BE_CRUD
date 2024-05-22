package likelion.demo.domain.holder.controller;

import likelion.demo.domain.coupon.dto.response.MemberWithAllCouponsResponse;
import likelion.demo.domain.coupon.service.CouponService;
import likelion.demo.domain.holder.dto.request.AssignCouponRequest;
import likelion.demo.domain.holder.dto.response.FindCouponByMemberId;
import likelion.demo.domain.holder.dto.response.FindMemberByCouponId;
import likelion.demo.domain.holder.service.CouponHolderService;
import likelion.demo.domain.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupon-holder")
public class CouponHolderController {


    private final CouponHolderService couponHolderService;
    @PostMapping("/assign")
    public ResponseEntity<Long> couponAssign(
            @RequestBody AssignCouponRequest assignCouponRequest
            )
    {
        Long couponHolderId = couponHolderService.AssignCouponToMember(assignCouponRequest);

        return ResponseEntity.ok().body(couponHolderId);
    }

    @DeleteMapping("/delete/{memberId}/{couponId}")
    public ResponseEntity<String> CouponHolderDelete(
            @PathVariable("memberId") Long memberId,
            @PathVariable("couponId") Long couponId
    ){
        couponHolderService.deleteMemberCoupon(memberId,couponId);

        return ResponseEntity.ok().body("특정 회원의 쿠폰 삭제 완료");
    }

    @GetMapping("/member-coupon/{memberId}")
    public ResponseEntity<List<FindMemberByCouponId>> memberAllCouponController(
            @PathVariable("memberId") Long id
     ){

        List<FindMemberByCouponId> findMemberRespons = couponHolderService.memberAllCouponService(id);

        return ResponseEntity.ok().body(findMemberRespons);
    }

    @GetMapping("/coupon-member/{couponId}")
    public ResponseEntity<List<FindCouponByMemberId>> memberHaveCouponContoller(
            @PathVariable("couponId") Long id
    ){

        List<FindCouponByMemberId> findCouponByMemberIds = couponHolderService.couponAllMemberService(id);

        return ResponseEntity.ok().body(findCouponByMemberIds);
    }

    /**
     * 모든 쿠폰을 가진 멤버 목록 조회
     * @return 모든 쿠폰을 가진 멤버 목록
     */
    @GetMapping("/members-with-all-coupons")
    public ResponseEntity<List<MemberWithAllCouponsResponse>> getMembersWithAllCoupons() {
        List<MemberWithAllCouponsResponse> members = couponHolderService.getMembersWithAllCoupons();
        return ResponseEntity.ok(members);
    }

}
