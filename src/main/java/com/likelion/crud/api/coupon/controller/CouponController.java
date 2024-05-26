package com.likelion.crud.api.coupon.controller;

import com.likelion.crud.api.coupon.CreateCouponRequestMapper;
import com.likelion.crud.api.coupon.UpdateCouponRequestMapper;
import com.likelion.crud.api.coupon.dto.request.CreateCouponRequest;
import com.likelion.crud.api.coupon.dto.request.UpdateCouponRequest;
import com.likelion.crud.api.coupon.dto.response.CreateCouponResponse;
import com.likelion.crud.api.coupon.dto.response.UpdateCouponResponse;
import com.likelion.crud.domain.Coupon;
import com.likelion.crud.domain.coupon.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;
    private final CreateCouponRequestMapper createRequestMapper;
    private final UpdateCouponRequestMapper updateRequestMapper;

    @PostMapping("/coupon")
    public ResponseEntity<CreateCouponResponse> createCoupon(
            @RequestBody CreateCouponRequest request
    ) {
        Coupon coupon = couponService.create(createRequestMapper.map(request));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(CreateCouponResponse.of(coupon));
    }

    @GetMapping("/coupon")
    public ResponseEntity<List<Coupon>> getAllCoupon() {
        return ResponseEntity.ok(couponService.findAll());
    }

    @PatchMapping("/coupon/{id}")
    public ResponseEntity<UpdateCouponResponse> updateCoupon(
            @PathVariable Long id,
            @RequestBody UpdateCouponRequest request
    ) {
        Coupon coupon = couponService.update(id, updateRequestMapper.map(request));
        return ResponseEntity.ok(UpdateCouponResponse.of(coupon));
    }

    @DeleteMapping("/coupon/{id}")
    public ResponseEntity<Void> deleteCoupon(@PathVariable Long id) {
        couponService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
