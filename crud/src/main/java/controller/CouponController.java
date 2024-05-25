package controller;

import dto.coupon.CouponRegisterRequestDTO;
import domain.Coupon;
import dto.coupon.CouponRegisterResponseDTO;
import dto.coupon.CouponUpdateRequestDTO;
import Service.CouponService;
import dto.coupon.CouponUpdateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/coupons")
public class CouponController {

    private final CouponService couponService;
    /*
    쿠폰 등록
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public CouponRegisterResponseDTO registerCoupon(@RequestBody CouponRegisterRequestDTO couponRegisterRequestDTO){
        return couponService.registerCoupon(couponRegisterRequestDTO);
    }
    /*
    모든 쿠폰 조회
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<Coupon> findAllCoupons(){
        return couponService.findAllCoupons();
    }
    /*
    쿠폰 정보 수정
     */
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{couponId}")
    public CouponUpdateResponseDTO editCoupon(@PathVariable Long couponId, @RequestBody CouponUpdateRequestDTO couponUpdateRequestDTO){
        return couponService.editCoupon(couponId, couponUpdateRequestDTO);
    }
    /*
    쿠폰 삭제
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{couponId}")
    public void deleteCoupon(@PathVariable Long couponId){
        couponService.deleteCoupon(couponId);
    }

    /*
    특정 회원에게 쿠폰 할당
     */
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/assign/{memberId}/{couponId}")
    public Long assignCouponToMember(@PathVariable Long memberId, @PathVariable Long couponId){
        return couponService.assignCouponToMember(memberId, couponId);
    }
    /*
    회원 ID로 해당 회원이 보유하고 있는 쿠폰 조회
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{memberId}")
    public List<Coupon> findCouponsFromMember(@PathVariable Long memberId){
        return couponService.findCouponsByMemberId(memberId);
    }
    /*
    특정 회원의 쿠폰 삭제
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{memberId}/{couponId}")
    public void deleteCouponFromMember(@PathVariable Long memberId, @PathVariable Long couponId){
        couponService.deleteCouponFromMember(memberId,couponId);
    }

}
