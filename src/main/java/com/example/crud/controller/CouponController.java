package com.example.crud.controller;

import com.example.crud.dto.coupon.CreateCouponDto.CreateCouponRequest;
import com.example.crud.dto.coupon.CreateCouponDto.CreateCouponResponse;
import com.example.crud.dto.coupon.SimpleCouponDto;
import com.example.crud.dto.coupon.SimpleCouponHolderDto;
import com.example.crud.dto.coupon.UpdateCouponDto.UpdateCouponRequest;
import com.example.crud.dto.coupon.UpdateCouponDto.UpdateCouponResponse;
import com.example.crud.dto.member.SimpleMemberDto;
import com.example.crud.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RequestMapping("/coupon")
@RestController
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping("/create")
    public ResponseEntity<CreateCouponResponse> createCoupon(@RequestBody CreateCouponRequest request){
        return ResponseEntity
                .status(CREATED)
                .body(couponService.createCoupon(request));
    }

    @PostMapping("/delete/{couponId}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable("couponId") Long couponId){
        couponService.deleteCoupon(couponId);
        return ResponseEntity
                .status(NO_CONTENT)
                .body(null);
    }

    @PostMapping("/couponHolder/delete/{memberId}")
    public ResponseEntity<Void> deleteCouponHolder(
            @PathVariable("memberId") Long memberId
    ){
        couponService.deleteCouponHolderByMember(memberId);
        return ResponseEntity
                .status(NO_CONTENT)
                .body(null);
    }

    @PostMapping("/update")
    public ResponseEntity<UpdateCouponResponse> updateCoupon(@RequestBody UpdateCouponRequest request){
        return ResponseEntity
                .status(OK)
                .body(couponService.updateCoupon(request));
    }

    @PostMapping("/allocate")
    public ResponseEntity<Void> allocateCoupon(
            @RequestParam("memberId") Long memberId,
            @RequestParam("couponId") Long couponId
    ){
        couponService.allocateCoupon(memberId, couponId);
        return ResponseEntity
                .status(CREATED)
                .body(null);
    }

    @GetMapping("/couponHolders")
    public ResponseEntity<List<SimpleCouponHolderDto>> findAllCouponHolders(){
        return ResponseEntity
                .status(OK)
                .body(couponService.findAllCouponHolders());
    }

    @GetMapping("/coupons")
    public ResponseEntity<List<SimpleCouponDto>> findAll(){
        return ResponseEntity
                .status(OK)
                .body(couponService.findAllCoupons());
    }

    @GetMapping("/coupons/{memberId}")
    public ResponseEntity<List<SimpleCouponDto>> findCouponsByHolder(
            @PathVariable("memberId") Long memberId
    ){
        return ResponseEntity
                .status(OK)
                .body(couponService.findCouponsByMember(memberId));
    }

    @GetMapping("/couponHolders/{couponId}")
    public ResponseEntity<List<SimpleMemberDto>> findHoldersByCoupon(
            @PathVariable("couponId") Long couponId
    ){
        return ResponseEntity
                .status(OK)
                .body(couponService.findMembersByCoupon(couponId));
    }

}
