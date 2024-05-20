package Assignment.crud.api;

import Assignment.crud.domain.CouponHolders;
import Assignment.crud.dto.CouponHoldersResponseDto;
import Assignment.crud.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@RestController
@RequiredArgsConstructor
public class MemberCouponController {

    private final CouponService couponService;

    /**
     *모든 쿠폰 보유자 조회
     */
    @GetMapping("/api/memberCoupon")
    public ResponseEntity<?> getAllCouponHolders() {

        List<CouponHoldersResponseDto> holders = couponService.getAllCouponHolders()
                .stream()
                .map(CouponHoldersResponseDto::new)
                .collect(toList());

        return ResponseEntity.ok()
                .body(holders);
    }

    /**
     *특정 회원에게 쿠폰 할당
     */
    @PostMapping("/api/memberCoupon")
    public ResponseEntity<?> assignCouponToMember(@RequestParam("memberId") Long memberId,
                                                  @RequestParam("couponId") Long couponId) {

        CouponHolders couponHolder = couponService.assignCouponToMember(memberId, couponId);

        return ResponseEntity.ok()
                .body(new CouponHoldersResponseDto(couponHolder));
    }

    /**
     *회원ID로 해당 회원이 보유하고 있는 쿠폰 조회
     */
    @GetMapping("/api/memberCoupon/member/{id}")
    public ResponseEntity<?> findCouponHoldersByMemberId(@PathVariable("id") Long id) {

        List<CouponHoldersResponseDto> holders = couponService.getCouponsByMemberId(id)
                .stream()
                .map(CouponHoldersResponseDto::new)
                .collect(toList());

        return ResponseEntity.ok()
                .body(holders);
    }

    /**
     *쿠폰ID로 해당 쿠폰을 보유하고 있는 회원 조회
     */
    @GetMapping("/api/memberCoupon/coupon/{id}")
    public ResponseEntity<?> findCouponHoldersByCouponId(@PathVariable("id") Long id) {

        List<CouponHoldersResponseDto> holders = couponService.getMembersByCouponId(id)
                .stream()
                .map(CouponHoldersResponseDto::new)
                .collect(toList());

        return ResponseEntity.ok()
                .body(holders);
    }

    /**
     *특정 회원의 쿠폰 삭제
     */
    @DeleteMapping("/api/memberCoupon/delete")
    public ResponseEntity<?> deleteCouponFromMember(@RequestParam("memberId") Long memberId,
                                                       @RequestParam("couponId") Long couponId) {

        couponService.deleteCouponFromMember(memberId, couponId);

        return ResponseEntity.noContent().build();
    }

}
